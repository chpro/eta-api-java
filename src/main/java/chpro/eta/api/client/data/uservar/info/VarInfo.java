
package chpro.eta.api.client.data.uservar.info;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class VarInfo {

    @JacksonXmlProperty(isAttribute = true, localName = "uri")
    String uri;

    @JacksonXmlProperty(isAttribute = true, localName = "variable")
    Variable variable;

    public String getUri() {
        return uri;
    }

    public Variable getVariable() {
        return variable;
    }

}
