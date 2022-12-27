package chpro.eta.api.client;

import java.net.InetAddress;

import chpro.eta.api.client.data.Eta;
/**
 * Api documentation https://www.meineta.at/javax.faces.resource/downloads/ETA-RESTful-v1.2.pdf.xhtml?ln=default&v=0
 * @author cprobst
 *
 */
public interface ClientService {
    Eta getUserMenu(InetAddress address);
    Eta getUserVar(InetAddress address, String path);
    Eta getUserVarInfo(InetAddress address, String path);
}
