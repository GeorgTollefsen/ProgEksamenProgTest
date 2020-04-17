package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StrengthExerciseTest {
    @Test

    public void test9_1() {

        // Unit test for strength class
        StrengthExercise strengthExercise = new StrengthExercise("Test name", 10, 10, 1, 70, 10, "Table");
        assertEquals(strengthExercise.equipment, "Table");

    }
}
