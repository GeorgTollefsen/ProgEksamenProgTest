package com.company;

import java.util.ArrayList;

public class ExerciseManager {
    ArrayList<Exercise> exercises;

    public ExerciseManager(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    //acceptableProgram is testing which program is acceptable for a person (3.a)
    public static boolean acceptableProgam(Person person, Program program) {
        return person.acceptableProgram(program);
    }

    //Generates suitable program for given person, including all the exercise types (3.b)
    public Program generateProgram(Person person, String projectName) {
        ArrayList<Exercise> exercisesForProgram = new ArrayList<>();
        exercisesForProgram.add(findExerciseByType(person, StrenghtExercise.class));
        exercisesForProgram.add(findExerciseByType(person, BalanceExercise.class));
        exercisesForProgram.add(findExerciseByType(person, FlexibilityExercise.class));
        exercisesForProgram.add(findExerciseByType(person, EnduranceExercise.class));
        return new Program(exercisesForProgram, projectName);

    }

    // Uses java generic types to find suitable exersise for a given class, isInstance checks for the right class
    // <T extends Exercise> says that the argument Class<T> classType should be a class T that extends Exercise
    public <T extends Exercise> Exercise findExerciseByType(Person person, Class<T> classType) {
        Exercise foundExercise = null;
        for (Exercise exercise : exercises) {
            if (classType.isInstance(exercise) && withinIntensityLevelForPerson(exercise, person)) {
                foundExercise = exercise;
            }
            if (foundExercise != null && person.preferredExercise == foundExercise) {
                break;
            }
        }
        if (foundExercise == null) {
            throw new RuntimeException("Finner ikke passende exercise");
        }

        return foundExercise;
    }

    //Checks if the intensity level is +/- 10% for a person
    public boolean withinIntensityLevelForPerson(Exercise exercise, Person person) {
        return exercise.intensity <= person.acceptableIntensity * 0.9
            || exercise.intensity <= person.acceptableIntensity * 1.1;
    }

}
