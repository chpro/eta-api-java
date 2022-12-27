package chpro.eta.api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;

import chpro.eta.api.client.ClientService;
import chpro.eta.api.client.data.Eta;
import chpro.eta.api.client.data.menu.Fub;
import chpro.eta.api.client.data.menu.Object;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.core.util.CollectionUtils;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "api", description = "...",
        mixinStandardHelpOptions = true)
public class ApiCommand implements Runnable {

    @Option(names = { "-v", "--vars" }, description = "Get and print all vars which are referenced by getMenu")
    boolean printVars;
    
    @Option(names = { "-i", "--var-infos" }, description = "Get and print all infos of vars which are referenced by getMenu")
    boolean printVarInfos;
    
    @Option(names = { "-m", "--menu" }, description = "Get and print the menu")
    boolean printMenu;
    
    @Option(names = { "-h", "--hosts" }, description = "The ip addresses of the devices to which the request should be sent")
    HashSet<String> inetAddresses;

    
    @Inject
    ClientService clientService;
    
    public static void main(String[] args) throws Exception {
        PicocliRunner.run(ApiCommand.class, args);
    }

    public void run() {
        // business logic here
        if (CollectionUtils.isEmpty(inetAddresses)) {
            System.out.println("Not host specified");
            return;
        }
        try {
            if (printVars || printVarInfos || printMenu) {
                inetAddresses.stream().map(x -> mapString2InetAddress(x)).forEach(x -> executeRest(x));
            } else {
                System.out.println("Nothing to print specified");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void executeRest(InetAddress host) {
        System.out.println("Get infos from host " + host);
        Eta eta = clientService.getUserMenu(host);
        
        if (printMenu) {
            System.out.println("======= ETA Menu =======");
            System.out.println(eta);
        }
        
        if (printVarInfos || printVars) {
            System.out.println("======= ETA variable details =======");
            for (Fub fub : eta.getMenu().getFubs()) {
                processObjects(host, fub.getObjects());
            }
        }
    }

    private void processObjects(InetAddress x, Collection<Object> objects) {
        if (objects == null)
            return;
        
        for(Object obj : objects) {
            Eta userVar = clientService.getUserVar(x , obj.getUri());
            Eta varInfo = clientService.getUserVarInfo(x, obj.getUri());
            if (printVarInfos) {
                System.out.println(varInfo);
                System.out.println("");
            }
            if (printVars) {
                System.out.println(userVar);
                System.out.println("");
            }
            processObjects(x, obj.getObjects());
        }
        
    }

    protected InetAddress mapString2InetAddress(String addr) {
        try {
            return InetAddress.getByName(addr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
