package com.conorthomason.model;

public class Utils {
    public static void printConstrainedArray(ConstraintCell[][] constrainedArray) {
        for (int i = 0; i < constrainedArray.length; i++) {
            for (int j = 0; j < constrainedArray.length; j++) {
                System.out.print(constrainedArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printConstrainedKeys(ConstraintCell[][] constraintArray) {
        for (int i = 0; i < constraintArray.length; i++) {
            for (int j = 0; j < constraintArray.length; j++) {
                System.out.print(constraintArray[i][j].getCellKey() + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
