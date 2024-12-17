package src;

import clientInt.WordyModule.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import src.gui.Welcome;

import javax.swing.*;
import java.lang.InterruptedException;
import java.util.*;

public class WordyClientMain {

    public static Wordy wordyImpl;

    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Wordy";
            wordyImpl = WordyHelper.narrow(ncRef.resolve_str(name));

            //loggingIn();
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
            welcome.pack();
            welcome.setLocationRelativeTo(null);
            welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            System.err.println("CORBA exception: " + e);
            e.printStackTrace(System.out);
        }
    }
}
    
    
