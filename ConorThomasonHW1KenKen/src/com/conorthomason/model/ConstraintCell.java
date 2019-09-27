package com.conorthomason.model;

import java.util.ArrayList;

public class ConstraintCell {
    private char cellKey;
    private int cellValue;
    private int cellCost;
    private ConstraintCell leftCell;
    private ConstraintCell rightCell;
    private ConstraintCell upperCell;
    private ConstraintCell lowerCell;

    public ConstraintCell getLeftCell() {
        return leftCell;
    }
    public ConstraintCell bestNodeNeighbor(){
        ArrayList<ConstraintCell> cells = new ArrayList<>();
        if (leftCell != null){
            cells.add(leftCell);
        }
        if (rightCell != null){
            cells.add(rightCell);
        }
        if (upperCell != null){
            cells.add(upperCell);
        }
        if (lowerCell != null){
            cells.add(lowerCell);
        }
        int lowestIndex = 0;
        for (int i = 0; i < cells.size(); i++){
                    if (cells.get(lowestIndex).getCellCost() > cells.get(i).getCellCost())
                        lowestIndex = i;
            }
        return cells.get(lowestIndex);
    }
    public void setLeftCell(ConstraintCell leftCell) {
        this.leftCell = leftCell;
    }

    public ConstraintCell getRightCell() {
        return rightCell;
    }

    public void setRightCell(ConstraintCell rightCell) {
        this.rightCell = rightCell;
    }

    public ConstraintCell getUpperCell() {
        return upperCell;
    }

    public void setUpperCell(ConstraintCell upperCell) {
        this.upperCell = upperCell;
    }

    public ConstraintCell getLowerCell() {
        return lowerCell;
    }

    public void setLowerCell(ConstraintCell lowerCell) {
        this.lowerCell = lowerCell;
    }

    public ConstraintCell (char cellKey){
        this.cellValue = 0;
        this.cellKey = cellKey;
    }

    public int getCellCost(){
        return this.cellCost;
    }
    public void setCellCost(int cellCost){
        this.cellCost = cellCost;
    }
    public char getCellKey(){
        return this.cellKey;
    }

    public void setCellKey(char cellKey){
        this.cellKey = cellKey;
    }
    public int getCellValue(){
        return this.cellValue;
    }

    public void setCellValue(int cellValue){
        this.cellValue = cellValue;
    }


    public void setCellValue(char cellValue){
        this.cellValue = cellValue;
    }

    @Override
    public String toString() {
        return "" + cellValue;
    }

    public boolean equals(ConstraintCell cell){
        if (this.cellValue == cellValue){
            if (this.cellCost == cellCost){
                if (this.cellKey == cellKey){
                    return true;
                }
            }
        }
        return false;
    }
}