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

    // Unit test for selectPreferred

    @Test
    public void test7_2() {

        ArrayList<Exercise> testilini = new ArrayList<>();
        ArrayList<Program> programi = new ArrayList<>();


        Exercise dance = new BalanceExercise("Dance",35,10,4,0,"Dance shoes" );
        testilini.add(dance);

        Program testProgram = new Program(testilini, "Test program");
        programi.add(testProgram);

        Person p1 = new Person("Test1", ExerciseType.BALANCE, 55, testProgram);

        // Send program in to p1 to look for the ArrayList has a acceptable program for p1
        //  If the program in unacceptable then testCase1 will be "null".

        String testCase1 =  p1.selectPreferred(programi).name;
        String expectedFalseValue = "null";
        assertTrue(testCase1.equalsIgnoreCase(expectedFalseValue));
        
    }
    @Test
    public void test7_3(){
        // Testing selectPreferred to see if the program is acceptable for p2 with strength exercise
        // If accepted outcome = "Test Program 2"

        ArrayList<Exercise> testArrayE = new ArrayList<>();
        ArrayList<Program> testArrayP = new ArrayList<>();

        Exercise pushup = new StrengthExercise("pushup", 10, 10, 4, 30, 0, "");
        testArrayE.add(pushup);

        Program testProgram2 = new Program(testArrayE, "Test Program 2");
        testArrayP.add(testProgram2);

        Person p2 = new Person("Heidi", ExerciseType.STRENGTH, 28, testProgram2);

        String testCase2 = p2.selectPreferred(testArrayP).name;
        String expectedTrueValue = "Test Program 2";
        assertTrue(testCase2.equalsIgnoreCase(expectedTrueValue));
        }
    }


