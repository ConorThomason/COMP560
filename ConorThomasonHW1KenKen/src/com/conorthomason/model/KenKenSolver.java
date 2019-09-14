package com.conorthomason.model;

import java.util.TreeMap;

public class KenKenSolver {
    private char constrainedArray[][];
    private int dataArray[][];
    private int arraySize;
    private TreeMap<String, SolutionConstraint> constraints;

    public KenKenSolver(char constrainedArray[][], int dataArray[][], TreeMap constraints) {
        this.constrainedArray = constrainedArray;
        this.dataArray = dataArray;
        this.constraints = constraints;
        arraySize = dataArray.length;
    }

    public int[][] solveKenKen() {

        if (simpleBacktrackSolve(0, 0))
            return dataArray;
        else
            return dataArray; //If it returns false, that means no solution was found.
    }

    public boolean simpleBacktrackSolve(int row, int column){
        if (filledArray()){
            return true;
        }
        else{
            int possibleIterations = 6;
            while (possibleIterations <= 6){

                //Limiting the possible iterations, for repeated generated values

                //Generate a value, takes into account whatever is in the current index
                int generatedValue = generatedValidValue(dataArray[row][column], row, column);

                //If it's -1, there are no valid values.
                if (generatedValue != -1) {
                    possibleIterations++;
                    dataArray[row][column] = generatedValue;
                    boolean result;
                    if (column == arraySize - 1)
                        result = simpleBacktrackSolve(++row, 0);
                    else
                        result = simpleBacktrackSolve(row, ++column);
                    if (result)
                        continue;
                    else
                        return true;
                }
                //Returning false SHOULD reset the previous value, and continue attempts. Will work up until it works.
                else
                    return false;
            }
        }
        return false;
    }

    public boolean filledArray(){
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (dataArray[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    public int generatedValidValue(int currentValue, int row, int column){
        while (currentValue != 6){
            if (validValue(++currentValue, row, column))
                return currentValue;
        }
        return -1;
    }
    public boolean validValue(int value, int row, int column){
        for (int i = 0; i < dataArray.length; i++){
            if (dataArray[row][i] == value || dataArray[i][column] == value){
                return false;
            }
        }
        return true;
    }
}