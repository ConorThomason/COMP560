package com.conorthomason.model;

public class ConstraintCell {
    private ConstraintCell upperCell;
    private ConstraintCell leftCell;
    private ConstraintCell rightCell;
    private ConstraintCell lowerCell;
    private char cellValue;

    public ConstraintCell (char cellValue){
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
}
