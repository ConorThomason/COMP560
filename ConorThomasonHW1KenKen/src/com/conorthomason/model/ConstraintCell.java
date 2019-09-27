package com.conorthomason.model;

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
}