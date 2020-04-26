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

    @Test
    public void test8_4() {

        ArrayList<Exercise> exercises = new ArrayList();
        BalanceExercise balanceExercise = new BalanceExercise("Test name", 30, 2, 2, 80, "Mat");
        exercises.add(balanceExercise);
        Program program = new Program(exercises, "Test program");
        assertEquals(program.calculateDuration(), 30);


    }

    @Test
    public void test8_5() {

        // This tests adds one exercise of each type to show that the program is balanced
        ArrayList<Exercise> exercises = new ArrayList();
        StrengthExercise strengthExercise = new StrengthExercise("Test name1", 20, 3, 3, 30, 0, "Bar");
        EnduranceExercise enduranceExercise = new EnduranceExercise("Test name2", 40, 2, 2, 50, "Null");
        BalanceExercise balanceExercise = new BalanceExercise("Test name3", 10, 2, 2, 55, "Null");
        FlexibilityExercise flexibilityExercise = new FlexibilityExercise("Test name4", 40, 3,3, 20, "Null");

        exercises.add(strengthExercise);
        exercises.add(enduranceExercise);
        exercises.add(balanceExercise);
        exercises.add(flexibilityExercise);

        // checkBalance is asserted true because we expect the program to be balanced
        Program program = new Program(exercises, "Test program");
        assertEquals(program.checkBalance(), true);
    }

    @Test
    public void test8_6() {

        // This test adds one Strength, one, Endurance and two Balance exercises to show that it is not balanced unless
        // it contains one exercise from each exercise type
        ArrayList<Exercise> exercises = new ArrayList();
        StrengthExercise strengthExercise = new StrengthExercise("Test name1", 20, 3, 3, 30, 0, "Bar");
        EnduranceExercise enduranceExercise = new EnduranceExercise("Test name2", 40, 2, 2, 50, "Null");
        BalanceExercise balanceExercise = new BalanceExercise("Test name3", 10, 2, 2, 55, "Null");
        BalanceExercise balanceExercise1 = new BalanceExercise("Test name4", 40,2,2,50, "Null");

        exercises.add(strengthExercise);
        exercises.add(enduranceExercise);
        exercises.add(balanceExercise);
        exercises.add(balanceExercise1);

        // checkBalance is asserted false because we expect the program not to be balanced
        Program program = new Program(exercises, "Test program");
        assertEquals(program.checkBalance(), false);

    }

    //testing if calculate intensity works or not
    @Test
    public void test8_7(){
        ArrayList<Exercise> testData = new ArrayList<>();
        testData.add(new StrengthExercise("",5,4,3,5,10,""));
        testData.add(new StrengthExercise("",5,4,3,3,10,""));
        testData.add(new StrengthExercise("",5,4,3,9,10,""));

        var program = new Program(testData,"");
        assertEquals(9.0, program.getIntensityLevel(),0);
    }
}
