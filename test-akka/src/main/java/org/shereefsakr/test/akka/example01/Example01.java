/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.akka.example01;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.routing.RoundRobinRouter;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.FiniteDuration;

/**
 *
 * @author shereef
 */
public class Example01 {

    public static class JobManager {

        private JobManager() {
        }

        private static JobManager theInstance = null;

        private ActorSystem system = null;
        private ActorRef router = null;
        private final static int no_of_msgs = 10 * 1000000;

        public static JobManager getInstance() {
            if (theInstance == null) {
                theInstance = new JobManager();
            }

            return (theInstance);
        }

        public void init() {
            final int no_of_workers = 10;

            system = ActorSystem.create("LoadGeneratorApp");

            final ActorRef appManager = system.actorOf(
                    new Props(new UntypedActorFactory() {
                        public UntypedActor create() {
                            return new JobControllerActor(no_of_msgs);
                        }
                    }), "jobController");

            router = system.actorOf(new Props(new UntypedActorFactory() {
                public UntypedActor create() {
                    return new WorkerActor(appManager);
                }
            }).withRouter(new RoundRobinRouter(no_of_workers)));
        }
        
        private void generateLoad() {
		for (int i = no_of_msgs; i >= 0; i--) {
			router.tell("Job Id " + i + "# send");
		}
		System.out.println( new Date () + "All jobs sent successfully");
	}
    }

    private static class JobControllerActor extends UntypedActor {

        int count = 0;
        long startedTime = System.currentTimeMillis();
        int no_of_msgs = 0;

        @Override
        public void onReceive(Object message) throws Exception {

            if (message instanceof String) {
                if (((String) message).compareTo("Done") == 0) {
                    count++;
                    if (count == no_of_msgs) {
                        long now = System.currentTimeMillis();
                        System.out.println("All messages processed in "
                                + (now - startedTime) / 1000 + " seconds");

                        System.out.println("Total Number of messages processed "
                                + count);
                        getContext().system().shutdown();
                    }
                }
            }

        }

        public JobControllerActor(int no_of_msgs) {
            this.no_of_msgs = no_of_msgs;
        }
    }

    private static class WorkerActor extends UntypedActor {

        private ActorRef jobController;

        @Override
        public void onReceive(Object message) throws Exception {
            // using scheduler to send the reply after 1000 milliseconds
            getContext()
                    .system()
                    .scheduler()
                    .scheduleOnce(FiniteDuration.create(1000, TimeUnit.MILLISECONDS),
                            jobController, "Done", getContext().dispatcher());
        }

        public WorkerActor(ActorRef inJobController) {
            jobController = inJobController;
        }
    }

    public static void main(String[] args) {
        JobManager jobManager = JobManager.getInstance() ;
        
        jobManager.init();
        
        System.out.println ( new Date () + "before load generation" ) ;
        jobManager.generateLoad();
    }
}