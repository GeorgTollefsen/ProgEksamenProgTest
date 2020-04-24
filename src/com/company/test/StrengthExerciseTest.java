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

    @Test
    public void test9_2() {
        StrengthExercise strengthExercise = new StrengthExercise("Test", 10, 15, 3, 3, 10, "chair");
        assertEquals(strengthExercise.getType(), ExerciseType.STRENGTH);
    }
}
