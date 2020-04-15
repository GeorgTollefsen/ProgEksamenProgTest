package com.company;

import java.util.ArrayList;

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

    //alle programmer lastes inn her og man ser om et program er bra for en person eller ikke
    public boolean selectPreferred(ArrayList<Program> programs){
        boolean flagIntensity = false;
        boolean flagPreferredExercise = false;
        for(int i=0; i<programs.size(); i++){
            if (programs.get(i).intensityLevel < this.acceptableIntensity *1.1
                    && programs.get(i).intensityLevel>this.acceptableIntensity*0.9){
                flagIntensity = true;
            }
            for (int j =0; j<programs.get(i).exercises.size(); j++){
                if(programs.get(i).exercises.get(j).name.equalsIgnoreCase(this.preferredExercise.name)){
                    flagPreferredExercise = true;
                }
            }
        }
        if (flagIntensity&&flagPreferredExercise){
            return true;
        }
        return false;
    }
}
