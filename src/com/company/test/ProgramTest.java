package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramTest {
    @Test

    public void test8_1() {

        // Unit test for Program class
        ArrayList<Exercise> exercises = new ArrayList<>();
        Program program = new Program(exercises, "Test name");
        assertEquals(program.name, "Test name");
        assertEquals(program.exercises.size(), 0);
    }

    @Test

    public void test8_2() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        Program program = new Program(exercises, "test");
        assertEquals("test", program.getName());
    }

    @Test

    public void test8_3() {

        // Taking in some data to test if the sorting algorithm on intensity works
        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10, 6, 3, 12, "");
        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed", 10, 3, 2, 90, "");
        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15, 5, 3, 45, "");
        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15, 15, 3, 80, "");

        // Adding the exercises to an ArrayList
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(treePoseEyesClosed);
        exercises.add(balanceStarEyesClosed);
        exercises.add(warriorEyesClosed);
        exercises.add(skaterHops);

        // Putting them into a program
        Program program = new Program(exercises, "Test 2");

        /* Testing to see if the given data with the initial intensity 12, 90, 45 and 80 is shuffled
        to the correct order of increasing intensity, which should be 12, 45, 80, 90 */
        assertEquals(program.exercises.get(0), treePoseEyesClosed);
        assertEquals(program.exercises.get(1), warriorEyesClosed);
        assertEquals(program.exercises.get(2), skaterHops);
        assertEquals(program.exercises.get(3), balanceStarEyesClosed);
    }
}
