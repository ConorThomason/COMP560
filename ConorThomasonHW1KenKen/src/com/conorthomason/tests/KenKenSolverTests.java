package com.conorthomason.tests;

import com.conorthomason.model.Cage;
import com.conorthomason.model.ConstraintCell;
import com.conorthomason.model.SolutionConstraint;
import org.junit.Test;
import com.conorthomason.model.KenKenSolver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KenKenSolverTests {
    @Test
    public void kenKenCheckTest(){
        KenKenSolver solver = new KenKenSolver();
        ConstraintCell a1 = new ConstraintCell('A');
        a1.setCellValue(1);
        ConstraintCell a2 = new ConstraintCell('A');
        a2.setCellValue(4);
        ConstraintCell a3 = new ConstraintCell('A');
        a3.setCellValue(8);

        Cage cellCage = new Cage(a3.getCellKey());
        cellCage.addToCage(a1);
        cellCage.addToCage(a2);
        cellCage.addToCage(a3);

        Cage divisionSubCage = new Cage(a3.getCellKey());
        divisionSubCage.addToCage(a2);
        divisionSubCage.addToCage(a3);

        assertTrue(solver.kenKenValid(cellCage, '+', 13));
        assertTrue(solver.kenKenValid(cellCage, '*', 32));
        assertTrue(solver.kenKenValid(divisionSubCage, '-', 4));
        assertTrue(solver.kenKenValid(divisionSubCage, '/', 2));

    }
}
