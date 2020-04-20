package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExerciseTest {
    @Test

    public void test4_1() {

        // Unit test for Exercise class, which is abstract
        Exercise exercise = new BalanceExercise("Test name", 30, 2, 2, 60, "None");
        assertEquals(exercise.intensity, 60);
        assertEquals(exercise.sets, 2);
        assertEquals(exercise.repetitions, 2);
        assertEquals(exercise.duration, 30);
        assertEquals(exercise.name, "Test name");

    }
}
