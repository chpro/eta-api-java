package chpro.eta.api.client.data.uservar.info;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import chpro.eta.api.client.data.uservar.Value;

public class ValidValues {
    @JacksonXmlProperty(localName = "validValues")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Value> validValues;
    
    @JacksonXmlProperty(localName = "min")
    String min;
    
    @JacksonXmlProperty(localName = "max")
    String max;
    
    @JacksonXmlProperty(localName = "value")
    String value;
    
    @JacksonXmlProperty(localName = "def")
    String def;

    
    public List<Value> getValidValues() {
        return validValues;
    }

    
    public String getMin() {
        return min;
    }

    
    public String getMax() {
        return max;
    }

    
    public String getValue() {
        return value;
    }

    
    public String getDef() {
        return def;
    }
    
    
}
