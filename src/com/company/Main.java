package com.company;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Exercise> spinningprogramExercise = new ArrayList<Exercise>();
    public static ArrayList<Person> personer = new ArrayList<>();
    public static Person selectedPerson;
    public static ArrayList<Program> programs = new ArrayList<Program>();

    public static void main(String[] args) {
        System.out.println("Good day to you sir! Check out our awesome menu for home workout");
        Exercise spinning = new EnduranceExercise("Spinning", 20, 1, 1, 3, "Spinning Cycle");

        //Level 1 - Easy Endurance Exercise
        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 20, 10, 3, 1, "None");
        Exercise jumpRope = new EnduranceExercise("Jump rope", 30,30 ,3,1, "Rope");
        Exercise highKnees = new EnduranceExercise("High knees", 30, 30, 3,2, "None");
        Exercise jogInPlace = new EnduranceExercise("Jog in Place", 10,1,3,1,"None");

        //Level 2 - Medium Endurance Exercise
        Exercise squatsJump = new EnduranceExercise("Squats Jump",10,15,3,2,"None");
        Exercise kickBoxing = new EnduranceExercise("Kickboxing",15,15,3,2,"None");
        Exercise lungesWithJump = new EnduranceExercise("Lunges with jump",15,15,3,2,"None");
        Exercise squatsPunches = new EnduranceExercise("Squats with punches", 10, 15,3,2,"None");

        // Level 3 - Hard Endurance Exercise
        Exercise burpees = new EnduranceExercise("Burpees", 20, 20, 3, 3, "None");
        Exercise mountainClimber = new EnduranceExercise("Mountain climber", 10, 10, 3, 3,"None");
        Exercise beerCrawlPushUps = new EnduranceExercise("Bear crawl push ups", 15, 15,3,2,"Yoga mat");
        Exercise jumpToTheSide  = new EnduranceExercise("Jump to the side", 10,15,3,2,"None");


        //Level 1 - Easy Strenght Exercise
        Exercise squats = new StrenghtExercise("Squats", 20, 20,3,1, 0,"None");
        Exercise sitUps = new StrenghtExercise("Sit-ups", 0, 20, 3,1, 0, "None");
        Exercise backExtention = new StrenghtExercise("Back Extention", 0, 20,3,1,0, "None");
        Exercise pushUpsOnKnees = new StrenghtExercise("Push ups on knees",0,10,3,1,0, "none");

        // Level 2 - Medium Strenght Exercise
        Exercise dips = new StrenghtExercise("Dips", 20, 10, 3, 2,0,"Chair");
        Exercise lunges = new StrenghtExercise("Lunges", 10,12,3,2,1,"Water bottles");
        Exercise facePull = new StrenghtExercise("Face Pull", 10, 10,3,2,0,"Rubber band");
        Exercise plank = new StrenghtExercise("Plank with leg to the side", 10,15,3,2,0,"None");

        //Level 3 - Hard Strenght Exercises
        Exercise pistolSquats = new StrenghtExercise("Pistol squats", 20,10,3,3,0,"None");
        Exercise supermann = new StrenghtExercise("Supermann", 20,10,3,3,0,"Woolen sock");
        Exercise pushUps = new StrenghtExercise("Push ups",15,12,3,3,0,"None");
        Exercise boat = new StrenghtExercise("Boat",10,30,3,3,0,"Water bottle");

        //Level 1 - Easy Flexibility Exercises
        //Level 2 - Medium Flexibility Exercises
        //Level 3 - Hard Flexibility Exercises

        //Level 1 - Easy Balance Exercises
        //Level 2 - Hard Balance Exercises
        //Level 3 - Hard Balance Exercises

        spinningprogramExercise.add(spinning);
        spinningprogramExercise.add(spinning);
        spinningprogramExercise.add(spinning);

        Program spinningProgram = new Program(spinningprogramExercise, "Spinning Program");
        programs.add(spinningProgram);

        Person georg = new Person("Georg", spinning, 1.5, spinningProgram);
        Person pernille = new Person("Pernille", spinning, 2, spinningProgram);
        Person mia = new Person("Mia", spinning, 3, spinningProgram);
        Person thea = new Person("Thea", spinning, 1, spinningProgram);
        Person aina = new Person("Aina" ,spinning, 4, spinningProgram);
        Person andrea = new Person("Andrea" ,spinning, 1, spinningProgram);
        Person rick = new Person("Rick" ,spinning, 4, spinningProgram);
        Person david = new Person("David" ,spinning, 1, spinningProgram);


        personer.add(georg);
        personer.add(pernille);
        personer.add(mia);
        personer.add(thea);
        personer.add(aina);
        personer.add(andrea);
        personer.add(david);
        personer.add(rick);

        callMenu();

    }

    public static void callMenu(){
        while(true){
            System.out.println("This is our menu:\n 1. Select person.\n 2. See programs.\n 3. Exercise Manager.\n 4. Show the menu again");

            int selection = scan.nextInt();
            scan.nextLine();
            switch(selection){
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
                    System.out.println("Wrong input please try again");
                    callMenu();
                    break;

            }
        }

    }
    public static void listPersons(){
    for(int i=0; i<personer.size(); i++){
        System.out.println(i+1+". "+personer.get(i).name.toString());
    }
        System.out.println("Velg person for å se informasjon om den enkelte:");
        int valg = scan.nextInt()-1;
        scan.nextLine();
        selectedPerson = personer.get(valg);
        System.out.println("Du har valgt: "+selectedPerson.name.toString());
        scan.nextLine();
    }
    public static void listPrograms(){
        System.out.println("This is the collections of programs");
        for(int i=0; i<programs.size(); i++){
            System.out.println(i+1+". "+programs.get(i).name.toString());
        }
    }
    public static void exerciseManager(){

    }
}
