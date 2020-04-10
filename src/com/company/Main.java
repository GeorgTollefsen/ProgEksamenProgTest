package com.company;

import javax.swing.*;
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
        System.out.println("Good day to you! Check out our awesome menu for home workout");
        Exercise spinning = new EnduranceExercise("Spinning", 20, 1, 1, 3, "Spinning Cycle");

        //Level 1 - Easy Endurance Exercise
        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 10, 20, 3, 10, "None");
        Exercise jumpRope = new EnduranceExercise("Jump rope", 10,30 ,3,30, "Rope");
        Exercise highKnees = new EnduranceExercise("High knees", 10, 30, 3,30, "None");
        Exercise jogInPlace = new EnduranceExercise("Jog in Place", 10,30,3,20,"None");

        //Level 2 - Medium Endurance Exercise
        Exercise squatsJump = new EnduranceExercise("Squats Jump",10,15,3,60,"None");
        Exercise kickBoxing = new EnduranceExercise("Kickboxing",15,15,3,30,"None");
        Exercise lungesWithJump = new EnduranceExercise("Lunges with jump",15,15,3,60,"None");
        Exercise squatsPunches = new EnduranceExercise("Squats with punches", 10, 15,3,40,"None");

        // Level 3 - Hard Endurance Exercise
        Exercise burpees = new EnduranceExercise("Burpees", 15, 30, 4, 100, "None");
        Exercise mountainClimber = new EnduranceExercise("Mountain climber", 10, 30, 3, 90,"None");
        Exercise beerCrawlPushUps = new EnduranceExercise("Bear crawl push ups", 15, 15,3,90,"Yoga mat");
        Exercise jumpToTheSide  = new EnduranceExercise("Jump to the side", 10,15,3,75,"None");


        //Level 1 - Easy Strenght Exercise
        Exercise squats = new StrenghtExercise("Squats", 20, 20,3,90, 0,"None");
        Exercise sitUps = new StrenghtExercise("Sit-ups", 0, 20, 3,20, 0, "None");
        Exercise backExtention = new StrenghtExercise("Back Extention", 0, 20,3,10,0, "None");
        Exercise pushUpsOnKnees = new StrenghtExercise("Push ups on knees",0,10,3,35,0, "none");

        // Level 2 - Medium Strenght Exercise
        Exercise dips = new StrenghtExercise("Dips", 20, 10, 3, 20,0,"Chair");
        Exercise lunges = new StrenghtExercise("Lunges", 10,12,3,80,1,"Water bottles");
        Exercise facePull = new StrenghtExercise("Face Pull", 10, 10,3,60,0,"Rubber band");
        Exercise plank = new StrenghtExercise("Plank with leg to the side", 10,15,3,20,0,"None");

        //Level 3 - Hard Strenght Exercises
        Exercise pistolSquats = new StrenghtExercise("Pistol squats", 20,10,3,30,0,"None");
        Exercise supermann = new StrenghtExercise("Supermann", 20,10,3,55,0,"Woolen sock");
        Exercise pushUps = new StrenghtExercise("Push ups",15,12,3,80,0,"None");
        Exercise boat = new StrenghtExercise("Boat",10,30,3,45,0,"Water bottle");

        //Level 1 - Easy Flexibility Exercises
        Exercise catCow = new FlexibilityExercise("Cat-cow", 10,10,3,10,"None");
        Exercise standingHamstring = new FlexibilityExercise("Standing handstring Stretch", 10,10,3,45,"None");
        Exercise shoulderCircles = new FlexibilityExercise("Shoulder Circles",5,5,2,50,"None");
        Exercise butterflyStretch = new FlexibilityExercise("Butterfly Stretch", 10, 5,2,20,"");

        //Level 2 - Medium Flexibility Exercises
        Exercise piriformisStretch = new FlexibilityExercise("Piriformis Stretch", 10,10,3,35,"None");
        Exercise tricepsStretch = new FlexibilityExercise("Triceps Stretch", 10,10,3,45,"None");
        Exercise spidermanLungs = new FlexibilityExercise("Spiderman lunge with reach",10,10,3,50,"20 sec on each leg");
        Exercise seatedShoulderSqueeze = new FlexibilityExercise("Seated Shoulder Squeeze", 10,5,3,56,"Hold for 20 sec");

        //Level 3 - Hard Flexibility Exercises
        Exercise lowLungsOverArms = new FlexibilityExercise("Low lungs over arms",10,10,3,30,"None");
        Exercise lungeWithSpinalTwist = new FlexibilityExercise("Lunge with spinal twist",10,10,70,3,"");
        Exercise backBridge = new FlexibilityExercise("Back bridge", 10,5,3,75,"Hold for 20 sec");
        Exercise pigeonStretch = new FlexibilityExercise("Piegon stretch", 10,5,2, 36,"Hold 30 sec on each leg");

        //Level 1 - Easy Balance Exercises
        Exercise quadrupedElbowToKnee = new BalanceExercise("Quadruped elbow to knee", 10,10,3,15,"");
        Exercise singelLegBalance = new BalanceExercise("Single leg balance",15,10,3,30,"");
        Exercise warrior = new BalanceExercise("Warrior", 15,5,3,60,"");
        Exercise treePose = new BalanceExercise("Tree pose", 10,6,3,50,"");

        //Level 2 - Medium Balance Exercises
        Exercise balanceStar = new BalanceExercise("Balance star",10,3,2,20,"");
        Exercise treePoseWithArmsUps = new BalanceExercise("Tree pose with arms up",10,5,2,35,"");
        Exercise airborneLunges = new BalanceExercise("Airborne Lunges", 10,10,3,45,"");
        Exercise stepDown = new BalanceExercise("Step down", 15,10,3,65,"Chair");

        //Level 3 - Hard Balance Exercises
        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10,6,3,12,"");
        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed",10,3,2,90,"");
        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15,5,3,45,"");
        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15,15,3,80,"");
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
