/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.shereef;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.VCARD;

/**
 *
 * @author shereef.sakr
 */
public class TestRuleEngine {
    public static void main ( String[] args ) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();
        
        
        // some definitions
        String personURI    = "http://vodafonebillauditor/contract";
        String givenName    = "John";
        String familyName   = "Smith";
        String fullName     = givenName + " " + familyName;
        
        long startTime = System.currentTimeMillis() ;
        
        //Property numProp =  model.createProperty( "num" ) ;
        
        for ( int i = 0 ; i < 10 ; i++ ) {
            // create the resource
            //   and add the properties cascading style
            
            Resource johnSmith 
              = model.createResource(personURI + "/" +  i)
                     .addProperty(VCARD.FN, fullName + " " + i )
                    .addProperty(VCARD.Given, givenName + " " + i)
                    .addProperty(VCARD.Family, familyName + " " + i )
                     //.addProperty(numProp,  String.valueOf(i) )
                      /*
                     .addProperty(VCARD.N, 
                                  model.createResource()
                                       .addProperty(VCARD.Given, givenName + " " + i)
                                       .addProperty(VCARD.Family, familyName + " " + i) )
                             //*/
                     ;
            
            if ( ( i % 1000 ) == 0 )
                System.out.println ( i + " processed" ) ;
        }
        
        model.write(System.out ) ;
        
        //*
        // Add generic rule reasoner
        String rules = "[testRule: (?a http://www.w3.org/2001/vcard-rdf/3.0#Family \"Smith 4\" ) -> (?a http://www.w3.org/2001/vcard-rdf/3.0#Given \"shereef\" )]";
        Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
        reasoner.setDerivationLogging(true);
        InfModel inf = ModelFactory.createInfModel(reasoner, model);
        //*/
        
        // Validate
        /*
        ValidityReport report = inf.validate() ;
        
        System.out.println ( "Valid : " + report.isValid() ) ;
        //*/
        
        // list iterate
        /*
        StmtIterator iter =  inf.listStatements() ;
        
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement(); // get next statement
            Resource subject = stmt.getSubject(); // get the subject
            Property predicate = stmt.getPredicate(); // get the predicate
            RDFNode object = stmt.getObject(); // get the object
            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }
        //*/
        
        
        // now write the model in XML form to a file
        //model.write(System.out);
        inf.write(System.out);
        
        // Begin : execute query
        //*
        String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
"PREFIX vcard:<http://www.w3.org/2001/vcard-rdf/3.0#>\n" +
"SELECT ?familyname ?givenname\n" +
"WHERE { ?contact vcard:Family ?familyname.\n" +
"?contact vcard:Given ?givenname.\n" +
"  }" ;
        QueryExecution exec = QueryExecutionFactory.create( query , inf ) ;
        
        ResultSet rs = exec.execSelect() ;
        
        while ( rs.hasNext() ) {
            QuerySolution sol = rs.next() ;
            
            String printStr = "" ;
            
            for ( String resultVar : rs.getResultVars() ) {
                if ( sol.getLiteral(resultVar) != null ) {
                    String value = sol.getLiteral(resultVar).getString() ;
                    
                    printStr += ( resultVar + ":" + value + "," ) ;
                }
            }
            
            System.out.println( printStr ) ;
        }
        //*/
        // End : execute query
        
        long time = System.currentTimeMillis() - startTime ;
        
        System.out.println ( "Time executed : " + time  + " ms" ) ;
    }
}