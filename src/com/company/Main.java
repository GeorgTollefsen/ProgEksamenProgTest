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
        Exercise jumpingJack = new EnduranceExercise("Jumping Jacks", 20, 10, 3, 1, "None");
        Exercise burpees = new EnduranceExercise("Burpees", 20, 10, 3, 1, "None");
        Exercise mountainClimber = new EnduranceExercise("Mountain climber", 20, 10, 3, "None");
        Exercise jumpRope = new EnduranceExercise("Jump rope", 30,0 ,3,1, "Rope");

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
