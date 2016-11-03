package test.Test;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;

public class TestReasoner {
   public static void main(String args[]){
        String NS = "urn:x-hp-jena:eg/";
        // Build a trivial example data set
            //ont model
            OntModel ontModel = ModelFactory.createOntologyModel();
            Property p1 = ontModel.createProperty(NS, "p1");
            Property q1 = ontModel.createProperty(NS, "q1");
            ontModel.add(p1, RDFS.subPropertyOf, q1);
            ontModel.createResource(NS+"a1").addProperty(p1, "foo1");
            //rdf model
            Model rdfExample = ModelFactory.createDefaultModel();
            Property p2 = rdfExample.createProperty(NS, "p2");
            Property q2 = rdfExample.createProperty(NS, "q2");
            rdfExample.add(p2, RDFS.subPropertyOf, q2);
            rdfExample.createResource(NS+"a2").addProperty(p2, "foo2");
        //test 1
        Resource a1 = ontModel.getResource(NS+"a1");
        System.out.println("Statement_1: " + a1.getProperty(q1));
        //test 2
        InfModel inf = ModelFactory.createRDFSModel(rdfExample);
        Resource a2 = inf.getResource(NS+"a2");
        System.out.println("Statement_2: " + a2.getProperty(q2));
    }
}