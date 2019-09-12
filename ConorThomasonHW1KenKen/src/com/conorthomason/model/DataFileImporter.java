package com.conorthomason.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFileImporter {
    private char constrainedArray[][];
    private int dataArray[][];
    private TreeMap<String, SolutionConstraint> constraints;

    public DataFileImporter() throws FileNotFoundException {
        constraints = new TreeMap();
        importData();
    }

    public void importData() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/Data"));
        int arraySize = Integer.parseInt(input.nextLine());
        dataArray = new int[arraySize][arraySize];
        constrainedArray = new char[arraySize][arraySize];
        try {
            for (int i = 0; i < arraySize; i++) {
                String currentLine = input.next();
                for (int j = 0; j < arraySize; j++) {
                    constrainedArray[i][j] = currentLine.charAt(j);
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Data file issue, please check provided file");
            //Either non-existent or incorrect bounds provided
        }
        printConstrainedArray();
        while (input.hasNext()){
            String currentLine = input.next();
            Pattern p = Pattern.compile("/^[A-Z]+$/i");
            String key = p.matcher(currentLine).group();
            p = Pattern.compile("^[0-9]*$");
            int value = Integer.parseInt(p.matcher(currentLine).group());
            p = Pattern.compile("([\\/\\+\\-\\*])");
            char operator = p.matcher(currentLine).group().charAt(0);
            SolutionConstraint currentConstraint = new SolutionConstraint(key, value, operator);
            constraints.put(key, currentConstraint);
        }
        printTreeMap();
    }
    public void printTreeMap(){
        for (Map.Entry<String, SolutionConstraint> entry : constraints.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }
    public boolean filledArrayCheck(){
        try{
            for (int i = 0; i < dataArray.length; i++){
                for (int j = 0; j < dataArray.length; j++){
                    if (dataArray[i][j] == 0)
                        return false;
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Data file issue, not all spaces have been filled");
            //Not all spaces are filled
        }
        return true;
    }

    public void printConstrainedArray() {
        for (int i = 0; i < constrainedArray.length; i++) {
            for (int j = 0; j < constrainedArray.length; j++) {
                System.out.print(constrainedArray[i][j]);
            }
            System.out.println();
        }
    }
    public void printDataArray() {
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray.length; j++) {
                System.out.print(dataArray[i][j]);
            }
            System.out.println();
        }
    }

}
