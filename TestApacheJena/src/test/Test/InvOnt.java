package test.Test;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.XSD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvOnt {
  
    public static final String NS = "http://www.vodafone.com.eg/ontologies/2013-12/contract-bill-ontology-01#";
    
    public static void main(String[] args)  {
        try {
            //create ontology
            createOntology();
        } catch (FileNotFoundException ex) {
              ex.printStackTrace();
        }
    }
    
    public static void createOntology() throws FileNotFoundException{
        
        //ontology and RDF models
        OntModel m = ModelFactory.createOntologyModel();
        Model model = ModelFactory.createDefaultModel();
        model.setNsPrefix("vodafone", NS);
         
        /*
         *create classes of vodafone contract's ontology 
        */
        OntClass inv = m.createClass(NS + "Invoice" );
        OntClass customer = m.createClass(NS+"Customer" );
        OntClass contract = m.createClass(NS+"Contract" );
        OntClass chargeItem = m.createClass(NS+"ChargeItem" );
        OntClass promo = m.createClass(NS+"Promo" );
        OntClass service = m.createClass(NS+"Service" );
        //create object properties between classes 
        //bill has customer
        ObjectProperty hasCustomer = m.createObjectProperty(NS+"hasCustomer");
        hasCustomer.addRange(customer);
        hasCustomer.addDomain(inv);
        //customer has contract
        ObjectProperty hasContract = m.createObjectProperty(NS+"hasContract");
        hasContract.addRange(contract);
        hasContract.addDomain(customer);
        //contract has service
        ObjectProperty hasService = m.createObjectProperty(NS+"hasService");
        hasService.addRange(service);
        hasService.addDomain(contract);
        //customer has chargeItem
        ObjectProperty hasChargeItem = m.createObjectProperty(NS+"hasChargeItem");
        hasChargeItem.addRange(chargeItem);
        hasChargeItem.addDomain(customer);
        //contract has chargeItem
        hasChargeItem.addDomain(contract);
        //service has chargeItem
        hasChargeItem.addDomain(service);
        //promo applied to chargeItem
        //ObjectProperty hasDiscount = m.createObjectProperty(NS+"hasDiscount");
        //hasDiscount.addRange(promo);
        //hasDiscount.addDomain(chargeItem);
        
        /*
         * properties of bill
         */
        DatatypeProperty invBillingMode = m.createDatatypeProperty(NS+"invBillingMode");
        invBillingMode.setDomain(inv);
        invBillingMode.setRange(XSD.xstring);
        DatatypeProperty invType = m.createDatatypeProperty(NS+"invType");
        invType.setDomain(inv);       
        invType.setRange(XSD.xstring);
        /*
         * properties of chargeItem
         */
        DatatypeProperty hasId = m.createDatatypeProperty(NS+"hasId");
        invBillingMode.setDomain(chargeItem);
        invBillingMode.setRange(XSD.xstring);
        DatatypeProperty hasAmount = m.createDatatypeProperty(NS+"hasAmount");
        invType.setDomain(chargeItem);       
        invType.setRange(XSD.xstring);
        DatatypeProperty hasCurrCode = m.createDatatypeProperty(NS+"hasCurrCode");
        invBillingMode.setDomain(chargeItem);
        invBillingMode.setRange(XSD.xstring);
        DatatypeProperty hasType = m.createDatatypeProperty(NS+"hasType");
        invType.setDomain(chargeItem);       
        invType.setRange(XSD.xstring);
        DatatypeProperty hasPT = m.createDatatypeProperty(NS+"hasPT");
        invBillingMode.setDomain(chargeItem);
        invBillingMode.setRange(XSD.xstring);
        
        
        
        /*
         * bill one
        */
        
        //root of bill one
        Individual inv_1 = inv.createIndividual(NS+"inv_1");
        Literal invType_1 = m.createTypedLiteral("INV");
        Literal billingMode_1 = m.createTypedLiteral("REG");
        //customer
        Individual customer_1 = customer.createIndividual(NS+"customer_1");
        //contracts
        Individual contract_1_1 = contract.createIndividual(NS+"contract_1_1");
        Individual contract_2_1 = contract.createIndividual(NS+"contract_2_1");
        Individual contract_3_1 = contract.createIndividual(NS+"contract_3_1");
        //services
        Individual service_1_1 = service.createIndividual(NS+"service_1_1");
        Individual service_2_1 = service.createIndividual(NS+"service_2_1");
        Individual service_3_1 = service.createIndividual(NS+"service_3_1");
        Individual service_4_1 = service.createIndividual(NS+"service_4_1");
        Individual service_5_1 = service.createIndividual(NS+"service_5_1");
        Individual service_6_1 = service.createIndividual(NS+"service_6_1");
        Individual service_7_1 = service.createIndividual(NS+"service_7_1");
        Individual service_8_1 = service.createIndividual(NS+"service_8_1");
        Individual service_9_1 = service.createIndividual(NS+"service_9_1");
        Individual service_10_1 = service.createIndividual(NS+"service_10_1");
        //chargeitems
        Individual chargeItem_1_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_1 = m.createTypedLiteral("99");
        Literal amount_1 = m.createTypedLiteral("0.52");
        Literal currCode_1 = m.createTypedLiteral("EGP");
        Literal type_1 = m.createTypedLiteral("9");
        Literal pt_1 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_1_1, hasId, id_1));
        model.add(model.createStatement(chargeItem_1_1, hasAmount, amount_1));
        model.add(model.createStatement(chargeItem_1_1, hasCurrCode, currCode_1));
        model.add(model.createStatement(chargeItem_1_1, hasType, type_1));
        model.add(model.createStatement(chargeItem_1_1, hasPT, pt_1));
        Individual chargeItem_2_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_2 = m.createTypedLiteral("99");
        Literal amount_2 = m.createTypedLiteral("0.52");
        Literal currCode_2 = m.createTypedLiteral("EGP");
        Literal type_2 = m.createTypedLiteral("9");
        Literal pt_2 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_2_1, hasId, id_2));
        model.add(model.createStatement(chargeItem_2_1, hasAmount, amount_2));
        model.add(model.createStatement(chargeItem_2_1, hasCurrCode, currCode_2));
        model.add(model.createStatement(chargeItem_2_1, hasType, type_2));
        model.add(model.createStatement(chargeItem_2_1, hasPT, pt_2));
        Individual chargeItem_3_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_3 = m.createTypedLiteral("99");
        Literal amount_3 = m.createTypedLiteral("0.52");
        Literal currCode_3 = m.createTypedLiteral("EGP");
        Literal type_3 = m.createTypedLiteral("9");
        Literal pt_3 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_3_1, hasId, id_3));
        model.add(model.createStatement(chargeItem_3_1, hasAmount, amount_3));
        model.add(model.createStatement(chargeItem_3_1, hasCurrCode, currCode_3));
        model.add(model.createStatement(chargeItem_3_1, hasType, type_3));
        model.add(model.createStatement(chargeItem_3_1, hasPT, pt_3));
        Individual chargeItem_4_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_4 = m.createTypedLiteral("99");
        Literal amount_4 = m.createTypedLiteral("0.52");
        Literal currCode_4 = m.createTypedLiteral("EGP");
        Literal type_4 = m.createTypedLiteral("9");
        Literal pt_4 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_4_1, hasId, id_4));
        model.add(model.createStatement(chargeItem_4_1, hasAmount, amount_4));
        model.add(model.createStatement(chargeItem_4_1, hasCurrCode, currCode_4));
        model.add(model.createStatement(chargeItem_4_1, hasType, type_4));
        model.add(model.createStatement(chargeItem_4_1, hasPT, pt_4));
        Individual chargeItem_5_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_5 = m.createTypedLiteral("99");
        Literal amount_5 = m.createTypedLiteral("0.52");
        Literal currCode_5 = m.createTypedLiteral("EGP");
        Literal type_5 = m.createTypedLiteral("9");
        Literal pt_5 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_5_1, hasId, id_5));
        model.add(model.createStatement(chargeItem_5_1, hasAmount, amount_5));
        model.add(model.createStatement(chargeItem_5_1, hasCurrCode, currCode_5));
        model.add(model.createStatement(chargeItem_5_1, hasType, type_5));
        model.add(model.createStatement(chargeItem_5_1, hasPT, pt_5));
        Individual chargeItem_6_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_6 = m.createTypedLiteral("99");
        Literal amount_6 = m.createTypedLiteral("0.52");
        Literal currCode_6 = m.createTypedLiteral("EGP");
        Literal type_6 = m.createTypedLiteral("9");
        Literal pt_6 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_6_1, hasId, id_6));
        model.add(model.createStatement(chargeItem_6_1, hasAmount, amount_6));
        model.add(model.createStatement(chargeItem_6_1, hasCurrCode, currCode_6));
        model.add(model.createStatement(chargeItem_6_1, hasType, type_6));
        model.add(model.createStatement(chargeItem_6_1, hasPT, pt_6));
        Individual chargeItem_7_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_7 = m.createTypedLiteral("99");
        Literal amount_7 = m.createTypedLiteral("0.52");
        Literal currCode_7 = m.createTypedLiteral("EGP");
        Literal type_7 = m.createTypedLiteral("9");
        Literal pt_7 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_7_1, hasId, id_7));
        model.add(model.createStatement(chargeItem_7_1, hasAmount, amount_7));
        model.add(model.createStatement(chargeItem_7_1, hasCurrCode, currCode_7));
        model.add(model.createStatement(chargeItem_7_1, hasType, type_7));
        model.add(model.createStatement(chargeItem_7_1, hasPT, pt_7));
        Individual chargeItem_8_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_8 = m.createTypedLiteral("99");
        Literal amount_8 = m.createTypedLiteral("0.52");
        Literal currCode_8 = m.createTypedLiteral("EGP");
        Literal type_8 = m.createTypedLiteral("9");
        Literal pt_8 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_8_1, hasId, id_8));
        model.add(model.createStatement(chargeItem_8_1, hasAmount, amount_8));
        model.add(model.createStatement(chargeItem_8_1, hasCurrCode, currCode_8));
        model.add(model.createStatement(chargeItem_8_1, hasType, type_8));
        model.add(model.createStatement(chargeItem_8_1, hasPT, pt_8));
        Individual chargeItem_9_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_9 = m.createTypedLiteral("99");
        Literal amount_9 = m.createTypedLiteral("0.52");
        Literal currCode_9 = m.createTypedLiteral("EGP");
        Literal type_9 = m.createTypedLiteral("9");
        Literal pt_9 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_9_1, hasId, id_9));
        model.add(model.createStatement(chargeItem_9_1, hasAmount, amount_9));
        model.add(model.createStatement(chargeItem_9_1, hasCurrCode, currCode_9));
        model.add(model.createStatement(chargeItem_9_1, hasType, type_9));
        model.add(model.createStatement(chargeItem_9_1, hasPT, pt_9));
        Individual chargeItem_10_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_10 = m.createTypedLiteral("99");
        Literal amount_10 = m.createTypedLiteral("0.52");
        Literal currCode_10 = m.createTypedLiteral("EGP");
        Literal type_10 = m.createTypedLiteral("9");
        Literal pt_10 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_10_1, hasId, id_10));
        model.add(model.createStatement(chargeItem_10_1, hasAmount, amount_10));
        model.add(model.createStatement(chargeItem_10_1, hasCurrCode, currCode_10));
        model.add(model.createStatement(chargeItem_10_1, hasType, type_10));
        model.add(model.createStatement(chargeItem_10_1, hasPT, pt_10));
        Individual chargeItem_11_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_11 = m.createTypedLiteral("99");
        Literal amount_11 = m.createTypedLiteral("0.52");
        Literal currCode_11 = m.createTypedLiteral("EGP");
        Literal type_11 = m.createTypedLiteral("9");
        Literal pt_11 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_11_1, hasId, id_11));
        model.add(model.createStatement(chargeItem_11_1, hasAmount, amount_11));
        model.add(model.createStatement(chargeItem_11_1, hasCurrCode, currCode_11));
        model.add(model.createStatement(chargeItem_11_1, hasType, type_11));
        model.add(model.createStatement(chargeItem_11_1, hasPT, pt_11));
        Individual chargeItem_12_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_12 = m.createTypedLiteral("99");
        Literal amount_12 = m.createTypedLiteral("0.52");
        Literal currCode_12 = m.createTypedLiteral("EGP");
        Literal type_12 = m.createTypedLiteral("9");
        Literal pt_12 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_12_1, hasId, id_12));
        model.add(model.createStatement(chargeItem_12_1, hasAmount, amount_12));
        model.add(model.createStatement(chargeItem_12_1, hasCurrCode, currCode_12));
        model.add(model.createStatement(chargeItem_12_1, hasType, type_12));
        model.add(model.createStatement(chargeItem_12_1, hasPT, pt_12));
        Individual chargeItem_13_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_13 = m.createTypedLiteral("99");
        Literal amount_13 = m.createTypedLiteral("0.52");
        Literal currCode_13 = m.createTypedLiteral("EGP");
        Literal type_13 = m.createTypedLiteral("9");
        Literal pt_13 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_13_1, hasId, id_13));
        model.add(model.createStatement(chargeItem_13_1, hasAmount, amount_13));
        model.add(model.createStatement(chargeItem_13_1, hasCurrCode, currCode_13));
        model.add(model.createStatement(chargeItem_13_1, hasType, type_13));
        model.add(model.createStatement(chargeItem_13_1, hasPT, pt_13));
        Individual chargeItem_14_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_14 = m.createTypedLiteral("99");
        Literal amount_14 = m.createTypedLiteral("0.52");
        Literal currCode_14 = m.createTypedLiteral("EGP");
        Literal type_14 = m.createTypedLiteral("9");
        Literal pt_14 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_14_1, hasId, id_14));
        model.add(model.createStatement(chargeItem_14_1, hasAmount, amount_14));
        model.add(model.createStatement(chargeItem_14_1, hasCurrCode, currCode_14));
        model.add(model.createStatement(chargeItem_14_1, hasType, type_14));
        model.add(model.createStatement(chargeItem_14_1, hasPT, pt_14));
        Individual chargeItem_15_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_15 = m.createTypedLiteral("99");
        Literal amount_15 = m.createTypedLiteral("0.52");
        Literal currCode_15 = m.createTypedLiteral("EGP");
        Literal type_15 = m.createTypedLiteral("9");
        Literal pt_15 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_15_1, hasId, id_15));
        model.add(model.createStatement(chargeItem_15_1, hasAmount, amount_15));
        model.add(model.createStatement(chargeItem_15_1, hasCurrCode, currCode_15));
        model.add(model.createStatement(chargeItem_15_1, hasType, type_15));
        model.add(model.createStatement(chargeItem_15_1, hasPT, pt_15));
        Individual chargeItem_16_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_16 = m.createTypedLiteral("99");
        Literal amount_16 = m.createTypedLiteral("0.52");
        Literal currCode_16 = m.createTypedLiteral("EGP");
        Literal type_16 = m.createTypedLiteral("9");
        Literal pt_16 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_16_1, hasId, id_16));
        model.add(model.createStatement(chargeItem_16_1, hasAmount, amount_16));
        model.add(model.createStatement(chargeItem_16_1, hasCurrCode, currCode_16));
        model.add(model.createStatement(chargeItem_16_1, hasType, type_16));
        model.add(model.createStatement(chargeItem_16_1, hasPT, pt_16));
        Individual chargeItem_17_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_17 = m.createTypedLiteral("99");
        Literal amount_17 = m.createTypedLiteral("0.52");
        Literal currCode_17 = m.createTypedLiteral("EGP");
        Literal type_17 = m.createTypedLiteral("9");
        Literal pt_17 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_17_1, hasId, id_17));
        model.add(model.createStatement(chargeItem_17_1, hasAmount, amount_17));
        model.add(model.createStatement(chargeItem_17_1, hasCurrCode, currCode_17));
        model.add(model.createStatement(chargeItem_17_1, hasType, type_17));
        model.add(model.createStatement(chargeItem_17_1, hasPT, pt_17));
        Individual chargeItem_18_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_18 = m.createTypedLiteral("99");
        Literal amount_18 = m.createTypedLiteral("0.52");
        Literal currCode_18 = m.createTypedLiteral("EGP");
        Literal type_18 = m.createTypedLiteral("9");
        Literal pt_18 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_18_1, hasId, id_18));
        model.add(model.createStatement(chargeItem_18_1, hasAmount, amount_18));
        model.add(model.createStatement(chargeItem_18_1, hasCurrCode, currCode_18));
        model.add(model.createStatement(chargeItem_18_1, hasType, type_18));
        model.add(model.createStatement(chargeItem_18_1, hasPT, pt_18));
        Individual chargeItem_19_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_19 = m.createTypedLiteral("99");
        Literal amount_19 = m.createTypedLiteral("0.52");
        Literal currCode_19 = m.createTypedLiteral("EGP");
        Literal type_19 = m.createTypedLiteral("9");
        Literal pt_19 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_19_1, hasId, id_19));
        model.add(model.createStatement(chargeItem_19_1, hasAmount, amount_19));
        model.add(model.createStatement(chargeItem_19_1, hasCurrCode, currCode_19));
        model.add(model.createStatement(chargeItem_19_1, hasType, type_19));
        model.add(model.createStatement(chargeItem_19_1, hasPT, pt_19));
        Individual chargeItem_20_1 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_20 = m.createTypedLiteral("99");
        Literal amount_20 = m.createTypedLiteral("0.52");
        Literal currCode_20 = m.createTypedLiteral("EGP");
        Literal type_20 = m.createTypedLiteral("9");
        Literal pt_20 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_20_1, hasId, id_20));
        model.add(model.createStatement(chargeItem_20_1, hasAmount, amount_20));
        model.add(model.createStatement(chargeItem_20_1, hasCurrCode, currCode_20));
        model.add(model.createStatement(chargeItem_20_1, hasType, type_20));
        model.add(model.createStatement(chargeItem_20_1, hasPT, pt_20));
        
        /*
         * relations betwwn individual
         */
        //bill one
        model.add(model.createStatement(inv_1, invType, invType_1));
        model.add(model.createStatement(inv_1, invBillingMode, billingMode_1));
        model.add(model.createStatement(inv_1, hasCustomer, customer_1));
        
        model.add(model.createStatement(customer_1, hasContract, contract_1_1));
        model.add(model.createStatement(customer_1, hasContract, contract_2_1));
        model.add(model.createStatement(customer_1, hasContract, contract_3_1));
        model.add(model.createStatement(customer_1, hasChargeItem, chargeItem_1_1));
        model.add(model.createStatement(customer_1, hasChargeItem, chargeItem_2_1));
        
        model.add(model.createStatement(contract_1_1, hasService, service_1_1));
        model.add(model.createStatement(contract_1_1, hasService, service_2_1));
        model.add(model.createStatement(contract_1_1, hasService, service_3_1));
        model.add(model.createStatement(contract_1_1, hasChargeItem, chargeItem_3_1));
        model.add(model.createStatement(contract_1_1, hasChargeItem, chargeItem_4_1));
        
        model.add(model.createStatement(contract_2_1, hasService, service_4_1));
        model.add(model.createStatement(contract_2_1, hasService, service_5_1));
        model.add(model.createStatement(contract_2_1, hasService, service_6_1));
        model.add(model.createStatement(contract_2_1, hasChargeItem, chargeItem_5_1));
        model.add(model.createStatement(contract_2_1, hasChargeItem, chargeItem_6_1));
        
        model.add(model.createStatement(contract_3_1, hasService, service_7_1));
        model.add(model.createStatement(contract_3_1, hasService, service_8_1));
        model.add(model.createStatement(contract_3_1, hasService, service_9_1));
        model.add(model.createStatement(contract_3_1, hasChargeItem, chargeItem_7_1));
        model.add(model.createStatement(contract_3_1, hasChargeItem, chargeItem_8_1));
        
        
        model.add(model.createStatement(service_1_1, hasChargeItem, chargeItem_9_1));
        model.add(model.createStatement(service_2_1, hasChargeItem, chargeItem_10_1));
        model.add(model.createStatement(service_3_1, hasChargeItem, chargeItem_11_1));
        model.add(model.createStatement(service_4_1, hasChargeItem, chargeItem_12_1));
        model.add(model.createStatement(service_5_1, hasChargeItem, chargeItem_13_1));
        model.add(model.createStatement(service_6_1, hasChargeItem, chargeItem_14_1));
        model.add(model.createStatement(service_7_1, hasChargeItem, chargeItem_15_1));
        model.add(model.createStatement(service_8_1, hasChargeItem, chargeItem_16_1));
        model.add(model.createStatement(service_9_1, hasChargeItem, chargeItem_17_1));
        
        
        //charge items
        
        
        /***************************************************************************/
         /*
         * bill two
        */
        
        //root of bill one
        Individual inv_2 = inv.createIndividual(NS+"inv_2");
        Literal invType_2 = m.createTypedLiteral("INV");
        Literal billingMode_2 = m.createTypedLiteral("REG");
        //customer
        Individual customer_2 = customer.createIndividual(NS+"customer_2");
        //contracts
        Individual contract_1_2 = contract.createIndividual(NS+"contract_1_2");
        Individual contract_2_2 = contract.createIndividual(NS+"contract_2_2");
        Individual contract_3_2 = contract.createIndividual(NS+"contract_3_2");
        //services
        Individual service_1_2 = service.createIndividual(NS+"service_1_2");
        Individual service_2_2 = service.createIndividual(NS+"service_2_2");
        Individual service_3_2 = service.createIndividual(NS+"service_3_2");
        Individual service_4_2 = service.createIndividual(NS+"service_4_2");
        Individual service_5_2 = service.createIndividual(NS+"service_5_2");
        Individual service_6_2 = service.createIndividual(NS+"service_6_2");
        Individual service_7_2 = service.createIndividual(NS+"service_7_2");
        Individual service_8_2 = service.createIndividual(NS+"service_8_2");
        Individual service_9_2 = service.createIndividual(NS+"service_9_2");
        Individual service_10_2 = service.createIndividual(NS+"service_10_2");
        //chargeitems
        Individual chargeItem_1_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_21 = m.createTypedLiteral("99");
        Literal amount_21 = m.createTypedLiteral("0.52");
        Literal currCode_21 = m.createTypedLiteral("EGP");
        Literal type_21 = m.createTypedLiteral("9");
        Literal pt_21 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_1_2, hasId, id_21));
        model.add(model.createStatement(chargeItem_1_2, hasAmount, amount_21));
        model.add(model.createStatement(chargeItem_1_2, hasCurrCode, currCode_21));
        model.add(model.createStatement(chargeItem_1_2, hasType, type_21));
        model.add(model.createStatement(chargeItem_1_2, hasPT, pt_21));
        Individual chargeItem_2_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_22 = m.createTypedLiteral("99");
        Literal amount_22 = m.createTypedLiteral("0.52");
        Literal currCode_22 = m.createTypedLiteral("EGP");
        Literal type_22 = m.createTypedLiteral("9");
        Literal pt_22 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_2_2, hasId, id_22));
        model.add(model.createStatement(chargeItem_2_2, hasAmount, amount_22));
        model.add(model.createStatement(chargeItem_2_2, hasCurrCode, currCode_22));
        model.add(model.createStatement(chargeItem_2_2, hasType, type_22));
        model.add(model.createStatement(chargeItem_2_2, hasPT, pt_22));
        Individual chargeItem_3_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_23 = m.createTypedLiteral("99");
        Literal amount_23 = m.createTypedLiteral("0.52");
        Literal currCode_23 = m.createTypedLiteral("EGP");
        Literal type_23 = m.createTypedLiteral("9");
        Literal pt_23 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_3_2, hasId, id_23));
        model.add(model.createStatement(chargeItem_3_2, hasAmount, amount_23));
        model.add(model.createStatement(chargeItem_3_2, hasCurrCode, currCode_23));
        model.add(model.createStatement(chargeItem_3_2, hasType, type_23));
        model.add(model.createStatement(chargeItem_3_2, hasPT, pt_23));
        Individual chargeItem_4_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_24 = m.createTypedLiteral("99");
        Literal amount_24 = m.createTypedLiteral("0.52");
        Literal currCode_24 = m.createTypedLiteral("EGP");
        Literal type_24 = m.createTypedLiteral("9");
        Literal pt_24 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_4_2, hasId, id_24));
        model.add(model.createStatement(chargeItem_4_2, hasAmount, amount_24));
        model.add(model.createStatement(chargeItem_4_2, hasCurrCode, currCode_24));
        model.add(model.createStatement(chargeItem_4_2, hasType, type_24));
        model.add(model.createStatement(chargeItem_4_2, hasPT, pt_24));
        Individual chargeItem_5_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_25 = m.createTypedLiteral("99");
        Literal amount_25 = m.createTypedLiteral("0.52");
        Literal currCode_25 = m.createTypedLiteral("EGP");
        Literal type_25 = m.createTypedLiteral("9");
        Literal pt_25 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_5_2, hasId, id_25));
        model.add(model.createStatement(chargeItem_5_2, hasAmount, amount_25));
        model.add(model.createStatement(chargeItem_5_2, hasCurrCode, currCode_25));
        model.add(model.createStatement(chargeItem_5_2, hasType, type_25));
        model.add(model.createStatement(chargeItem_5_2, hasPT, pt_25));
        Individual chargeItem_6_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_26 = m.createTypedLiteral("99");
        Literal amount_26 = m.createTypedLiteral("0.52");
        Literal currCode_26 = m.createTypedLiteral("EGP");
        Literal type_26 = m.createTypedLiteral("9");
        Literal pt_26 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_6_2, hasId, id_26));
        model.add(model.createStatement(chargeItem_6_2, hasAmount, amount_26));
        model.add(model.createStatement(chargeItem_6_2, hasCurrCode, currCode_26));
        model.add(model.createStatement(chargeItem_6_2, hasType, type_26));
        model.add(model.createStatement(chargeItem_6_2, hasPT, pt_26));
        Individual chargeItem_7_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_27 = m.createTypedLiteral("99");
        Literal amount_27 = m.createTypedLiteral("0.52");
        Literal currCode_27 = m.createTypedLiteral("EGP");
        Literal type_27 = m.createTypedLiteral("9");
        Literal pt_27 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_7_2, hasId, id_27));
        model.add(model.createStatement(chargeItem_7_2, hasAmount, amount_27));
        model.add(model.createStatement(chargeItem_7_2, hasCurrCode, currCode_27));
        model.add(model.createStatement(chargeItem_7_2, hasType, type_27));
        model.add(model.createStatement(chargeItem_7_2, hasPT, pt_27));
        Individual chargeItem_8_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_28 = m.createTypedLiteral("99");
        Literal amount_28 = m.createTypedLiteral("0.52");
        Literal currCode_28 = m.createTypedLiteral("EGP");
        Literal type_28 = m.createTypedLiteral("9");
        Literal pt_28 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_8_2, hasId, id_28));
        model.add(model.createStatement(chargeItem_8_2, hasAmount, amount_28));
        model.add(model.createStatement(chargeItem_8_2, hasCurrCode, currCode_28));
        model.add(model.createStatement(chargeItem_8_2, hasType, type_28));
        model.add(model.createStatement(chargeItem_8_2, hasPT, pt_28));
        Individual chargeItem_9_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_29 = m.createTypedLiteral("99");
        Literal amount_29 = m.createTypedLiteral("0.52");
        Literal currCode_29 = m.createTypedLiteral("EGP");
        Literal type_29 = m.createTypedLiteral("9");
        Literal pt_29 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_9_2, hasId, id_29));
        model.add(model.createStatement(chargeItem_9_2, hasAmount, amount_29));
        model.add(model.createStatement(chargeItem_9_2, hasCurrCode, currCode_29));
        model.add(model.createStatement(chargeItem_9_2, hasType, type_29));
        model.add(model.createStatement(chargeItem_9_2, hasPT, pt_29));
        Individual chargeItem_10_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_30 = m.createTypedLiteral("99");
        Literal amount_30 = m.createTypedLiteral("0.52");
        Literal currCode_30 = m.createTypedLiteral("EGP");
        Literal type_30 = m.createTypedLiteral("9");
        Literal pt_30 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_10_2, hasId, id_30));
        model.add(model.createStatement(chargeItem_10_2, hasAmount, amount_30));
        model.add(model.createStatement(chargeItem_10_2, hasCurrCode, currCode_30));
        model.add(model.createStatement(chargeItem_10_2, hasType, type_30));
        model.add(model.createStatement(chargeItem_10_2, hasPT, pt_30));
        Individual chargeItem_11_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_31 = m.createTypedLiteral("99");
        Literal amount_31 = m.createTypedLiteral("0.52");
        Literal currCode_31 = m.createTypedLiteral("EGP");
        Literal type_31 = m.createTypedLiteral("9");
        Literal pt_31 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_11_2, hasId, id_31));
        model.add(model.createStatement(chargeItem_11_2, hasAmount, amount_31));
        model.add(model.createStatement(chargeItem_11_2, hasCurrCode, currCode_31));
        model.add(model.createStatement(chargeItem_11_2, hasType, type_31));
        model.add(model.createStatement(chargeItem_11_2, hasPT, pt_31));
        Individual chargeItem_12_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_32 = m.createTypedLiteral("99");
        Literal amount_32 = m.createTypedLiteral("0.52");
        Literal currCode_32 = m.createTypedLiteral("EGP");
        Literal type_32 = m.createTypedLiteral("9");
        Literal pt_32 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_12_2, hasId, id_32));
        model.add(model.createStatement(chargeItem_12_2, hasAmount, amount_32));
        model.add(model.createStatement(chargeItem_12_2, hasCurrCode, currCode_32));
        model.add(model.createStatement(chargeItem_12_2, hasType, type_32));
        model.add(model.createStatement(chargeItem_12_2, hasPT, pt_2));
        Individual chargeItem_13_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_33 = m.createTypedLiteral("99");
        Literal amount_33 = m.createTypedLiteral("0.52");
        Literal currCode_33 = m.createTypedLiteral("EGP");
        Literal type_33 = m.createTypedLiteral("9");
        Literal pt_33 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_13_2, hasId, id_33));
        model.add(model.createStatement(chargeItem_13_2, hasAmount, amount_33));
        model.add(model.createStatement(chargeItem_13_2, hasCurrCode, currCode_33));
        model.add(model.createStatement(chargeItem_13_2, hasType, type_33));
        model.add(model.createStatement(chargeItem_13_2, hasPT, pt_33));
        Individual chargeItem_14_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_34 = m.createTypedLiteral("99");
        Literal amount_34 = m.createTypedLiteral("0.52");
        Literal currCode_34 = m.createTypedLiteral("EGP");
        Literal type_34 = m.createTypedLiteral("9");
        Literal pt_34 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_14_2, hasId, id_34));
        model.add(model.createStatement(chargeItem_14_2, hasAmount, amount_34));
        model.add(model.createStatement(chargeItem_14_2, hasCurrCode, currCode_34));
        model.add(model.createStatement(chargeItem_14_2, hasType, type_34));
        model.add(model.createStatement(chargeItem_14_2, hasPT, pt_34));
        Individual chargeItem_15_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_35 = m.createTypedLiteral("99");
        Literal amount_35 = m.createTypedLiteral("0.52");
        Literal currCode_35 = m.createTypedLiteral("EGP");
        Literal type_35 = m.createTypedLiteral("9");
        Literal pt_35 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_15_2, hasId, id_35));
        model.add(model.createStatement(chargeItem_15_2, hasAmount, amount_35));
        model.add(model.createStatement(chargeItem_15_2, hasCurrCode, currCode_35));
        model.add(model.createStatement(chargeItem_15_2, hasType, type_35));
        model.add(model.createStatement(chargeItem_15_2, hasPT, pt_35));
        Individual chargeItem_16_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_36 = m.createTypedLiteral("99");
        Literal amount_36 = m.createTypedLiteral("0.52");
        Literal currCode_36 = m.createTypedLiteral("EGP");
        Literal type_36 = m.createTypedLiteral("9");
        Literal pt_36 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_16_2, hasId, id_36));
        model.add(model.createStatement(chargeItem_16_2, hasAmount, amount_36));
        model.add(model.createStatement(chargeItem_16_2, hasCurrCode, currCode_36));
        model.add(model.createStatement(chargeItem_16_2, hasType, type_36));
        model.add(model.createStatement(chargeItem_16_2, hasPT, pt_36));
        Individual chargeItem_17_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_37 = m.createTypedLiteral("99");
        Literal amount_37 = m.createTypedLiteral("0.52");
        Literal currCode_37 = m.createTypedLiteral("EGP");
        Literal type_37 = m.createTypedLiteral("9");
        Literal pt_37 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_17_2, hasId, id_37));
        model.add(model.createStatement(chargeItem_17_2, hasAmount, amount_37));
        model.add(model.createStatement(chargeItem_17_2, hasCurrCode, currCode_37));
        model.add(model.createStatement(chargeItem_17_2, hasType, type_37));
        model.add(model.createStatement(chargeItem_17_2, hasPT, pt_37));
        Individual chargeItem_18_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_38 = m.createTypedLiteral("99");
        Literal amount_38 = m.createTypedLiteral("0.52");
        Literal currCode_38 = m.createTypedLiteral("EGP");
        Literal type_38 = m.createTypedLiteral("9");
        Literal pt_38 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_18_2, hasId, id_38));
        model.add(model.createStatement(chargeItem_18_2, hasAmount, amount_38));
        model.add(model.createStatement(chargeItem_18_2, hasCurrCode, currCode_38));
        model.add(model.createStatement(chargeItem_18_2, hasType, type_38));
        model.add(model.createStatement(chargeItem_18_2, hasPT, pt_38));
        Individual chargeItem_19_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_39 = m.createTypedLiteral("99");
        Literal amount_39 = m.createTypedLiteral("0.52");
        Literal currCode_39 = m.createTypedLiteral("EGP");
        Literal type_39 = m.createTypedLiteral("9");
        Literal pt_39 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_19_2, hasId, id_39));
        model.add(model.createStatement(chargeItem_19_2, hasAmount, amount_39));
        model.add(model.createStatement(chargeItem_19_2, hasCurrCode, currCode_39));
        model.add(model.createStatement(chargeItem_19_2, hasType, type_39));
        model.add(model.createStatement(chargeItem_19_2, hasPT, pt_39));
        Individual chargeItem_20_2 = chargeItem.createIndividual(NS+"chargeItem");
        Literal id_40 = m.createTypedLiteral("99");
        Literal amount_40 = m.createTypedLiteral("0.52");
        Literal currCode_40 = m.createTypedLiteral("EGP");
        Literal type_40 = m.createTypedLiteral("9");
        Literal pt_40 = m.createTypedLiteral("P");
        model.add(model.createStatement(chargeItem_20_2, hasId, id_40));
        model.add(model.createStatement(chargeItem_20_2, hasAmount, amount_40));
        model.add(model.createStatement(chargeItem_20_2, hasCurrCode, currCode_40));
        model.add(model.createStatement(chargeItem_20_2, hasType, type_40));
        model.add(model.createStatement(chargeItem_20_2, hasPT, pt_40));
        
        /*
         * relations betwwn individual
         */
        
        
        //bill two
        model.add(model.createStatement(inv_2, invType, invType_2));
        model.add(model.createStatement(inv_2, invBillingMode, billingMode_2));
        model.add(model.createStatement(inv_2, hasCustomer, customer_2));
        
        model.add(model.createStatement(customer_2, hasContract, contract_1_2));
        model.add(model.createStatement(customer_2, hasContract, contract_2_2));
        model.add(model.createStatement(customer_2, hasContract, contract_3_2));
        model.add(model.createStatement(customer_2, hasChargeItem, chargeItem_1_2));
        model.add(model.createStatement(customer_2, hasChargeItem, chargeItem_2_2));
        
        model.add(model.createStatement(contract_1_2, hasService, service_1_2));
        model.add(model.createStatement(contract_1_2, hasService, service_2_2));
        model.add(model.createStatement(contract_1_2, hasService, service_3_2));
        model.add(model.createStatement(contract_1_2, hasChargeItem, chargeItem_3_2));
        model.add(model.createStatement(contract_1_2, hasChargeItem, chargeItem_4_2));
        
        model.add(model.createStatement(contract_2_2, hasService, service_4_2));
        model.add(model.createStatement(contract_2_2, hasService, service_5_2));
        model.add(model.createStatement(contract_2_2, hasService, service_6_2));
        model.add(model.createStatement(contract_2_2, hasChargeItem, chargeItem_5_2));
        model.add(model.createStatement(contract_2_2, hasChargeItem, chargeItem_6_2));
        
        model.add(model.createStatement(contract_3_2, hasService, service_7_2));
        model.add(model.createStatement(contract_3_2, hasService, service_8_2));
        model.add(model.createStatement(contract_3_2, hasService, service_9_2));
        model.add(model.createStatement(contract_3_2, hasChargeItem, chargeItem_7_2));
        model.add(model.createStatement(contract_3_2, hasChargeItem, chargeItem_8_2));
        
        
        model.add(model.createStatement(service_1_2, hasChargeItem, chargeItem_9_2));
        model.add(model.createStatement(service_2_2, hasChargeItem, chargeItem_10_2));
        model.add(model.createStatement(service_3_2, hasChargeItem, chargeItem_11_2));
        model.add(model.createStatement(service_4_2, hasChargeItem, chargeItem_12_2));
        model.add(model.createStatement(service_5_2, hasChargeItem, chargeItem_13_2));
        model.add(model.createStatement(service_6_2, hasChargeItem, chargeItem_14_2));
        model.add(model.createStatement(service_7_2, hasChargeItem, chargeItem_15_2));
        model.add(model.createStatement(service_8_2, hasChargeItem, chargeItem_16_2));
        model.add(model.createStatement(service_9_2, hasChargeItem, chargeItem_17_2));
        
        /*********************************************/
        
        //read to files
        model.write(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\afkarna_sam_ont\\data.rdf"));
        m.write(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\afkarna_sam_ont\\ont.owl"),"RDF/XML");
    }   
    
    
   
      
}
