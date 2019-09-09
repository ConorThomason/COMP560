package com.conorthomason.model;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    DataFileImporter importer = new DataFileImporter();
	    importer.importData();
    }
}