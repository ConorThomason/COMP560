package com.conorthomason.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class KenKenSolver {
    private ConstraintCell constrainedArray[][];
    private int arraySize;
    private TreeMap<Character, SolutionConstraint> constraints;
    private int[] constraintTally;

    public KenKenSolver(ConstraintCell constrainedArray[][], TreeMap constraints, int[] constraintTally) {
        this.constrainedArray = constrainedArray;
        this.constraints = constraints;
        this.constraintTally = constraintTally;
        arraySize = constrainedArray.length;
    }

    public ConstraintCell[][] solveKenKen() {
        if (simpleBacktrackSolve()) {
            System.out.println("Full Solution");
            return constrainedArray;
        }
        else {
            System.out.println("Incomplete Solution/No Solution");
            return constrainedArray; //If it returns false, that means no solution was found.
        }
    }

    public boolean simpleBacktrackSolve(){
        for (int row = 0; row < arraySize; row++){
            for (int col = 0; col < arraySize; col++){
                if (constrainedArray[row][col].getCellValue() == 0){
                    for (int i = 1; i <= arraySize; i++){
                        if (safeValueCheck(i, row, col)) {
                            constrainedArray[row][col].setCellValue(i);
                            if (simpleBacktrackSolve()) {
                                return true;
                            } else {
                                constrainedArray[row][col].setCellValue(0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean safeRow(int row, int value){
        for (int i = 0; i < arraySize; i++) {
            if (constrainedArray[row][i].getCellValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean safeColumn(int col, int value){
        for (int j = 0; j < arraySize; j++) {
            if (constrainedArray[j][col].getCellValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean kenKenRegionFilled(int row, int column){
        char currentChar = constrainedArray[row][column].getCellKey();
        int[] constraintCount = new int[26];
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (constrainedArray[i][j].getCellKey() == currentChar) {
                    constraintCount[(int)currentChar - 65]++;
                    if (constrainedArray[i][j].getCellValue() == 0)
                        return false;
                    else if (constraintCount[(int)currentChar-65] == constraintTally[(int)currentChar - 65]){
                        System.out.println("Region " + currentChar + " is filled");
                        return true;
                    }

                }
            }
        }
        return true;
    }
    private boolean safeValueCheck(int value, int row, int column) {
        kenKenRegionFilled(row, column);
        if (safeRow(row, value) && safeColumn(column, value))
            return true;
        return false;

    }

}