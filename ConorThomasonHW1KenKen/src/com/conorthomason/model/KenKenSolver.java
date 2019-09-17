package com.conorthomason.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class KenKenSolver {
    private ConstraintCell constrainedArray[][];
    private int arraySize;
    private TreeMap<Character, SolutionConstraint> constraints;

    public KenKenSolver(ConstraintCell constrainedArray[][], TreeMap constraints) {
        this.constrainedArray = constrainedArray;
        this.constraints = constraints;
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
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (constrainedArray[i][j].getCellKey() == currentChar)
                    if (constrainedArray[i][j].getCellValue() == 0)
                        return false;
            }
        }
        return true;
    }
    private boolean safeKenKen(int row, int column, int value){
        char currentChar = constrainedArray[row][column].getCellKey();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (constrainedArray[i][j].getCellKey() == currentChar)
                        list.add(constrainedArray[i][j].getCellValue());
            }
        }
        try {
            int workingValue = list.get(0);
            switch (constraints.get(constrainedArray[row][column].getCellKey()).getOperator()) {
                case '+':
                    for (int i = 1; i < list.size(); i++) {
                        workingValue = workingValue + list.get(i);
                    }
                    break;
                case '-':
                    for (int i = 1; i < list.size(); i++) {
                        workingValue = workingValue - list.get(i);
                    }
                    break;
                case '/':
                    for (int i = 1; i < list.size(); i++) {
                        workingValue = workingValue / list.get(i);
                    }
                    break;
                case '*':
                    for (int i = 1; i < list.size(); i++) {
                        workingValue = workingValue * list.get(i);
                    }
                    break;
            }
            if (workingValue != constraints.get(constrainedArray[row][column].getCellKey()).getValue())
                return false;

        } catch (IndexOutOfBoundsException e) {
            return true;
        }
        return true;
    }
    private boolean safeValueCheck(int value, int row, int column) {
        if (safeRow(row, value) && safeColumn(column, value))
            if (kenKenRegionFilled(row, column))
                return safeKenKen(row, column, value);
            else
                return true;
        return false;

    }

}