/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shereefsakr.test.quartz;

import java.util.Date;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Sherif Saqr
 */
public class TestQuartz_simple01 {

    @PersistJobDataAfterExecution
    @DisallowConcurrentExecution
    public static class StatefulDumbJob implements Job {

        public static final String NUM_EXECUTIONS = "NumExecutions";
        public static final String EXECUTION_DELAY = "ExecutionDelay";

        public StatefulDumbJob() {
        }

        public void execute(JobExecutionContext context)
                throws JobExecutionException {
            System.out.println("---" + context.getJobDetail().getKey()
                    + " executing.[" + new Date() + "]");

            JobDataMap map = context.getJobDetail().getJobDataMap();

            int executeCount = 0;
            if (map.containsKey(NUM_EXECUTIONS)) {
                executeCount = map.getInt(NUM_EXECUTIONS);
            }

            executeCount++;
            map.put(NUM_EXECUTIONS, executeCount);

            long delay = 5000l;
            if (map.containsKey(EXECUTION_DELAY)) {
                delay = map.getLong(EXECUTION_DELAY);
            }

            try {
                //Thread.sleep(delay);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
            
            
            Object test = null ;
            
            //test.toString () ;
            

            System.out.println("  -" + context.getJobDetail().getKey()
                    + " complete (" + executeCount + ").");
            
            //JobExecutionException e2 = new JobExecutionException( new Exception () );
        	// this job will refire immediately
        	//e2.refireImmediately();
                //e2.setUnscheduleAllTriggers(true);
        	//throw e2;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler();

            JobDetail job = JobBuilder.newJob(StatefulDumbJob.class)
                    .withIdentity("statefulJob1", "group1")
                    .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 4000L)
                    .build();
            
            TriggerKey triggerKey = new TriggerKey("testReload") ;

            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey)
                    .startAt(new Date())
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever()
                    .withMisfireHandlingInstructionFireNow())
                    .build();

            sched.scheduleJob(job, trigger);
            
            sched.start();
            
            SimpleTrigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey)
                    .startAt(new Date())
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(2)
                            .repeatForever()
                    .withMisfireHandlingInstructionFireNow())
                    .build();
            
            
            sched.rescheduleJob(triggerKey, trigger2);
            
            Thread.sleep(9000);
            
            //sched.shutdown () ;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
