package com.company;

public class EnduranceExercise extends Exercise {
    public String equipment;

    public EnduranceExercise(String name, int duration, int repetitions, int sets, int intensity, String equipment) {
        super(name, duration, repetitions, sets, intensity);
        this.equipment = equipment;
    }
}
