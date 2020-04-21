package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BalanceExerciseTest {
    @Test
    public void test1_1() {

        // Unit test for balance class

        // Takes in data
        BalanceExercise balanceExercise = new BalanceExercise("Test name", 30, 2, 2, 50, "None");

        // Checks if assert equals of balanceExercise.equipment is the same as what it is in the data, which is "None"
        assertEquals(balanceExercise.equipment, "None");
    }

    @Test
    public void test1_2() {

        // Testing the getType(), to see if it returns the correct ExerciseType
        BalanceExercise balanceExercise = new BalanceExercise("Test name", 20, 1, 3, 70, "None");
        assertEquals(balanceExercise.getType(), ExerciseType.BALANCE);
    }

}
