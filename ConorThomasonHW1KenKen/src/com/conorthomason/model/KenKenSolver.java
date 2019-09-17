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
        if (simpleBacktrackSolve())
            return constrainedArray;
        else
            return constrainedArray; //If it returns false, that means no solution was found.
    }

    public boolean simpleBacktrackSolve(){
        int row = -1;
        int column = -1;
        boolean isEmpty = true;
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (constrainedArray[i][j].getCellValue() == 0){
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
                constrainedArray[row][column].setCellValue(attempt);

                if (!kenKenCheck(constrainedArray[row][column].getCellKey())) {
                    return false;
                }

                if (simpleBacktrackSolve())
                    return true;
                else
                    constrainedArray[row][column].setCellValue(0);
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
            //ArrayList used due to unknown number of values.
            //Will need to iterate through for operation checking later anyway, so it's not significantly detrimental.
            //Collects all the values, compiles them into an easily iterable list.
            ArrayList<Integer> workingList = new ArrayList<Integer>();
            valuedCellDive(cellSearch(key), workingList);

            int workingValue = 0;
            char operator = constraints.get(key).getOperator();
            switch(operator){
                case '+':
                    for (int i = 0; i < workingList.size(); i++){
                        workingValue = workingValue + workingList.get(i);
                    }
                    break;
                case '-':
                    for (int i = 0; i < workingList.size(); i++){
                        workingValue = workingValue - workingList.get(i);
                    }
                    break;
                case '/':
                    for (int i = 0; i < workingList.size(); i++){
                        workingValue = workingValue / workingList.get(i);
                    }
                    break;
                case '*':
                    for (int i = 0; i < workingList.size(); i++){
                        workingValue = workingValue * workingList.get(i);
                    }
                    break;
            }
            if (!(workingValue == constraints.get(key).getValue()))
                return false;
            //If it is true, then it will drop out of the if statement anyway.
        }
        //Want to return true so that it continues the run, despite the fact there are 0s. Otherwise it will constantly
        //erase work already done.
        return true;
    }

    //Returns first found instance of a cell of a key.
    public ConstraintCell cellSearch(char key){
        try {
            int foundI = -1;
            int foundJ = -1;
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    if (constrainedArray[i][j].getCellKey() == key) {
                        foundI = i;
                        foundJ = j;
                        break;
                    }
                }
            }
            return constrainedArray[foundI][foundJ];
        } catch (NullPointerException e){
            System.out.println("Key not found, please check data file for errors");
        } catch (ArrayIndexOutOfBoundsException f){
            f.printStackTrace();
        }
        return null;
    }
    public boolean kenKenFilled(char key){
        //Introducing a pseudo-path-finding search method because my initial setup was questionable. This should
        //make up for efficiency... ideally.
        ConstraintCell currentCell = cellSearch(key);
        return cellDive(currentCell);
    }
    public ArrayList<Integer> valuedCellDive(ConstraintCell cell, ArrayList<Integer> workingList){
        workingList.add(cell.getCellValue());
        if (cell.hasAdjacent()){
            if (cell.getUpperCell() != null)
                workingList = valuedCellDive(cell.getUpperCell(), workingList);
            if (cell.getLeftCell() != null)
                workingList = valuedCellDive(cell.getLeftCell(), workingList);
            if (cell.getRightCell() != null)
                workingList = valuedCellDive(cell.getRightCell(), workingList);
            if (cell.getLowerCell() != null)
                workingList = valuedCellDive(cell.getLowerCell(), workingList);
        }
        return workingList;
    }
    public boolean cellDive(ConstraintCell cell){
        try {
            boolean result = true;
            if (cell.getCellValue() == 0)
                return false;
            else if (cell.hasAdjacent()) {
                return (cellDive(cell.getUpperCell()) && cellDive(cell.getLeftCell())
                        && cellDive(cell.getRightCell()) && cellDive(cell.getLowerCell()));
            } else
                return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
    private boolean safeValueCheck(int value, int row, int column){
        for (int i = 0; i < arraySize; i++){
            if (constrainedArray[row][i].getCellValue() == value){
                return false;
            }
        }

        for (int j = 0; j < arraySize; j++){
            if (constrainedArray[j][column].getCellValue() == value){
                return false;
            }
        }
        return true;
    }
}