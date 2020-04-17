package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlexibilityExerciseTest {
    @Test

    public void test5_1() {

        // Unit test for flexibility class
        FlexibilityExercise flexibilityExercise = new FlexibilityExercise("Test name", 45, 1, 1, 40, "Water bottle");
        assertEquals(flexibilityExercise.requirement, "Water bottle");
    }
}
