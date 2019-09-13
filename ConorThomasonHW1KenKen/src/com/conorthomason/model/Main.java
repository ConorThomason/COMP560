package com.conorthomason.model;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    DataFileImporter importer = new DataFileImporter();
	    KenKenSolver solver = new KenKenSolver(importer.getConstrainedArray(), importer.getDataArray(), importer.getConstraints());
	    System.out.println();
	    Utils.printDataArray(solver.solveKenKen());
    }

}