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

    public int findValid(int row, int column) {
        for (int i = 0; i < arraySize; i++) {
            if (validityCheck(i + 1, row, column))
                return i + 1;
        }
        return 0;
    }

    public boolean simpleBacktrackSolve(int row, int column) {
        if (filledArray(row, column))
            return true;
        else {
            int validValue = findValid(row, column);
            if (validValue != 0) {
                dataArray[row][column] = validValue;
                if (row != arraySize)
                    return simpleBacktrackSolve(++row, column);
                else
                    return simpleBacktrackSolve(row, ++column);
            }
            else {
                return false;
            }
        }
    }
        public boolean filledArray(int r, int c) {
            return (r == arraySize && c == arraySize) ? true : false;
        }
        public boolean validityCheck(int v, int r, int c){
            //Checks if duplicate number is in row or column
            for (int i = 0; i < dataArray.length; i++) {
                if (v == dataArray[r][i] || v == dataArray[i][c]) {
                    return false;
                }
            }
            return true;
        }
    }