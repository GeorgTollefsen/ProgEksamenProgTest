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

    public Program generateProgram(Person person, String projectName) {
        ArrayList<Exercise> exercisesForProgram = new ArrayList<>();
        exercisesForProgram.add(findExerciseByType(person, StrenghtExercise.class));
        exercisesForProgram.add(findExerciseByType(person, BalanceExercise.class));
        exercisesForProgram.add(findExerciseByType(person, FlexibilityExercise.class));
        exercisesForProgram.add(findExerciseByType(person, EnduranceExercise.class));
        return new Program(exercisesForProgram, projectName);

    }

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

    public boolean withinIntensityLevelForPerson(Exercise exercise, Person person) {
        return exercise.intensity <= person.acceptableIntensity * 0.9
            || exercise.intensity <= person.acceptableIntensity * 1.1;
    }

}
