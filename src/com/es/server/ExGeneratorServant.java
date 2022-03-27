package com.es.server;

import exceptionGenerator.GeneratorPOA;
import org.omg.CORBA.ORB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExGeneratorServant extends GeneratorPOA {
    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public String Generate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Generate(String newGenerate) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("file.txt")));
            oos.writeObject(new UserException(newGenerate));
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
