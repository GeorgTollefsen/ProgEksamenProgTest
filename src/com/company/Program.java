package com.company;

import java.util.ArrayList;

public class Program {
    public static ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    public String name; //we needed a name to sort them out
    public int duration;
    public double intensityLevel;
    public static boolean isBalanced;

    public Program(ArrayList<Exercise> exercises, String name) {
        this.exercises = exercises;
        this.name = name;
        sortProgram();
        this.duration = calculateDuration()*2;
        this.intensityLevel = calculateIntensity();
        this.isBalanced = checkBalance();
    }

    //sorts the program in intensity levels
    public static void sortProgram(){

    }

    //calculates the duration of the whole exercise
    public static int calculateDuration(){
        int result = 0;
        for(int i=0; i<exercises.size(); i++){
            result += exercises.get(i).duration;
        }
        return result;
    }

    //Sets the program intensity based on the highest intensity among the exercises in the program
    public static double calculateIntensity(){
        double result = 0;
        for(int i=0; i<exercises.size(); i++){
            if(exercises.get(i).intensity>=result){
                result = exercises.get(i).intensity;
            }
        }
        return result;
    }

    //checks if the program is balanced by turning the flags true, if all flags are true, the program is balanced.
    public static boolean checkBalance(){
        boolean flagStrength = false;
        boolean flagEndurance = false;
        boolean flagBalance = false;
        boolean flagFlexibility = false;
        for(int i=0; i<exercises.size();i++){
            if(exercises.get(i) instanceof StrenghtExercise){
                flagStrength = true;
            }
            if(exercises.get(i) instanceof EnduranceExercise){
                flagEndurance = true;
            }
            if(exercises.get(i) instanceof FlexibilityExercise){
                flagFlexibility = true;
            }
            if(exercises.get(i) instanceof BalanceExercise){
                flagBalance = true;
            }
        }
        if(flagStrength & flagEndurance & flagBalance & flagFlexibility){
            return true;
        }
        else {
            return false;
        }
    }
}
