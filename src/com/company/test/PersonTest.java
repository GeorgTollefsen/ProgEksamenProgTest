package com.company.test;

import com.company.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonTest {


    @Test

    public void test7_1() {

        // Unit test for Person class
        // Taking in some data
        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10, 6, 3, 12, "");

        // Taking in an ArrayList
        ArrayList<Exercise> thorprogramExercise = new ArrayList<Exercise>();
        thorprogramExercise.add(treePoseEyesClosed);
        Program thorProgram = new Program(thorprogramExercise, "The Thor Program");


        Person person = new Person("Test name", ExerciseType.BALANCE, 40, thorProgram);
        assertEquals(person.name, "Test name");
        assertEquals(person.preferredExerciseType, ExerciseType.BALANCE);
        assertEquals(person.acceptableIntensity, 40, 0.0);
        assertEquals(person.currentProgram, thorProgram);

    }

    // unit test for selectPreferred

    // All programs will load here and we will see if the program is a match or not
    // It consideres intensity and if the program includes a an exercise the person preferres
    // If the program does not have one such exercise or the intensity is to high/low, you get a false
    @Test
    public void test7_2() {

    }
    }


