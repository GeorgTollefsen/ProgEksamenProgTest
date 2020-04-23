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

    @Test
    public void test7_2() {

        ArrayList<Exercise> testilini = new ArrayList<>();
        ArrayList<Exercise> testilini2 = new ArrayList<>();
        ArrayList<Program> programi = new ArrayList<>();
        ArrayList<Program> programi2 = new ArrayList<>();

        Exercise dance = new BalanceExercise("Dance",35,10,4,0,"Dance shoes" );
        testilini.add(dance);

        Exercise slowDance = new BalanceExercise("Slow dance", 30,2,3,50,"Dance socks");
        testilini2.add(slowDance);

        Program testProgram2 = new Program(testilini2,"Test program 2");
        programi2.add(testProgram2);

        Program testProgram = new Program(testilini, "Test program");
        programi.add(testProgram);

        Person p1 = new Person("Test1", ExerciseType.BALANCE, 55, testProgram);

        // send programi inn to p1 to look for the arraylist has a acceptable program for p1
        //  if the program in unacceptable then testCase1 will be "null".

        String testCase1 =  p1.selectPreferred(programi).name;
        String expectedFalseValue = "null";
        assertTrue(testCase1.equalsIgnoreCase(expectedFalseValue));
        
    }
    }


