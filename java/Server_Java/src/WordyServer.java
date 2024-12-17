package src;

import serverInt.WordyModule.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.net.InetAddress;

public class WordyServer {

    public static void main(String[] args) {
        try {
            WordyImpl.setConnection();
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa and activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            WordyImpl wordyImpl = new WordyImpl();
            wordyImpl.setORB(orb);

            // get object reference from the servant
            Object ref = rootpoa.servant_to_reference(wordyImpl);
            Wordy href = WordyHelper.narrow(ref);

            // get the root naming context
            Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            String name = "Wordy";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("WordyServer ready and waiting ...");
            InetAddress ip = InetAddress. getLocalHost();
            System.out.println("Address: " + ip.getHostAddress());

            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("WordyServer Exiting...");
    }

}
