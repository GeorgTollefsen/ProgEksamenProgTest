package com.company;

import java.util.ArrayList;

public class Person {
    public String name;
    public double acceptableIntensity;
    public Program currentProgram;
    public ExerciseType preferredExerciseType;

    public Person(String name, ExerciseType preferredExerciseType, double acceptableIntensity, Program currentProgram) {
        this.name = name;
        this.acceptableIntensity = acceptableIntensity;
        this.currentProgram = currentProgram;
        this.preferredExerciseType = preferredExerciseType;
    }

    public boolean acceptableProgram(Program program) {
        return program.intensityLevel >= this.acceptableIntensity * 0.9
                && program.intensityLevel <= this.acceptableIntensity * 1.1;

    }

    // All programs will load here and we will see if the program is a match or not
    // It consideres intensity and if the program includes a an exercise the person preferres
    // If the program does not have one such exercise or the intensity is to high/low, you get a false
    public Program selectPreferred(ArrayList<Program> programs) {
        ArrayList<Exercise> dummy = new ArrayList<>();
        Exercise dummyExercise = new StrengthExercise("Null", 0, 0, 0, 0, 0, "Null");
        dummy.add(dummyExercise);
        Program dummyProg = new Program(dummy, "Null");


        for (int i = 0; i < programs.size(); i++) {
            boolean flagIntensity = false;
            Program program = programs.get(i);
            if (acceptableProgram(program)) {
                flagIntensity = true;
            }
            for (int j = 0; j < program.exercises.size(); j++) {
                if (program.exercises.get(j).getType().equals(this.preferredExerciseType) && flagIntensity) {
                    return program;
                }
            }

        }
        return dummyProg;
    }
}
