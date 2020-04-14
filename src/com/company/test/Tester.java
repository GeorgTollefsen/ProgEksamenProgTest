package com.company.test;

import com.company.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Tester {
    @Test
    public void test1_1() {

        //Taking in some data to test, one from each type of exercise
        Exercise squats = new StrenghtExercise("Squats", 20, 20,3,1, 0,"None");

        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 20, 10, 3, 1, "None");

        Exercise catCow = new FlexibilityExercise("Cat-cow", 10,10,3,1,"None");

        Exercise quadrupedElbowToKnee = new BalanceExercise("Quadruped elbow to knee", 10,10,3,1,"");

        //Adding the exercises to an ArrayList
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(squats);
        exercises.add(jumpingJack);
        exercises.add(catCow);
        exercises.add(quadrupedElbowToKnee);

        //Adds a new person with preferred exercise catCow, acceptable intensity 2, and currentProgram null
        //ExerciseManager takes in the different exercises
        //test_program takes in person and generates program
        Person person = new Person("Test navn", catCow, 2, null);
        ExerciseManager exerciseManager = new ExerciseManager(exercises);
        Program test_progam = exerciseManager.generateProgram(person, "Test program");

        /* assertEquals tests if the test program is balanced, has an acceptable intensityLevel
         and is an acceptable program for a person by asserting it as true for that given person */
        assertEquals(test_progam.isBalanced, true);
        assertEquals(test_progam.intensityLevel, 1.0, 0);
        assertEquals(ExerciseManager.acceptableProgam(person, test_progam), true);
    }

    @Test
    public void test1_2() {

        // Taking in some data to test
        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10,6,3,12,"");
        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed",10,3,2,90,"");
        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15,5,3,45,"");
        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15,15,3,80,"");

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
