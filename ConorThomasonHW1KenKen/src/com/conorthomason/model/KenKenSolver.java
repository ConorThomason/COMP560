package com.conorthomason.model;

import java.util.TreeMap;

public class KenKenSolver {
    private char constrainedArray[][];
    private int dataArray[][];
    private int arraySize;
    private int r = 0; //Current row
    private int c = 0; //Current column
    private TreeMap<String, SolutionConstraint> constraints;

    public KenKenSolver(char constrainedArray[][], int dataArray[][], TreeMap constraints) {
        this.constrainedArray = constrainedArray;
        this.dataArray = dataArray;
        this.constraints = constraints;
        arraySize = dataArray.length;
    }

    public int[][] solveKenKen() {

        if (simpleBacktrackSolve())
            return dataArray;
        else
            return dataArray; //If it returns false, that means no solution was found.
    }

    public int findValid() {
        for (int i = 0; i < arraySize; i++) {
            if (validityCheck(i))
                return i;
        }
        return 0;
    }

    public boolean simpleBacktrackSolve() {
        if (filledArray())
            return true;
        else {
            int validValue = findValid();
            if (validValue != 0) {
                dataArray[r][c] = validValue;
            }
        }
        return false;
    }
        public boolean filledArray() {
            return (r == arraySize && c == arraySize) ? true : false;
        }
        public boolean validityCheck(int v){
            //Checks if duplicate number is in row or column
            for (int i = 0; i < dataArray.length; i++) {
                if (v == dataArray[r][i] || v == dataArray[i][c]) {
                    return false;
                }
            }
            return true;
        }
    }