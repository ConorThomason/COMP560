package com.conorthomason.model;

public class ConstraintCell {
    private ConstraintCell upperCell;
    private ConstraintCell leftCell;
    private ConstraintCell rightCell;
    private ConstraintCell lowerCell;
    private char cellKey;
    private int cellValue;

    public ConstraintCell (char cellKey){
        this.cellValue = 0;
        this.cellKey = cellKey;
    }

    public char getCellKey(){
        return this.cellKey;
    }

    public int getCellValue(){
        return this.cellValue;
    }

    public void setCellValue(int cellValue){
        this.cellValue = cellValue;
    }

    public boolean hasAdjacent(){
        return (upperCell != null || leftCell != null || rightCell != null || lowerCell != null);
    }

    public void setCellValue(char cellValue){
        this.cellValue = cellValue;
    }
    public ConstraintCell getUpperCell() {
        return upperCell;
    }

    public void setUpperCell(ConstraintCell upperCell) {
        this.upperCell = upperCell;
    }

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

    public ConstraintCell getLowerCell() {
        return lowerCell;
    }

    public void setLowerCell(ConstraintCell lowerCell) {
        this.lowerCell = lowerCell;
    }

    @Override
    public String toString() {
        return "" + cellValue;
    }
}
