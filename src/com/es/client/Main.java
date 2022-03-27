package com.es.client;

import com.es.server.UserException;
import exceptionGenerator.Generator;

import exceptionGenerator.GeneratorHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound, IOException, ClassNotFoundException {
        ORB orb = ORB.init(args, null);
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        Generator generator = GeneratorHelper.narrow(ncRef.resolve_str("ABC"));

        System.out.println("Enter your message");
        String s = new Scanner(System.in).nextLine();

        generator.Generate(s);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("file.txt")));

        throw (UserException) ois.readObject();
    }
}
