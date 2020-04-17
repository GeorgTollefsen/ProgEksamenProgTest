package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BalanceExerciseTest {
    @Test

    public void test1_1() {

        // Unit test for balance class
        BalanceExercise balanceExercise = new BalanceExercise("Test name", 30, 2, 2, 50, "None");
        assertEquals(balanceExercise.equipment, "None");
    }

}
