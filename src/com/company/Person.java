package com.company;

public class Person {
    public String name; //we needed a name to sort them out
    public Exercise preferredExercise;
    public double acceptableIntensity;
    public Program currentProgram;

    public Person(String name, Exercise preferredExercise, double acceptableIntensity, Program currentProgram) {
        this.name = name;
        this.preferredExercise = preferredExercise;
        this.acceptableIntensity = acceptableIntensity;
        this.currentProgram = currentProgram;
    }

    public boolean acceptableProgram(Program program){
        return program.intensityLevel <= this.acceptableIntensity * 0.9
                || program.intensityLevel <= this.acceptableIntensity * 1.1;

    }
    public static void selectPreferred(Program[] programs){

    }
}
