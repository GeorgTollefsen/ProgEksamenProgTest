package com.company;

import java.util.ArrayList;

public class ExerciseManager {
//    ArrayList<Exercise> exercises;
//
//    public ExerciseManager(ArrayList<Exercise> exercises) {
//        this.exercises = exercises;
//    }

    //acceptableProgram is testing which program is acceptable for a person (3.a)
//    public static boolean acceptableProgam(Person person, Program program) {
//        return person.acceptableProgram(program);
//    }

    //Generates suitable program for given person, including all the exercise types (3.b)
//    public Program generateProgram(Person person, String projectName) {
//        ArrayList<Exercise> exercisesForProgram = new ArrayList<>();
//        exercisesForProgram.add(findExerciseByType(person, StrengthExercise.class));
//        exercisesForProgram.add(findExerciseByType(person, BalanceExercise.class));
//        exercisesForProgram.add(findExerciseByType(person, FlexibilityExercise.class));
//        exercisesForProgram.add(findExerciseByType(person, EnduranceExercise.class));
//        return new Program(exercisesForProgram, projectName);
//
//    }

    // Uses java generic types to find suitable exersise for a given class, isInstance checks for the right class
    // <T extends Exercise> says that the argument Class<T> classType should be a class T that extends Exercise
//    public <T extends Exercise> Exercise findExerciseByType(Person person, Class<T> classType) {
//        Exercise foundExercise = null;
//        for (Exercise exercise : exercises) {
//            if (classType.isInstance(exercise) && withinIntensityLevelForPerson(exercise, person)) {
//                foundExercise = exercise;
//            }
//            if (foundExercise != null && person.preferredExercise == foundExercise) {
//                break;
//            }
//        }
//        if (foundExercise == null) {
//            throw new RuntimeException("Finner ikke passende exercise");
//        }
//
//        return foundExercise;
//    }

    //Checks if the intensity level is +/- 10% for a person
//    public boolean withinIntensityLevelForPerson(Exercise exercise, Person person) {
//        return exercise.intensity <= person.acceptableIntensity * 0.9
//                || exercise.intensity <= person.acceptableIntensity * 1.1;
//    }

    // Denne er ikke ferdig ennå!
//    public static Program recommendProgram(List<Program> programs, Person person) {
//        programs.sort((p1, p2) -> {
//
//            double p1IntensityDifference = p1.intensityLevel - person.acceptableIntensity;
//            double p2IntensityDifference = p2.intensityLevel - person.acceptableIntensity;
//
//
//            int intensityLevelCompare = Double.compare(p1.intensityLevel, p2.intensityLevel);
//            return 0;
//        });
//
//        return programs.get(0);
//    }

    //-------------------------------------------------------------------------------------------------------------
    public static void exerciseManager() {
        System.out.println("Welcome to the Exercise Manager. These are your options:\n" +
                "1. Check if a program is appropriate for a person\n" +
                "2. Build a new program\n" +
                "3. Recommend a program for a specific person\n" +
                "4. Back to main menu");
        int valg = Main.scan.nextInt();
        Main.scan.nextLine();
        switch (valg) {
            case 1:
                checkProgramPerson();
            case 2:
                buildProgram();
            case 3:
                recommendProgram();
            case 4:
                Main.callMenu();
            default:
                System.out.println("Wrong answer, try again");
                exerciseManager();

        }

    }
    public static void checkProgramPerson(){
        System.out.println("Select person");
        for (int i=0; i<Initialize.personer.size(); i++) {
            System.out.println(1+i+". "+Initialize.personer.get(i).name);
        }
        int valg = Main.scan.nextInt()-1;
        Main.scan.nextLine();
        System.out.println("You chose "+Initialize.personer.get(valg).name);
        System.out.println("Select Program");
        for(int i=0; i<Initialize.programs.size(); i++){
            System.out.println(i+1+". "+Initialize.programs.get(i).name);
        }
        int valg2 = Main.scan.nextInt()-1;
        System.out.println("You chose "+Initialize.programs.get(valg2).name);
        Main.scan.nextLine();

        if(Initialize.personer.get(valg).selectPreferred(Initialize.programs).getName().equalsIgnoreCase(Initialize.programs.get(valg2).name)){
            System.out.println("The program you have chosen are great for "+Initialize.personer.get(valg).name);
        } else{
            System.out.println("The program you selected are not suited for "+Initialize.personer.get(valg).name);
        }
        System.out.println("Press any key to continue");
        Main.scan.nextLine();
        exerciseManager();
    }
    public static void buildProgram(){
        System.out.println("Welcome to the program builder\n What would you like to call your new program?");
        String name = Main.scan.nextLine();
        System.out.println("Here is a list of the exercises you can add. Enter 99 to quit");
        ArrayList<Exercise> exercisesChosen = new ArrayList<Exercise>();
        for(int i=0; i<Initialize.exercises.size(); i++){
            System.out.println(i+1+". "+Initialize.exercises.get(i).name+". Intensity: "+Initialize.exercises.get(i).intensity+". Duration: "+Initialize.exercises.get(i).duration+" min");
        }
        boolean flag = true;
        while(flag){
            int valg = Main.scan.nextInt()+1;
            Main.scan.nextLine();
            switch (valg){
                case 100:
                    flag=false;
                    break;
                default:
                    exercisesChosen.add(Initialize.exercises.get(valg));
            }

        }
        Program selfMadeProgram = new Program(exercisesChosen, name);
        Initialize.programs.add(selfMadeProgram);
        exerciseManager();
    }
    public static void recommendProgram(){
        System.out.println("Here we will reccomend a program for you. Which person do you want recomendations for?");
        for(int i =0; i<Initialize.personer.size(); i++){
            System.out.println(i+1+". "+Initialize.personer.get(i).name);
        }
        int valg = Main.scan.nextInt()-1;
        Main.scan.nextLine();
        if(Initialize.personer.get(valg).selectPreferred(Initialize.programs).getName().equalsIgnoreCase("null")){
            System.out.println("We are sorry, but this persons preferences does not match any of our programs");
        } else {
            System.out.println("We think "+Initialize.personer.get(valg).selectPreferred(Initialize.programs).name+" will be a great choice");
        }
        Main.scan.nextLine();
        exerciseManager();
    }
}