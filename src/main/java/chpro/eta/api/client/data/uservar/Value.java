
package chpro.eta.api.client.data.uservar;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Value {

    
    //long or 1.8e+06
    @JacksonXmlText
    String value;
    
    @JacksonXmlProperty(isAttribute = true, localName = "advTextOffset")
    String advTextOffset;

    @JacksonXmlProperty(isAttribute = true, localName = "unit")
    String unit;

    @JacksonXmlProperty(isAttribute = true, localName = "uri")
    String uri;

    @JacksonXmlProperty(isAttribute = true, localName = "strValue")
    String strValue;

    @JacksonXmlProperty(isAttribute = true, localName = "scaleFactor")
    int scaleFactor;

    @JacksonXmlProperty(isAttribute = true, localName = "decPlaces")
    int decPlaces;

    
    public String getValue() {
        return value;
    }

    
    public String getAdvTextOffset() {
        return advTextOffset;
    }

    
    public String getUnit() {
        return unit;
    }

    
    public String getUri() {
        return uri;
    }

    
    public String getStrValue() {
        return strValue;
    }

    
    public int getScaleFactor() {
        return scaleFactor;
    }

    
    public int getDecPlaces() {
        return decPlaces;
    }

    
}
