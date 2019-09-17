package com.conorthomason.model;

public class SolutionConstraint {
    private String key;
    private int value;
    private char operator;

    public SolutionConstraint(String key, int value, char operator){
        this.key = key;
        this.value = value;
        this.operator = operator;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "SolutionConstraint{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", operator=" + operator +
                '}';
    }
}
