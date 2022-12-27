
package chpro.eta.api.client.impl;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import chpro.eta.api.client.ClientService;
import chpro.eta.api.client.data.Eta;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.HttpClientRegistry;
import jakarta.inject.Inject;

public class DefaultClientService implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultClientService.class);

    @Inject
    protected HttpClientRegistry<HttpClient> registry;


    public String getData(InetAddress address, String path) {
        HttpClient client = registry.getDefaultClient();
        String uri = String.format("http://%s:%s%s", address.getHostAddress(), "8080", path);
        LOG.info("Getting data from endpoint {}", uri);

        String data = client.toBlocking().retrieve(
                HttpRequest.GET(uri)
        );
        LOG.trace("Got response data from endpoint {}: {}", uri, data);
        return data;
    }

    public Eta getUserMenu(InetAddress address) {
        return parseXml(getData(address, "/user/menu"));
    }
    
    public Eta parseXml(String data) {
        ObjectMapper xmlMapper = new XmlMapper();
        try {
            Eta value = xmlMapper.readValue(data, Eta.class);
            return value;
        } catch (JsonMappingException e) {
            LOG.error("Could not parse data", e);
        } catch (JsonProcessingException e) {
            LOG.error("Could not parse data", e);
        }
        
        return null;
    }

    @Override
    public Eta getUserVar(InetAddress address, String path) {
        return parseXml(getData(address, String.format("/user/var%s", path)));
    }

    @Override
    public Eta getUserVarInfo(InetAddress address, String path) {
        return parseXml(getData(address, String.format("/user/varinfo%s", path)));
    }
}
