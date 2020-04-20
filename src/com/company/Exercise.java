package com.company;

public abstract class Exercise {
    public String name;
    public int duration;
    public int repetitions;
    public int sets;
    public int intensity;

    public Exercise(String name, int duration, int repetitions, int sets, int intensity) {
        this.name = name;
        this.duration = duration;
        this.repetitions = repetitions;
        this.sets = sets;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public abstract ExerciseType getType();
}
