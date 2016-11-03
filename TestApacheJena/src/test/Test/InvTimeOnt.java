package test.Test;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.ontology.CardinalityRestriction;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.EnumeratedClass;
import com.hp.hpl.jena.ontology.MaxCardinalityRestriction;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.UnionClass;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.XSD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 *
 * @author Muhammad.Sobhy@asset.com.eg
 */
public class InvTimeOnt {
    
    public static final String NS = "http://www.vodafone.com.eg/ontologies/2013-12/contract-bill-ontology-01#";
    
    public static void main(String a[]) {
        try {
            createOntology();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    
    static void createOntology() throws FileNotFoundException, InterruptedException{
        
        //ontology and RDF models
        OntModel m = ModelFactory.createOntologyModel();
        m.setNsPrefix("time",NS );
        Model model = ModelFactory.createDefaultModel();
        model.setNsPrefix("vodafone", NS);
        //create classes
        OntClass instant = m.createClass(NS+"Instant");
        OntClass interval = m.createClass(NS+"Interval");
        UnionClass temporalEntity = m.createUnionClass(NS+"TemporalEntity", null);
        OntClass properInterval = m.createClass(NS+"ProperInterval");
        interval.setSuperClass(temporalEntity);
        instant.setSuperClass(temporalEntity);
        RDFList list = m.createList(new RDFNode[]{instant,interval});
        temporalEntity.setOperands(list);
        properInterval.setDisjointWith(instant);
        properInterval.setSuperClass(interval);
        //properties
        ObjectProperty before = m.createObjectProperty(NS+"before");
        before.setRDFType(OWL.TransitiveProperty);
        before.setDomain(temporalEntity);
        before.setRange(temporalEntity);
        
        ObjectProperty after = m.createObjectProperty(NS+"after");
        after.setInverseOf(after);
        
        
        ObjectProperty hasBeginning = m.createObjectProperty(NS+"hasBeginning");
        hasBeginning.setDomain(temporalEntity);
        hasBeginning.setRange(instant);
        
        ObjectProperty hasEnd = m.createObjectProperty(NS+"hasEnd");
        hasEnd.setDomain(temporalEntity);
        hasEnd.setRange(instant);
        
        ObjectProperty inside = m.createObjectProperty(NS+"inside");
        before.setDomain(interval);
        before.setRange(instant);
        
        ObjectProperty intervalEquals = m.createObjectProperty(NS+"intervalEquals");
        intervalEquals.setDomain(properInterval);
        intervalEquals.setRange(properInterval);
         
        ObjectProperty intervalBefore = m.createObjectProperty(NS+"intervalBefore");
        intervalBefore.setSuperProperty(before);
        intervalBefore.setDomain(properInterval);
        intervalBefore.setRange(properInterval);
        
        ObjectProperty intervalMeets = m.createObjectProperty(NS+"intervalMeets");
        intervalMeets.setDomain(properInterval);
        intervalMeets.setRange(properInterval);
        
        ObjectProperty intervalOverlaps = m.createObjectProperty(NS+"intervalOverlaps");
        intervalOverlaps.setDomain(properInterval);
        intervalOverlaps.setRange(properInterval);
        
        ObjectProperty intervalStarts = m.createObjectProperty(NS+"intervalStarts");
        intervalStarts.setDomain(properInterval);
        intervalStarts.setRange(properInterval);
        
        ObjectProperty intervalDuring = m.createObjectProperty(NS+"intervalDuring");
        intervalDuring.setDomain(properInterval);
        intervalDuring.setRange(properInterval);
        
        ObjectProperty intervalFinishes = m.createObjectProperty(NS+"intervalFinishes");
        intervalFinishes.setDomain(properInterval);
        intervalFinishes.setRange(properInterval);

        ObjectProperty intervalAfter = m.createObjectProperty(NS+"intervalAfter");
        intervalAfter.setInverseOf(intervalBefore);
        
        ObjectProperty intervalMetBy = m.createObjectProperty(NS+"intervalMetBy");
        intervalMetBy.setInverseOf(intervalMeets);
        
        ObjectProperty intervalOverlappedBy = m.createObjectProperty(NS+"intervalOverlappedBy");
        intervalOverlappedBy.setInverseOf(intervalOverlaps);
        
        ObjectProperty intervalStartedBy = m.createObjectProperty(NS+"intervalStartedBy");
        intervalStartedBy.setInverseOf(intervalStarts);
        
        ObjectProperty intervalContains = m.createObjectProperty(NS+"intervalContains");
        intervalContains.setInverseOf(intervalDuring);
        
        ObjectProperty intervalFinishedBy = m.createObjectProperty(NS+"intervalFinishedBy");
        intervalFinishedBy.setInverseOf(intervalFinishes);
        
        //classes of duration description
        
        OntClass durationDescription = m.createClass(NS+"DurationDescription");
        DatatypeProperty years = m.createDatatypeProperty(NS+"years");
        years.setRange(XSD.decimal);
        years.setDomain(durationDescription);
        DatatypeProperty months = m.createDatatypeProperty(NS+"months");
        months.setRange(XSD.decimal);
        months.setDomain(durationDescription);
        DatatypeProperty weeks = m.createDatatypeProperty(NS+"weeks");
        weeks.setRange(XSD.decimal);
        weeks.setDomain(durationDescription);
        DatatypeProperty days = m.createDatatypeProperty(NS+"days");
        days.setRange(XSD.decimal);
        days.setDomain(durationDescription);
        DatatypeProperty hours = m.createDatatypeProperty(NS+"hours");
        hours.setRange(XSD.decimal);
        hours.setDomain(durationDescription);
        DatatypeProperty minutes = m.createDatatypeProperty(NS+"minutes");
        minutes.setRange(XSD.decimal);
        minutes.setDomain(durationDescription);
        DatatypeProperty seconds = m.createDatatypeProperty(NS+"seconds");
        seconds.setRange(XSD.decimal);
        seconds.setDomain(durationDescription);
        
        MaxCardinalityRestriction yearsDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,years,1);
        durationDescription.addSuperClass(yearsDurationDescriptionRestriction);
        MaxCardinalityRestriction monthsDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,months,1);
        durationDescription.addSuperClass(monthsDurationDescriptionRestriction);
        MaxCardinalityRestriction weeksDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,weeks,1);
        durationDescription.addSuperClass(weeksDurationDescriptionRestriction);
        MaxCardinalityRestriction daysDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,days,1);
        durationDescription.addSuperClass(daysDurationDescriptionRestriction);
        MaxCardinalityRestriction hoursDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,hours,1);
        durationDescription.addSuperClass(hoursDurationDescriptionRestriction);
        MaxCardinalityRestriction minutesDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,minutes,1);
        durationDescription.addSuperClass(minutesDurationDescriptionRestriction);
        MaxCardinalityRestriction secondsDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,seconds,1);
        durationDescription.addSuperClass(secondsDurationDescriptionRestriction);
        
        ////////////////////////////////////////////////////////////////////
        //duration year not calender
        OntClass yearDuration = m.createClass(NS+"Year");
        yearDuration.setSuperClass(durationDescription);
        MaxCardinalityRestriction yearsOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,years,1);
        yearDuration.addSuperClass(yearsOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction monthsOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,months,0);
        yearDuration.addSuperClass(monthsOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction weeksOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,weeks,0);
        yearDuration.addSuperClass(weeksOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction daysOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,days,0);
        yearDuration.addSuperClass(daysOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction hoursOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,hours,0);
        yearDuration.addSuperClass(hoursOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction minutesOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,minutes,0);
        yearDuration.addSuperClass(minutesOfYearDurationDescriptionRestriction);
        MaxCardinalityRestriction secondsOfYearDurationDescriptionRestriction = m.createMaxCardinalityRestriction(null,seconds,0);
        yearDuration.addSuperClass(secondsOfYearDurationDescriptionRestriction);
         
        
////////////////////////////////////////////////
        
        ObjectProperty hasDurationDescription = m.createObjectProperty(NS+"hasDurationDescription");
        hasDurationDescription.setDomain(temporalEntity);
        hasDurationDescription.setRange(durationDescription);
        
        //Calendar-Clock Description
        
        
        OntClass dateTimeInterval = m.createClass(NS+"DateTimeInterval");
        dateTimeInterval.setSuperClass(properInterval);

        EnumeratedClass temporalUnit = m.createEnumeratedClass(NS+"TemporalUnit", null);
        temporalUnit.addOneOf(m.createClass(NS+"unitSecond"));
        temporalUnit.addOneOf(m.createClass(NS+"unitMinute"));
        temporalUnit.addOneOf(m.createClass(NS+"unitHour"));
        temporalUnit.addOneOf(m.createClass(NS+"unitDay"));
        temporalUnit.addOneOf(m.createClass(NS+"unitWeek"));
        temporalUnit.addOneOf(m.createClass(NS+"unitMonth"));
        temporalUnit.addOneOf(m.createClass(NS+"unitYear"));
        
        OntClass dateTimeDescription = m.createClass(NS+"DateTimeDescription");
         
        ObjectProperty unitType = m.createObjectProperty(NS+"unitType");
        unitType.setDomain(dateTimeDescription);
        unitType.setRange(temporalUnit);
        
        DatatypeProperty year = m.createDatatypeProperty(NS+"year");
        year.setDomain(dateTimeDescription);
        year.setRange(XSD.gYear);
        
        DatatypeProperty month = m.createDatatypeProperty(NS+"month");
        month.setDomain(dateTimeDescription);
        month.setRange(XSD.gMonth);
        
        DatatypeProperty week = m.createDatatypeProperty(NS+"week");
        week.setDomain(dateTimeDescription);
        week.setRange(XSD.nonNegativeInteger);

        DatatypeProperty day = m.createDatatypeProperty(NS+"day");
        day.setDomain(dateTimeDescription);
        day.setRange(XSD.gDay);
        
        EnumeratedClass dayOfWeek = m.createEnumeratedClass(NS+"DayOfWeek",null);
        dayOfWeek.addOneOf(m.createClass(NS+"Sunday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Monday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Tuesday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Wednesday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Thursday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Friday"));
        dayOfWeek.addOneOf(m.createClass(NS+"Saturday"));
        
        ObjectProperty dayOfWeekProperty = m.createObjectProperty(NS+"dayOfWeek");
        unitType.setDomain(dateTimeDescription);
        unitType.setRange(dayOfWeek);
        
        DatatypeProperty dayOfYear = m.createDatatypeProperty(NS+"dayOfYear");
        dayOfYear.setDomain(dateTimeDescription);
        dayOfYear.setRange(XSD.nonNegativeInteger);
        
        DatatypeProperty hour = m.createDatatypeProperty(NS+"hour");
        hour.setDomain(dateTimeDescription);
        hour.setRange(XSD.nonNegativeInteger);
        
        DatatypeProperty minute = m.createDatatypeProperty(NS+"minute");
        minute.setDomain(dateTimeDescription);
        minute.setRange(XSD.nonNegativeInteger);
        
        DatatypeProperty second = m.createDatatypeProperty(NS+"second");
        second.setDomain(dateTimeDescription);
        second.setRange(XSD.nonNegativeInteger);
       
               
        CardinalityRestriction unitTypeRestriction = m.createCardinalityRestriction(null,unitType,1);
        dateTimeDescription.addSuperClass(unitTypeRestriction);
        CardinalityRestriction yearRestriction = m.createCardinalityRestriction(null,year,1);
        dateTimeDescription.addSuperClass(yearRestriction);
        CardinalityRestriction monthRestriction = m.createCardinalityRestriction(null,month,1);
        dateTimeDescription.addSuperClass(monthRestriction);
        CardinalityRestriction weekRestriction = m.createCardinalityRestriction(null,week,1);
        dateTimeDescription.addSuperClass(weekRestriction);
        CardinalityRestriction dayRestriction = m.createCardinalityRestriction(null,day,1);
        dateTimeDescription.addSuperClass(dayRestriction);
        CardinalityRestriction hourRestriction = m.createCardinalityRestriction(null,hour,1);
        dateTimeDescription.addSuperClass(hourRestriction);
        CardinalityRestriction dayOfWeekRestriction = m.createCardinalityRestriction(null,dayOfWeekProperty,1);
        dateTimeDescription.addSuperClass(dayOfWeekRestriction);
        CardinalityRestriction dayOfYearRestriction = m.createCardinalityRestriction(null,dayOfYear,1);
        dateTimeDescription.addSuperClass(dayOfYearRestriction);
        CardinalityRestriction minuteRestriction = m.createCardinalityRestriction(null,minute,1);
        dateTimeDescription.addSuperClass(minuteRestriction);
        CardinalityRestriction secondRestriction = m.createCardinalityRestriction(null,second,1);
        dateTimeDescription.addSuperClass(secondRestriction);
        
        OntClass january = m.createClass(NS+"January");
        january.addSuperClass(dateTimeDescription);
        
                 
        ObjectProperty inDateTime = m.createObjectProperty(NS+"inDateTime");
        inDateTime.setDomain(instant);
        inDateTime.setRange(dateTimeDescription);
        
        ObjectProperty hasDateTimeDescription = m.createObjectProperty(NS+"hasDateTimeDescription");
        hasDateTimeDescription.setDomain(dateTimeInterval);
        hasDateTimeDescription.setRange(dateTimeDescription);
        
        DatatypeProperty inXSDDateTime = m.createDatatypeProperty(NS+"inXSDDateTime");
        inXSDDateTime.setDomain(instant);
        inXSDDateTime.setRange(XSD.dateTime);
        
        DatatypeProperty xsdDateTime = m.createDatatypeProperty(NS+"xsdDateTime");
        xsdDateTime.setDomain(dateTimeInterval);
        xsdDateTime.setRange(XSD.dateTime);
        
        
        //write
        m.write(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\afkarna_sam_ont\\timeont.owl"),"RDF/XML-ABBREV");
    }
}

