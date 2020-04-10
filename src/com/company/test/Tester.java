package com.company.test;

import com.company.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Tester {
    @Test
    public void test1_1 (){

        Exercise squats = new StrenghtExercise("Squats", 20, 20,3,1, 0,"None");

        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 20, 10, 3, 1, "None");

        Exercise catCow = new FlexibilityExercise("Cat-cow", 10,10,3,1,"None");

        Exercise quadrupedElbowToKnee = new BalanceExercise("Quadruped elbow to knee", 10,10,3,1,"");

        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(squats);
        exercises.add(jumpingJack);
        exercises.add(catCow);
        exercises.add(quadrupedElbowToKnee);

        Person person = new Person("Test navn", catCow, 2, null);
        ExerciseManager exerciseManager = new ExerciseManager(exercises);
        Program test_progam = exerciseManager.generateProgram(person, "Test progam");

        assertEquals(test_progam.isBalanced, true);
        assertEquals(test_progam.intensityLevel, 1.0, 0);


    }
}
