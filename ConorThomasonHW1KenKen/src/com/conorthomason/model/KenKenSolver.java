package com.conorthomason.model;

public class KenKenSolver {
    private char constrainedArray[][];
    private int dataArray[][];
    public KenKenSolver(char constrainedArray[][], int dataArray[][]){
        this.constrainedArray = constrainedArray;
        this.dataArray = dataArray;
    }

    public int[][] simpleBacktrackSolve(){
        return dataArray;
    }
}
