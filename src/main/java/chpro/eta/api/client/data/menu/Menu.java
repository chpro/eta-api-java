package chpro.eta.api.client.data.menu;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Menu {
    
    @JacksonXmlProperty(localName = "fub")
    @JacksonXmlElementWrapper(useWrapping = false)
    Collection<Fub> fubs;
    
    @JacksonXmlProperty(localName = "object")
    @JacksonXmlElementWrapper(useWrapping = false)
    Collection<Object> objects;
    
    @JacksonXmlProperty(isAttribute = true, localName = "uri")
    String uri;
    
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    String name;

    
    public Collection<Fub> getFubs() {
        return fubs;
    }

    
    public Collection<Object> getObjects() {
        return objects;
    }

    
    public String getUri() {
        return uri;
    }

    
    public String getName() {
        return name;
    }
    
    
}
