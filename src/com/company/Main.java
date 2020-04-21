package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

//    public static ArrayList<Person> personer = new ArrayList<>();
    public static Person selectedPerson;
//    public static ArrayList<Program> programs = new ArrayList<Program>();
    public static Program selectedProgram;
//    public static ArrayList<Exercise> exercises = new ArrayList<>();


    public static void main(String[] args) {
        Initialize.intitializeExercises();
        Initialize.initializePrograms();
        Initialize.initializePersons();
        System.out.println("Good day to you! Check out our awesome menu for home workout");

        callMenu();

    }

    public static void callMenu(){
        while(true){
            System.out.println("This is our menu:\n 1. Show information about a person.\n 2. See programs and exercises they contain.\n 3. Exercise Manager.\n 4. Show the menu again");

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
        int valg = Main.scan.nextInt();
        Main.scan.nextLine();
        switch (valg) {
            case 1:
                ExerciseManager.checkProgramPerson();
            case 2:
                ExerciseManager.buildProgram();
            case 3:
                ExerciseManager.recommendProgram();
            case 4:
                Main.callMenu();
            default:
                System.out.println("Wrong answer, try again");
                exerciseManager();

        }
    }

    public static void listPersons(){
    for(int i=0; i<Initialize.personer.size(); i++){
        System.out.println((i+1) + ". " + Initialize.personer.get(i).name);
    }
        System.out.println("Select a person to see information:");
        int valg = scan.nextInt()-1;
        scan.nextLine();
        selectedPerson = Initialize.personer.get(valg);
        System.out.println("You have selected: " + selectedPerson.name);
        System.out.println("Name: "+selectedPerson.name+"\nPreferred Intensity: "+selectedPerson.acceptableIntensity+"\nPreferred Exercise Type1: "+selectedPerson.preferredExerciseType.toString());
        scan.nextLine();
        callMenu();
    }
    public static void listPrograms(){
        for(int i=0; i<Initialize.programs.size(); i++){
            System.out.println(i+1+". " + Initialize.programs.get(i).name);
        }
        System.out.println("\nThis is the collections of programs \n");
        int valg = scan.nextInt()-1;
        scan.nextLine();
        selectedProgram = Initialize.programs.get(valg);
        System.out.println("Name: "+Initialize.programs.get(valg).name+"\nDuration: "+Initialize.programs.get(valg).duration+" min\nBalanced: "+Initialize.programs.get(valg).isBalanced);
        for (int i=0; i<Initialize.programs.get(valg).exercises.size(); i++){
            System.out.println("Exercise "+(i+1)+". "+Initialize.programs.get(valg).exercises.get(i).name);
        }
        scan.nextLine();
        callMenu();
    }


//    public static void intitializeExercises(){
//        //Level 1 - Easy Endurance Exercise
//        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 10, 20, 3, 10, "None");
//        Exercise jumpRope = new EnduranceExercise("Jump rope", 10,30 ,3,30, "Rope");
//        Exercise highKnees = new EnduranceExercise("High knees", 10, 30, 3,30, "None");
//        Exercise jogInPlace = new EnduranceExercise("Jog in Place", 10,30,3,20,"None");
//
//        //Level 2 - Medium Endurance Exercise
//        Exercise squatsJump = new EnduranceExercise("Squats Jump",10,15,3,60,"None");
//        Exercise kickBoxing = new EnduranceExercise("Kickboxing",15,15,3,30,"None");
//        Exercise lungesWithJump = new EnduranceExercise("Lunges with jump",15,15,3,60,"None");
//        Exercise squatsPunches = new EnduranceExercise("Squats with punches", 10, 15,3,40,"None");
//
//        // Level 3 - Hard Endurance Exercise
//        Exercise burpees = new EnduranceExercise("Burpees", 15, 30, 4, 100, "None");
//        Exercise mountainClimber = new EnduranceExercise("Mountain climber", 10, 30, 3, 90,"None");
//        Exercise beerCrawlPushUps = new EnduranceExercise("Bear crawl push ups", 15, 15,3,90,"Yoga mat");
//        Exercise jumpToTheSide  = new EnduranceExercise("Jump to the side", 10,15,3,75,"None");
//        Exercise spinning = new EnduranceExercise("Spinning", 20, 1, 1, 7, "Spinning Cycle");
//
//        //Level 1 - Easy Strength Exercise
//        Exercise squats = new StrengthExercise("Squats", 20, 20,3,90, 0,"None");
//        Exercise sitUps = new StrengthExercise("Sit-ups", 0, 20, 3,20, 0, "None");
//        Exercise backExtention = new StrengthExercise("Back Extention", 0, 20,3,10,0, "None");
//        Exercise pushUpsOnKnees = new StrengthExercise("Push ups on knees",0,10,3,35,0, "none");
//
//        // Level 2 - Medium Strength Exercise
//        Exercise dips = new StrengthExercise("Dips", 20, 10, 3, 20,0,"Chair");
//        Exercise lunges = new StrengthExercise("Lunges", 10,12,3,80,1,"Water bottles");
//        Exercise facePull = new StrengthExercise("Face Pull", 10, 10,3,60,0,"Rubber band");
//        Exercise plank = new StrengthExercise("Plank with leg to the side", 10,15,3,20,0,"None");
//
//        //Level 3 - Hard Strength Exercises
//        Exercise pistolSquats = new StrengthExercise("Pistol squats", 20,10,3,90,0,"None");
//        Exercise supermann = new StrengthExercise("Supermann", 20,10,3,55,0,"Woolen sock");
//        Exercise pushUps = new StrengthExercise("Push ups",15,12,3,80,0,"None");
//        Exercise boat = new StrengthExercise("Boat",10,30,3,45,0,"Water bottle");
//
//        //Level 1 - Easy Flexibility Exercises
//        Exercise catCow = new FlexibilityExercise("Cat-cow", 10,10,3,10,"None");
//        Exercise standingHamstring = new FlexibilityExercise("Standing hamstring Stretch", 10,10,3,45,"None");
//        Exercise shoulderCircles = new FlexibilityExercise("Shoulder Circles",5,5,2,50,"None");
//        Exercise butterflyStretch = new FlexibilityExercise("Butterfly Stretch", 10, 5,2,20,"");
//
//        //Level 2 - Medium Flexibility Exercises
//        Exercise piriformisStretch = new FlexibilityExercise("Piriformis Stretch", 10,10,3,35,"None");
//        Exercise tricepsStretch = new FlexibilityExercise("Triceps Stretch", 10,10,3,45,"None");
//        Exercise spidermanLungs = new FlexibilityExercise("Spiderman lunge with reach",10,10,3,50,"20 sec on each leg");
//        Exercise seatedShoulderSqueeze = new FlexibilityExercise("Seated Shoulder Squeeze", 10,5,3,56,"Hold for 20 sec");
//
//        //Level 3 - Hard Flexibility Exercises
//        Exercise lowLungsOverArms = new FlexibilityExercise("Low lungs over arms",10,10,3,30,"None");
//        Exercise lungeWithSpinalTwist = new FlexibilityExercise("Lunge with spinal twist",10,10,70,3,"");
//        Exercise backBridge = new FlexibilityExercise("Back bridge", 10,5,3,75,"Hold for 20 sec");
//        Exercise pigeonStretch = new FlexibilityExercise("Piegon stretch", 10,5,2, 36,"Hold 30 sec on each leg");
//
//        //Level 1 - Easy Balance Exercises
//        Exercise quadrupedElbowToKnee = new BalanceExercise("Quadruped elbow to knee", 10,10,3,15,"");
//        Exercise singelLegBalance = new BalanceExercise("Single leg balance",15,10,3,30,"");
//        Exercise warrior = new BalanceExercise("Warrior", 15,5,3,60,"");
//        Exercise treePose = new BalanceExercise("Tree pose", 10,6,3,50,"");
//
//        //Level 2 - Medium Balance Exercises
//        Exercise balanceStar = new BalanceExercise("Balance star",10,3,2,20,"");
//        Exercise treePoseWithArmsUps = new BalanceExercise("Tree pose with arms up",10,5,2,35,"");
//        Exercise airborneLunges = new BalanceExercise("Airborne Lunges", 10,10,3,45,"");
//        Exercise stepDown = new BalanceExercise("Step down", 15,10,3,65,"Chair");
//
//        //Level 3 - Hard Balance Exercises
//        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10,6,3,12,"");
//        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed",10,3,2,90,"");
//        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15,5,3,45,"");
//        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15,15,3,80,"");
//
//        exercises.add(spinning);
//        exercises.add(jumpingJack);
//        exercises.add(jumpRope);
//        exercises.add(highKnees);
//        exercises.add(jogInPlace);
//
//        exercises.add(squatsJump);
//        exercises.add(kickBoxing);
//        exercises.add(lungesWithJump);
//        exercises.add(squatsPunches);
//
//        exercises.add(burpees);
//        exercises.add(mountainClimber);
//        exercises.add(beerCrawlPushUps);
//        exercises.add(jumpToTheSide);
//
//        exercises.add(squats);
//        exercises.add(sitUps);
//        exercises.add(backExtention);
//        exercises.add(pushUpsOnKnees);
//
//        exercises.add(dips);
//        exercises.add(lunges);
//        exercises.add(facePull);
//        exercises.add(plank);
//
//        exercises.add(pistolSquats);
//        exercises.add(supermann);
//        exercises.add(pushUps);
//        exercises.add(boat);
//
//        exercises.add(catCow);
//        exercises.add(standingHamstring);
//        exercises.add(shoulderCircles);
//        exercises.add(butterflyStretch);
//
//        exercises.add(piriformisStretch);
//        exercises.add(tricepsStretch);
//        exercises.add(spidermanLungs);
//        exercises.add(seatedShoulderSqueeze);
//
//        exercises.add(lowLungsOverArms);
//        exercises.add(lungeWithSpinalTwist);
//        exercises.add(backBridge);
//        exercises.add(pigeonStretch);
//
//        exercises.add(quadrupedElbowToKnee);
//        exercises.add(singelLegBalance);
//        exercises.add(warrior);
//        exercises.add(treePose);
//
//        exercises.add(balanceStar);
//        exercises.add(treePoseWithArmsUps);
//        exercises.add(airborneLunges);
//        exercises.add(stepDown);
//
//        exercises.add(treePoseEyesClosed);
//        exercises.add(balanceStarEyesClosed);
//        exercises.add(warriorEyesClosed);
//        exercises.add(skaterHops);
//    }

//    public static void initializePrograms(){
//       //Spinning program
//        ArrayList<Exercise> spinningprogramExercise = new ArrayList<Exercise>();
//        spinningprogramExercise.add(exercises.get(searchFunctionExercises("Spinning")));
//        spinningprogramExercise.add(exercises.get(searchFunctionExercises("Spinning")));
//        spinningprogramExercise.add(exercises.get(searchFunctionExercises("Spinning")));
//        Program spinningProgram = new Program(spinningprogramExercise, "Spinning Program");
//        programs.add(spinningProgram);
//
//        //The Superman Program
//        ArrayList<Exercise> supermanprogramExercise = new ArrayList<Exercise>();
//        supermanprogramExercise.add(exercises.get(searchFunctionExercises("Jumping Jacks")));
//        supermanprogramExercise.add(exercises.get(searchFunctionExercises("Squats")));
//        supermanprogramExercise.add(exercises.get(searchFunctionExercises("Cat-cow")));
//        supermanprogramExercise.add(exercises.get(searchFunctionExercises("Quadruped elbow to knee")));
//        supermanprogramExercise.add(exercises.get(searchFunctionExercises("Plank with leg to the side")));
//        Program supermanProgram = new Program(supermanprogramExercise,"The superman Program");
//        programs.add(supermanProgram);
//
//        //The Thor Program
//        ArrayList<Exercise> thorprogramExercise = new ArrayList<Exercise>();
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Pistol Squats")));
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Mountain Climber")));
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Back bridge")));
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Push ups")));
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Tree pose")));
//        thorprogramExercise.add(exercises.get(searchFunctionExercises("Jump to the side")));
//        Program thorProgram = new Program(thorprogramExercise, "The Thor Program");
//        programs.add(thorProgram);
//
//        //The Batman Program
//        ArrayList<Exercise> batmanprogramExercise = new ArrayList<Exercise>();
//        batmanprogramExercise.add(exercises.get(searchFunctionExercises("Squats Jump")));
//        batmanprogramExercise.add(exercises.get(searchFunctionExercises("Lunges with jump")));
//        batmanprogramExercise.add(exercises.get(searchFunctionExercises("Warrior eyes closed")));
//        batmanprogramExercise.add(exercises.get(searchFunctionExercises("Piriformis Stretch")));
//        batmanprogramExercise.add(exercises.get(searchFunctionExercises("Shoulder Circles")));
//        Program batmanProgram = new Program(batmanprogramExercise,"The Batman Program");
//        programs.add(batmanProgram);
//
//        //The Flash Program - Be fast as Flash
//        ArrayList<Exercise> flashprogramExercise = new ArrayList<Exercise>();
//        flashprogramExercise.add(exercises.get(searchFunctionExercises("High knees")));
//        flashprogramExercise.add(exercises.get(searchFunctionExercises("Jog in Place")));
//        flashprogramExercise.add(exercises.get(searchFunctionExercises("Push ups on knees")));
//        flashprogramExercise.add(exercises.get(searchFunctionExercises("Standing hamstring Stretch")));
//        flashprogramExercise.add(exercises.get(searchFunctionExercises("Step down")));
//        Program flashProgram = new Program(flashprogramExercise,"The Flash Program");
//        programs.add(flashProgram);
//
//        // Be Flexible as Spiderman -
//        ArrayList<Exercise> spidermanprogramExercise = new ArrayList<Exercise>();
//        spidermanprogramExercise.add(exercises.get(searchFunctionExercises("Lunge with spinal twist")));
//        spidermanprogramExercise.add(exercises.get(searchFunctionExercises("Piegon stretch")));
//        spidermanprogramExercise.add(exercises.get(searchFunctionExercises("Skater hops with reach")));
//        spidermanprogramExercise.add(exercises.get(searchFunctionExercises("Sit-ups")));
//        spidermanprogramExercise.add(exercises.get(searchFunctionExercises("Jump rope")));
//        Program spidermanProgram = new Program(spidermanprogramExercise,"The Spiderman Program");
//        programs.add(spidermanProgram);
//
//        //Be a Wonderwoman
//        ArrayList<Exercise> wonderwomanprogramExercise = new ArrayList<Exercise>();
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Tree pose eyes closed")));
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Balance star eyes closed")));
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Lunges")));
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Kickboxing")));
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Low lungs over arms")));
//        wonderwomanprogramExercise.add(exercises.get(searchFunctionExercises("Triceps Stretch")));
//        Program wonderwomanProgram = new Program(wonderwomanprogramExercise, "The Wonder woman Program");
//        programs.add(wonderwomanProgram);
//    }

//    public static void initializePersons(){
//        Person georg = new Person("Georg", exercises.get(searchFunctionExercises("spinning")), 50, programs.get(searchFunctionPrograms("spinning program")));
//        Person pernille = new Person("Pernille", exercises.get(searchFunctionExercises("Spinning")), 70, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person mia = new Person("Mia", exercises.get(searchFunctionExercises("squats")), 95, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person thea = new Person("Thea", exercises.get(searchFunctionExercises("Spinning")), 34, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person aina = new Person("Aina" ,exercises.get(searchFunctionExercises("Spinning")), 66, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person andrea = new Person("Andrea" ,exercises.get(searchFunctionExercises("Spinning")), 71, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person rick = new Person("Rick" ,exercises.get(searchFunctionExercises("Spinning")), 88, programs.get(searchFunctionPrograms("Spinning Program")));
//        Person david = new Person("David" ,exercises.get(searchFunctionExercises("Spinning")), 62, programs.get(searchFunctionPrograms("Spinning Program")));
//
//
//        personer.add(georg);
//        personer.add(pernille);
//        personer.add(mia);
//        personer.add(thea);
//        personer.add(aina);
//        personer.add(andrea);
//        personer.add(david);
//        personer.add(rick);
//    }

//    public static int searchFunctionPrograms(String find){
//        int indexnumber=-1;
//        for(int i=0; i<programs.size(); i++){
//            if(programs.get(i).name.equalsIgnoreCase(find)){
//                indexnumber = i;
//            }
//        }
//        return indexnumber;
//    }
//
//    public static int searchFunctionExercises(String find){
//        int indexnumber=-1;
//        for(int i=0; i<exercises.size(); i++){
//            if(exercises.get(i).name.equalsIgnoreCase(find)){
//                indexnumber = i;
//            }
//        }
//        return indexnumber;
//    }
}
