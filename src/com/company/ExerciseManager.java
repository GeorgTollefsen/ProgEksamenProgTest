package com.company;

import java.util.ArrayList;

public class ExerciseManager {
    public static String checkProgramPerson(Person person, Program program) {
        ArrayList<Program> arrayWithOneProgram = new ArrayList<>();
        arrayWithOneProgram.add(program);
        if (person.selectPreferred(arrayWithOneProgram).name.equalsIgnoreCase(program.name)) {
            return "The program you have chosen is great for " + person.name;
        } else {
            return "The program you selected is not suited for " + person.name;
        }

    }

    public static Program buildProgram(ArrayList<Exercise> exercisesChosen, String name) {
        Program selfMadeProgram = new Program(exercisesChosen, name);
        return selfMadeProgram;
    }

    public static String recommendProgram(Person person, ArrayList programs) {

        if (person.selectPreferred(programs).getName().equalsIgnoreCase("null")) {
           return "We are sorry, but this persons preferences does not match any of our programs";
        } else {
            return "We think " + person.selectPreferred(programs).name + " will be a great choice for " + person.name;
        }
    }
}