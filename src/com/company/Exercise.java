package com.company;

public class Exercise {
    public String name; //we needed a name to sort them out
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
}
