package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExerciseManagerTest {

   /* @Test

    public void test3_1() {

        Taking in some data to test, one from each type of exercise
        Exercise squats = new StrengthExercise("Squats", 20, 20,3,1, 0,"None");

        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 20, 10, 3, 1, "None");

        Exercise catCow = new FlexibilityExercise("Cat-cow", 10,10,3,1,"None");

        Exercise quadrupedElbowToKnee = new BalanceExercise("Quadruped elbow to knee", 10,1, 1, 1, "None");

                // Adding the exercises to an ArrayList
                ArrayList<Exercise> exercises = new ArrayList<>();
                exercises.add(squats);
                exercises.add(jumpingJack);
                exercises.add(catCow);
                exercises.add(quadrupedElbowToKnee);

        //Adds a new person with preferred exercise catCow, acceptable intensity 2, and cur
        //ExerciseManager takes in the different exercises
        //test_program takes in person and generates program
        Person person = new Person("Test navn", catCow, 2, null);
        ExerciseManager.buildProgram();
        Program test_progam = exerciseManager.generateProgram(person, "Test program");

        /* assertEquals tests if the test program is balanced, has an acceptable intensityL
        and is an acceptable program for a person by asserting it as true for that given p
        the comparing variable delta is 0
        assertEquals(test_progam.isBalanced, true);
        assertEquals(test_progam.intensityLevel, 1.0, 0);
        assertEquals(ExerciseManager.acceptableProgram(person, test_progam), true);
    }
        */


    @Test
    public void test3_2() {

        // Taking in some data to test
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
    public void test3_3_checkProgramPerson() {

        ArrayList<Exercise> exercises = new ArrayList<>();
        ArrayList<Exercise> exercises2 = new ArrayList<>();
        ArrayList<Exercise> exercises3 = new ArrayList<>();
        ArrayList<Exercise> exercises4 = new ArrayList<>();
        Exercise strengthTest = new StrengthExercise("test", 5,40,2,80,5,"");
        exercises2.add(strengthTest);
        Exercise flexibilityTest = new FlexibilityExercise("Test",3,3,3,80,"");
        exercises3.add(flexibilityTest);
        Exercise enduranceTest = new EnduranceExercise("test", 5,40,2,80, "");
        exercises4.add(enduranceTest);

        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10,6,3,12,"");
        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed",10,3,2,80,"");
        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15,5,3,45,"");
        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15,15,3,80,"");
        exercises.add(treePoseEyesClosed);
        exercises.add(balanceStarEyesClosed);
        exercises.add(warriorEyesClosed);
        exercises.add(skaterHops);

        Program programTestIntensityBalance = new Program(exercises, "IntensityBalance");
        Program programTestStrength = new Program(exercises2,"strength");

        Person testPerson1 = new Person("Testperson1",ExerciseType.BALANCE, 80, programTestIntensityBalance);
        Person testPerson2 = new Person("Testperson1",ExerciseType.STRENGTH, 80, programTestIntensityBalance);
        Person testPerson3 = new Person("Testperson1",ExerciseType.FLEXIBILITY, 80, programTestIntensityBalance);
        Person testPerson4 = new Person("Testperson1",ExerciseType.ENDURANCE, 80, programTestIntensityBalance);
        Person testPerson5 = new Person("Testperson1",ExerciseType.BALANCE, 0, programTestIntensityBalance);
//      below is the outcome strings from intensity and balance
        String whatHappens = ExerciseManager.checkProgramPerson(testPerson1, programTestIntensityBalance); // balance with intensity correct tested against balance only program
        String whatHappens2 = ExerciseManager.checkProgramPerson(testPerson2, programTestIntensityBalance); //strengt with intensity correct tested against balance only program
        String whatHappens3 = ExerciseManager.checkProgramPerson(testPerson3, programTestIntensityBalance); //flexibility with intensity correct tested against balance only program
        String whatHappens4 = ExerciseManager.checkProgramPerson(testPerson4, programTestIntensityBalance); //endurance with intensity correct tested against balance only program
        String whatHappens5 = ExerciseManager.checkProgramPerson(testPerson5, programTestIntensityBalance); // balance with intensity false tested against balance only program


        String expectedValue= "The program you have chosen is great for Testperson1";

        assertTrue(whatHappens.equalsIgnoreCase(expectedValue)); //checking with 4 balance when he prefers balance, and with intensity to correct level
        assertFalse(whatHappens2.equalsIgnoreCase(expectedValue)); //checking with 0 Strenghtexercises when he needs strength to be true
        assertFalse(whatHappens3.equalsIgnoreCase(expectedValue)); //checking with 0 felxibilityexercises when he needs felxibility to be true
        assertFalse(whatHappens4.equalsIgnoreCase(expectedValue)); //checking with 0 enduranceexercises when he needs endurance to be true
        assertFalse(whatHappens5.equalsIgnoreCase(expectedValue)); //testing if the acceptableIntensity is taken into account
        //balance and intensity is now fully tested for this function

    }
}
