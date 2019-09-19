package com.conorthomason.model;

import java.util.ArrayList;

public class Cage {
    private ArrayList<ConstraintCell> cells;
    private char cageKey;
    public Cage(char cageKey){
        cells = new ArrayList();
        this.cageKey = cageKey;
    }

    public char getCageKey(){
        return this.cageKey;
    }

    public ConstraintCell getCellIndex(int index){
        return cells.get(index);
    }

    public int getCageSize(){
        return this.cells.size();
    }

    public void setCageKey(char cageKey){
        this.cageKey = cageKey;
    }
    public void addToCage(ConstraintCell cell){
        this.cells.add(cell);
    }

    public boolean filledCage(){
        for (int i = 0; i < cells.size(); i++){
            if (cells.get(i).getCellValue() == 0){
                return false;
            }
        }
        return true;
    }
}