package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnduranceExerciseTest {
    @Test

    public void test2_1() {

        // Unit test for endurance class
        EnduranceExercise enduranceExercise = new EnduranceExercise("Test name", 20, 2, 3, 10, "Mat");
        assertEquals(enduranceExercise.equipment, "Mat");
    }
}
