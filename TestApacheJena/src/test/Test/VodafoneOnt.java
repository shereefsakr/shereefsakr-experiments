/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Test;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.sparql.util.DateTimeStruct;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.XSD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.helpers.DateTimeDateFormat;

/**
 *
 * @author Administrator
 */
public class VodafoneOnt {
    
    public static void main(String args[]){
        
        // create an empty model
        OntModel model = ModelFactory.createOntologyModel();
        // use the FileManager to find the input file
        InputStream in = FileManager.get().open("D:\\asset's projects developed by M.Sobhy\\afkarna\\01. Requirements\\References\\References - Organized\\Ontology\\Vodafone_Dynamic_Contract_profile_ontology.owl");
        if (in == null) {
            throw new IllegalArgumentException( "File:  not found");
        }
        // read the RDF/XML file
        model.read(new InputStreamReader(in), "");
        
        /////////////http://www.vodafone.com.eg/ontologies/2013/6/28/ContractProfileDynamicOntology#CP_Interval/////////////////////
        Model m = ModelFactory.createDefaultModel();
        OntClass cl = model.getOntClass("http://www.vodafone.com.eg/ontologies/2013/6/28/ContractProfileDynamicOntology#CP_Interval");
        Individual d = cl.createIndividual("http://www.vodafone.com.eg/ontologies/2013/6/28/ContractProfileDynamicOntology#st_tyime");
        DatatypeProperty g = model.getDatatypeProperty("http://www.vodafone.com.eg/ontologies/2013/6/28/ContractProfileDynamicOntology#IntStart");
        System.out.println(g.toString());
        ///////
        //XSDDateTime date = new XSDDateTime();
        DateTimeStruct s = DateTimeStruct.parseDate("2013-12-16");
        Statement statement = model.createStatement(d,g,s.toString());
        m.add(statement);
        System.out.println(cl.getLocalName());
        /////////////////////////////////
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Literal dateTime = m.createTypedLiteral("2013-12-12",XSDDatatype.XSDdateTime);
        Statement st = model.createStatement(d,g,dateTime);
        m.add(st);        
        try {
            m.write(new FileOutputStream("d://f.rdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VodafoneOnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
