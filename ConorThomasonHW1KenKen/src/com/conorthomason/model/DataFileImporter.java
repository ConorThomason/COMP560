package com.conorthomason.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DataFileImporter {
    private char constrainedArray[][];
    private int dataArray[][];
    private HashMap<Character, Character> constraints;

    public DataFileImporter() throws FileNotFoundException {
        importData();
    }

    public void importData() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Data.txt"));
        int arraySize = Integer.parseInt(input.nextLine());
        dataArray = new int[arraySize][arraySize];
        try {
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    constrainedArray[i][j] = input.next().charAt(j);
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Data file issue, please check provided file");
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
        }
        return true;
    }

}
