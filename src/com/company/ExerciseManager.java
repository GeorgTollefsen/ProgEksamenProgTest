package com.company;

import java.util.ArrayList;

public class ExerciseManager {
    ArrayList<Exercise> exercises;

    public ExerciseManager(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public static boolean acceptableProgam(Person person, Program program) {
        return person.acceptableProgram(program);
    }
}
