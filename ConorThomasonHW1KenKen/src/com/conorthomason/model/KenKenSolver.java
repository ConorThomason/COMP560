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

        if (simpleBacktrackSolve())
            return dataArray;
        else
            return dataArray; //If it returns false, that means no solution was found.
    }

    public boolean simpleBacktrackSolve(){
        int row = -1;
        int column = -1;
        boolean isEmpty = true;
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (dataArray[i][j] == 0){
                    row = i;
                    column = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty){
                break;
            }
        }
        if (isEmpty){
            return true;
        }
        for (int attempt = 1; attempt <= arraySize; attempt++){
            if (safeValueCheck(attempt, row, column)){
                dataArray[row][column] = attempt;
                if (!kenKenCheck()) {

                }
                else if (simpleBacktrackSolve())
                    return true;
                else
                    dataArray[row][column] = 0;
            }
        }
        return false;
    }
    //Check to see if any full data blocks are filled. If they are, check if valid. If not, report false.
    //I need to see if there are any blocks that are filled. I need to find these blocks, check each element
    //of said blocks, and check they are nonzero. If they ARE nonzero, I need to check if they
    //match the constraints of the provided problem. If they do, great, return true. If not, return false,
    //and it should return to the algorithm checking them and attempt a different combination.
    public boolean kenKenCheck(char key){
        if (kenKenFilled(key)) {

        }

        return true;
    }
    public boolean kenKenFilled(char key){
        //Introducing a path-finding search method because my initial setup was questionable. This should
        //make up for efficiency... ideally.
        int foundI;
        int foundJ;
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (constrainedArray[i][j] == key){
                    foundI = i;
                    foundJ = j;
                }
                break;
            }
        }

        while (dataArray[i][j] != 0){

        }
    }

    public boolean safeValueCheck(int value, int row, int column){
        for (int i = 0; i < arraySize; i++){
            if (dataArray[row][i] == value){
                return false;
            }
        }

        for (int j = 0; j < arraySize; j++){
            if (dataArray[j][column] == value){
                return false;
            }
        }
        return true;
    }
}