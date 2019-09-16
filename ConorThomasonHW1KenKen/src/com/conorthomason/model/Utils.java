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
    public static void printConstrainedArrayCharacters(ConstraintCell[][] constrainedArray) {
        for (int i = 0; i < constrainedArray.length; i++) {
            for (int j = 0; j < constrainedArray.length; j++) {
                System.out.print(constrainedArray[i][j].getCellKey() + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
