package com.company;

public class BalanceExercise extends Exercise {
    public String Equipment;

    public BalanceExercise(String name, int duration, int repetitions, int sets, int intensity, String equipment) {
        super(name, duration, repetitions, sets, intensity);
        Equipment = equipment;
    }
}
