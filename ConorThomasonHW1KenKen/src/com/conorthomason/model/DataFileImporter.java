package com.conorthomason.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFileImporter {
    private ConstraintCell constrainedArray[][];
    private TreeMap<Character, SolutionConstraint> constraints;

    public DataFileImporter() throws FileNotFoundException {
        constraints = new TreeMap();
        importData();
    }

    public void importData() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/Data"));
        int arraySize = Integer.parseInt(input.nextLine());
        constrainedArray = new ConstraintCell[arraySize][arraySize];
        try {
            for (int i = 0; i < arraySize; i++) {
                String currentLine = input.next();
                for (int j = 0; j < arraySize; j++) {
                    ConstraintCell newCell = new ConstraintCell(currentLine.charAt(j));
                    if (adjacentCellCheck(i+1, j))
                        newCell.setRightCell(constrainedArray[i+1][j]);
                    if (adjacentCellCheck(i - 1, j))
                        newCell.setLeftCell(constrainedArray[i-1][j]);
                    if (adjacentCellCheck(i, j+1))
                        newCell.setLowerCell(constrainedArray[i][j+1]);
                    if (adjacentCellCheck(i, j-1))
                        newCell.setUpperCell(constrainedArray[i][j-1]);
                    constrainedArray[i][j] = newCell;
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Data file issue, please check provided file");
            //Either non-existent or incorrect bounds provided
        }
        Utils.printConstrainedArray(constrainedArray);
        while (input.hasNext()){
            String currentLine = input.next();
            Pattern pattern = Pattern.compile("[A-Z]+");
            Matcher matcher = pattern.matcher(currentLine);
            matcher.find();
            char key = matcher.group(0).charAt(0);

            pattern = Pattern.compile("[0-9]+");
            matcher = pattern.matcher(currentLine);
            matcher.find();
            int value = Integer.parseInt(matcher.group(0));

            pattern = Pattern.compile("[\\/\\+\\-\\*]");
            matcher = pattern.matcher(currentLine);
            matcher.find();
            char operator = matcher.group(0).charAt(0);

            SolutionConstraint currentConstraint = new SolutionConstraint(key, value, operator);
            constraints.put(key, currentConstraint);
        }
        printTreeMap();
    }
    public boolean adjacentCellCheck(int i, int j){
        try{
            if (constrainedArray[i][j] != null)
                return true;
            else
                return false;
        } catch (NullPointerException e){
            return false;
        } catch (ArrayIndexOutOfBoundsException f){
            return false;
        }
    }
    public void printTreeMap(){
        for (Map.Entry<Character, SolutionConstraint> entry : constraints.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }
    public boolean filledArrayCheck(){
        try{
            for (int i = 0; i < constrainedArray.length; i++){
                for (int j = 0; j < constrainedArray.length; j++){
                    if (constrainedArray[i][j].getCellValue() == 0)
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

    public ConstraintCell[][] getConstrainedArray(){
        return this.constrainedArray;
    }
    public TreeMap<Character, SolutionConstraint> getConstraints(){
        return this.constraints;
    }
}
