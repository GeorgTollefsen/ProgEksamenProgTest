package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Person selectedPerson;
    public static Program selectedProgram;


    public static void main(String[] args) {
        Initialize.intitializeExercises();
        Initialize.initializePrograms();
        Initialize.initializePersons();
        System.out.println("Good day to you! Check out our awesome menu for home workout");


        callMenu();

    }

    public static void callMenu() {
        while (true) {
            System.out.println("This is our menu:\n 1. Show information about a person.\n 2. See programs and exercises they contain.\n 3. Exercise Manager.\n 4. Show the menu again");

            int selection = scan.nextInt();
            scan.nextLine();
            switch (selection) {
                case 1:
                    listPersons();
                    break;
                case 2:
                    listPrograms();
                    break;
                case 3:
                    exerciseManager();
                    break;
                case 4:
                    callMenu();
                    break;
                default:
                    System.out.println("Wrong input, please try again");
                    callMenu();
                    break;

            }
        }

    }

    public static void exerciseManager() {
        System.out.println("Welcome to the Exercise Manager. These are your options:\n" +
                "1. Check if a program is appropriate for a person\n" +
                "2. Build a new program\n" +
                "3. Recommend a program for a specific person\n" +
                "4. Back to main menu");
        int choiceExerciseManager = Main.scan.nextInt();
        Main.scan.nextLine();
        switch (choiceExerciseManager) {
            case 1:
                System.out.println("Select person");
                for (int i = 0; i < Initialize.persons.size(); i++) {
                    System.out.println(1 + i + ". " + Initialize.persons.get(i).name);
                }
                int choiceCheckProgramPerson = Main.scan.nextInt() - 1;
                Main.scan.nextLine();
                System.out.println("You chose " + Initialize.persons.get(choiceExerciseManager).name);
                System.out.println("Select Program");
                for (int i = 0; i < Initialize.programs.size(); i++) {
                    System.out.println(i + 1 + ". " + Initialize.programs.get(i).name);
                }
                int valgcheckProgramPerson2 = Main.scan.nextInt() - 1;
                System.out.println("You chose " + Initialize.programs.get(valgcheckProgramPerson2).name);
                Main.scan.nextLine();

                System.out.println(ExerciseManager.checkProgramPerson(Initialize.persons.get(choiceCheckProgramPerson), Initialize.programs.get(valgcheckProgramPerson2)));
                System.out.println("Press any key to continue");
                Main.scan.nextLine();
                Main.exerciseManager();
            case 2:
                System.out.println("Welcome to the program builder\n What would you like to call your new program?");
                String name = Main.scan.nextLine();
                System.out.println("Here is a list of the exercises you can add. Enter 99 to quit");
                ArrayList<Exercise> exercisesChosen = new ArrayList<Exercise>();
                for (int i = 0; i < Initialize.exercises.size(); i++) {
                    System.out.println(i + 1 + ". " + Initialize.exercises.get(i).name + ". Intensity: " + Initialize.exercises.get(i).intensity + ". Duration: " + Initialize.exercises.get(i).duration + " min");
                }
                boolean flagBuildProgram = true;
                while (flagBuildProgram) {
                    int choiceBuildProgram = Main.scan.nextInt() - 1;
//                    Main.scan.nextLine();
                    switch (choiceBuildProgram) {
                        case 98:
                            flagBuildProgram = false;
                            break;
                        default:
                            exercisesChosen.add(Initialize.exercises.get(choiceBuildProgram));
                    }
                }
                ExerciseManager.buildProgram(exercisesChosen, name);
            case 3:
                System.out.println("Here we will recommend a program for you. Which person do you want recommendations for?");
                for (int i = 0; i < Initialize.persons.size(); i++) {
                    System.out.println(i + 1 + ". " + Initialize.persons.get(i).name);
                }
                int choiceRecommendProgram = Main.scan.nextInt() - 1;
                Main.scan.nextLine();
                ExerciseManager.recommendProgram(Initialize.persons.get(choiceRecommendProgram));
            case 4:
                Main.callMenu();
            default:
                System.out.println("Wrong answer, try again");
                exerciseManager();

        }
    }

    public static void listPersons() {
        for (int i = 0; i < Initialize.persons.size(); i++) {
            System.out.println((i + 1) + ". " + Initialize.persons.get(i).name);
        }
        System.out.println("Select a person to see information:");
        int choice = scan.nextInt() - 1;
        scan.nextLine();
        selectedPerson = Initialize.persons.get(choice);
        System.out.println("You have selected: " + selectedPerson.name);
        System.out.println("Name: " + selectedPerson.name + "\nPreferred Intensity: " + selectedPerson.acceptableIntensity + "\nPreferred Exercise Type: " + selectedPerson.preferredExerciseType.toString());
        scan.nextLine();
        callMenu();
    }

    public static void listPrograms() {
        for (int i = 0; i < Initialize.programs.size(); i++) {
            System.out.println(i + 1 + ". " + Initialize.programs.get(i).name);
        }
        System.out.println("\nThis is the collections of programs \n");
        int choice = scan.nextInt() - 1;
        scan.nextLine();
        selectedProgram = Initialize.programs.get(choice);
        System.out.println("Name: " + Initialize.programs.get(choice).name + "\nDuration: " + Initialize.programs.get(choice).duration + " min\nBalanced: " + Initialize.programs.get(choice).isBalanced);
        for (int i = 0; i < Initialize.programs.get(choice).exercises.size(); i++) {
            System.out.println("Exercise " + (i + 1) + ". " + Initialize.programs.get(choice).exercises.get(i).name);
        }
        scan.nextLine();
        callMenu();
    }

}