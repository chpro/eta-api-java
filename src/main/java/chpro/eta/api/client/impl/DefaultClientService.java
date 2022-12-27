
package chpro.eta.api.client.impl;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.StatusLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import chpro.eta.api.client.ClientService;
import chpro.eta.api.client.data.Eta;
import jakarta.inject.Singleton;

@Singleton
public class DefaultClientService implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultClientService.class);

    public String getData(InetAddress address, String path) {
        String uri = String.format("http://%s:%s%s", address.getHostAddress(), "8080", path);
        LOG.info("Getting data from endpoint {}", uri);
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            final HttpGet httpget = new HttpGet(uri);

            final String result = client.execute(httpget, response -> {
                LOG.trace("Got response for {} status {}", httpget,new StatusLine(response));
                // Process response message and convert it into a value object
                return EntityUtils.toString(response.getEntity());
            });
            LOG.trace("Response for endpoint {} was: {}", uri, result);
            return result;
        } catch (IOException e) {
            LOG.error("Was not able to get response for " + uri, e);
        }
        return null;
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
