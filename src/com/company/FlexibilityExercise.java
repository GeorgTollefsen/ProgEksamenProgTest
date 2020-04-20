package com.company;

public class FlexibilityExercise extends Exercise {
    public String requirement;

    public FlexibilityExercise(String name, int duration, int repetitions, int sets, int intensity, String requirement) {
        super(name, duration, repetitions, sets, intensity);
        this.requirement = requirement;
    }

    @Override
    public ExerciseType getType() {
        return ExerciseType.FLEXIBILITY;
    }
}
