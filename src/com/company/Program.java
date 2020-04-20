package com.company;

import java.util.ArrayList;

public class Program {
    public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    public String name; //we needed a name to sort them out
    public int duration;
    public double intensityLevel;
    public boolean isBalanced;

    public Program(ArrayList<Exercise> exercises, String name) {
        this.exercises = exercises;
        this.name = name;
        sortProgram();
        this.duration = calculateDuration()*2;
        this.intensityLevel = calculateIntensity();
        this.isBalanced = checkBalance();
        this.sortProgram();
    }

    /* Sorts the exercises based on intensity, where e1 and e2 are values and can be any two exercises
       the first if retruns 0 if e1 and e2 are the same
       the second (else) if returns -1 if e1 is lesser than e2
       and the third if returns 1 if the e1 is larger than e2 */
    public void sortProgram(){
        this.exercises.sort((e1, e2) -> {
            if (e1.intensity == e2.intensity) {
                return 0;
            } else if (e1.intensity < e2.intensity) {
                return -1;
            } else {
                return 1;
            }
        });

    }

    // Calculates the duration of the whole exercise
    public int calculateDuration(){
        int result = 0;
        for(int i=0; i<exercises.size(); i++){
            result += exercises.get(i).duration;
        }
        return result;
    }

    // Sets the program intensity based on the highest intensity among the exercises in the program
    public double calculateIntensity(){
        double result = 0;
        for(int i=0; i<exercises.size(); i++){
            if(exercises.get(i).intensity >= result){
                result = exercises.get(i).intensity;
            }
        }
        return result;
    }

    // Checks if the program is balanced by turning the flags true, if all flags are true, the program is balanced
    public boolean checkBalance(){
        boolean flagStrength = false;
        boolean flagEndurance = false;
        boolean flagBalance = false;
        boolean flagFlexibility = false;
        for (Exercise exercise : exercises) {
            if (exercise instanceof StrengthExercise) {
                flagStrength = true;
            }
            if (exercise instanceof EnduranceExercise) {
                flagEndurance = true;
            }
            if (exercise instanceof FlexibilityExercise) {
                flagFlexibility = true;
            }
            if (exercise instanceof BalanceExercise) {
                flagBalance = true;
            }
        }
        if(flagStrength && flagEndurance && flagBalance && flagFlexibility){
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

}
