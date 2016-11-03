/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */

@XmlRootElement(name = "Response")
@XmlAccessorType (XmlAccessType.FIELD)
public class Response {
    
    @XmlElement(name = "Properties")
    private  List<Property>  properties;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
    
    
    @XmlAccessorType(XmlAccessType.FIELD)
public static class Property {
    
    @XmlElement(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "SingleValue")
    private String singleValue;
    public String getSingleValue() {
        return singleValue;
    }

    public void setSingleValue(String singleValue) {
        this.singleValue = singleValue;
    }

    
    @XmlElement(name = "MultiValues")
    private MultiValues multiValues;

    public MultiValues getMultiValues() {
        return multiValues;
    }

    public void setMultiValues(MultiValues multiValues) {
        this.multiValues = multiValues;
    }
    
    
    @XmlAccessorType(XmlAccessType.FIELD)
public static class MultiValues {
    
    @XmlElement(name = "Property")
    private  List<Property>  multiValues;

    public List<Property> getMultiValues() {
        return multiValues;
    }

    public void setMultiValues(List<Property> multiValues) {
        this.multiValues = multiValues;
    }
    
    
    
}
    
    
    
}

    
    
    
}
