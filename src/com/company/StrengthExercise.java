package com.company;

public class StrengthExercise extends Exercise {
    public int weights;
    public String equipment;

    public StrengthExercise(String name, int duration, int repetitions, int sets, int intensity, int weights, String equipment) {
        super(name, duration, repetitions, sets, intensity);
        this.weights = weights;
        this.equipment = equipment;
    }

    @Override
    public ExerciseType getType() {
        return ExerciseType.STRENGTH;
    }
}
