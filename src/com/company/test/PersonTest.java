package com.company.test;

import com.company.*;

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
}

