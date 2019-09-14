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
            int generatedValue = generatedValidValue(dataArray[row][column], row, column);
            if (generatedValue != -1) {
                dataArray[row][column] = generatedValue;
                if (column == arraySize - 1)
                    return simpleBacktrackSolve(++row, 0);
                else
                    return simpleBacktrackSolve(row, ++column);
            }
            else
                return false;
        }
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