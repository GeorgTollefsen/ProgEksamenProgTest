package com.company;

public class StrenghtExercise extends Exercise {
    public int weights;
    public String equipment;

    public StrenghtExercise(String name, int duration, int repetitions, int sets, int intensity, int weights, String equipment) {
        super(name, duration, repetitions, sets, intensity);
        this.weights = weights;
        this.equipment = equipment;
    }
}
