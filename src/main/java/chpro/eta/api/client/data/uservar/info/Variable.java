
package chpro.eta.api.client.data.uservar.info;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import chpro.eta.api.client.data.uservar.Value;

public class Variable extends Value {

    @JacksonXmlProperty(isAttribute = true, localName = "isWritable")
    String writeable;

    @JacksonXmlProperty(isAttribute = true, localName = "fullName")
    String fullName;

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    String name;
    
    @JacksonXmlProperty(isAttribute = true, localName = "type")
    String type;
    
    @JacksonXmlProperty(isAttribute = true, localName = "validValues")
    ValidValues validValues;

    
    
    public ValidValues getValidValues() {
        return validValues;
    }


    public String getWriteable() {
        return writeable;
    }

    
    public String getType() {
        return type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

}
