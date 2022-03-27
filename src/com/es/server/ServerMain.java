package com.es.server;

import exceptionGenerator.Generator;
import exceptionGenerator.GeneratorHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            ExGeneratorServant servant = new ExGeneratorServant();
            servant.setOrb(orb);

            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(servant);
            Generator href = GeneratorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent[] path = ncRef.to_name("ABC");
            ncRef.rebind(path, href);

            while (true) {
                orb.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
