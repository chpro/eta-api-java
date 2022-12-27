
package chpro.eta.api.client.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import chpro.eta.api.client.data.menu.Menu;
import chpro.eta.api.client.data.uservar.Value;
import chpro.eta.api.client.data.uservar.info.VarInfo;

public class Eta {

    @JacksonXmlProperty(localName = "menu")
    Menu menu;

    @JacksonXmlProperty(isAttribute = true, localName = "version")
    String version;

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    String xmlns;

    @JacksonXmlProperty(localName = "value")
    Value value;

    @JacksonXmlProperty(localName = "varInfo")
    VarInfo varInfo;

    public Menu getMenu() {
        return menu;
    }

    public Value getValue() {
        return value;
    }

    public VarInfo getVarInfo() {
        return varInfo;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "ETA xml processing error";
        }
    }

}
