package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExerciseManagerTest {


    @Test
    public void test3_1_checkProgramPerson() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        ArrayList<Exercise> exercises2 = new ArrayList<>();
        ArrayList<Exercise> exercises3 = new ArrayList<>();
        ArrayList<Exercise> exercises4 = new ArrayList<>();
        Exercise strengthTest = new StrengthExercise("test", 5,40,2,80,5,"");
        exercises2.add(strengthTest);
        Exercise flexibilityTest = new FlexibilityExercise("Test",3,3,3,80,"");
        exercises3.add(flexibilityTest);
        Exercise enduranceTest = new EnduranceExercise("test", 5,40,2,80, "");
        exercises4.add(enduranceTest);

        Exercise treePoseEyesClosed = new BalanceExercise("Tree pose eyes closed", 10,6,3,12,"");
        Exercise balanceStarEyesClosed = new BalanceExercise("Balance star eyes closed",10,3,2,80,"");
        Exercise warriorEyesClosed = new BalanceExercise("Warrior eyes closed", 15,5,3,45,"");
        Exercise skaterHops = new BalanceExercise("Skater hops with reach", 15,15,3,80,"");
        exercises.add(treePoseEyesClosed);
        exercises.add(balanceStarEyesClosed);
        exercises.add(warriorEyesClosed);
        exercises.add(skaterHops);

        Program programTestIntensityBalance = new Program(exercises, "IntensityBalance");//used for testing the BalanceExercises and to see if there is nothing wrong with it being passed to the function
        Program programTestStrength = new Program(exercises2,"strength");//used for testing the StrengthExercises and to see if there is nothing wrong with it being passed to the function
        Program programTestFlexibility = new Program(exercises3, "Flexibility");//used for testing the FlexibilityExercises and to see if there is nothing wrong with it being passed to the function
        Program programTestEndurance = new Program(exercises4,"Endurance");//used for testing the EnduranceExercises and to see if there is nothing wrong with it being passed to the function

        Person testPerson1 = new Person("Testperson1",ExerciseType.BALANCE, 80, programTestIntensityBalance);//used for testing correct cases. intensity and exercisetype are correct
        Person testPerson2 = new Person("Testperson1",ExerciseType.STRENGTH, 80, programTestIntensityBalance);//used for testing correct cases. intensity and exercisetype are correct
        Person testPerson3 = new Person("Testperson1",ExerciseType.FLEXIBILITY, 80, programTestIntensityBalance);//used for testing correct cases. intensity and exercisetype are correct
        Person testPerson4 = new Person("Testperson1",ExerciseType.ENDURANCE, 80, programTestIntensityBalance);//used for testing correct cases. intensity and exercisetype are correct
        Person testPerson5 = new Person("Testperson1",ExerciseType.BALANCE, 0, programTestIntensityBalance);//used for testing wrong intensity levels
        Person testPerson6 = new Person("Testperson1",ExerciseType.STRENGTH, 0, programTestIntensityBalance);//used for testing wrong intensity levels
        Person testPerson7 = new Person("Testperson1",ExerciseType.FLEXIBILITY, 0, programTestIntensityBalance);//used for testing wrong intensity levels
        Person testPerson8 = new Person("Testperson1",ExerciseType.ENDURANCE, 0, programTestIntensityBalance);//used for testing wrong intensity levels

//      below is the outcome strings from intensity and balance
        String whatHappens = ExerciseManager.checkProgramPerson(testPerson1, programTestIntensityBalance); // balance with intensity correct tested against balance only program
        String whatHappens2 = ExerciseManager.checkProgramPerson(testPerson2, programTestIntensityBalance); //strengt with intensity correct tested against balance only program
        String whatHappens3 = ExerciseManager.checkProgramPerson(testPerson3, programTestIntensityBalance); //flexibility with intensity correct tested against balance only program
        String whatHappens4 = ExerciseManager.checkProgramPerson(testPerson4, programTestIntensityBalance); //endurance with intensity correct tested against balance only program
        String whatHappens5 = ExerciseManager.checkProgramPerson(testPerson5, programTestIntensityBalance); // balance with intensity false tested against balance only program
        //strength outcomes comes here
        String whatHappens6 = ExerciseManager.checkProgramPerson(testPerson2, programTestStrength);//strength with intensity correct tested against strenght only program
        String whatHappens7 = ExerciseManager.checkProgramPerson(testPerson6, programTestStrength);//strength with intensity wrong tested against strenght only program
        String whatHappens8 = ExerciseManager.checkProgramPerson(testPerson1, programTestStrength);//balance with intensity correct tested against strenght only program
        //flexibility tests come here
        String whatHappens9 = ExerciseManager.checkProgramPerson(testPerson3, programTestFlexibility);//Flexibility with intensity correct, tested against flexibility only program
        String whatHappens10 = ExerciseManager.checkProgramPerson(testPerson7, programTestFlexibility);//Flexibility with intensity wrong, tested against flexibility only
        String whatHappens11 = ExerciseManager.checkProgramPerson(testPerson1, programTestFlexibility);//Balance with intensity correct tested against flexibility only program
        //endurance tests come here
        String whatHappens12 = ExerciseManager.checkProgramPerson(testPerson4, programTestEndurance); //Endurance with intensity correct tested against endurance only program
        String whatHappens13 = ExerciseManager.checkProgramPerson(testPerson8, programTestEndurance); //Endurance with intensity wrong tested agianst endurance only program
        String whatHappens14 = ExerciseManager.checkProgramPerson(testPerson1, programTestEndurance); //Balance with intensity correct tested against endruance only program

        String expectedValue= "The program you have chosen is great for Testperson1"; //this is the String provided when a program is accepted and is good for the person

        //balance and intensity are being tested below
        assertTrue(whatHappens.equalsIgnoreCase(expectedValue)); //checking with 4 balance when he prefers balance, and with intensity to correct level
        assertFalse(whatHappens2.equalsIgnoreCase(expectedValue)); //checking with 4 balanceExercises when he needs strength to be true
        assertFalse(whatHappens3.equalsIgnoreCase(expectedValue)); //checking with 4 balanceExercises when he needs felxibility to be true
        assertFalse(whatHappens4.equalsIgnoreCase(expectedValue)); //checking with 4 balanceExercises when he needs endurance to be true
        assertFalse(whatHappens5.equalsIgnoreCase(expectedValue)); //checking with 4 balanceExercises when the person needs balance to be true with wrong intensity settings
        //strength and intensity is tested below
        assertTrue(whatHappens6.equalsIgnoreCase(expectedValue)); //checking with 1 strengthexercise where the person needs strength and the intensity correct
        assertFalse(whatHappens7.equalsIgnoreCase(expectedValue)); //cheking with 1 strengthexercise where the person needs strength and wrong intensity settings
        assertFalse(whatHappens8.equalsIgnoreCase(expectedValue)); //checking with 1 strenghtexercise where the person needs Balance and intensity correct
        //flexibility and intensity is tested below
        assertTrue(whatHappens9.equalsIgnoreCase(expectedValue));// checking with 1 flexibility eercise where the person needs flexibility and the intensity set correct.
        assertFalse(whatHappens10.equalsIgnoreCase(expectedValue));//cheking with 1 flexibility where the person needs flexibility and wrong intensity settings
        assertFalse(whatHappens11.equalsIgnoreCase(expectedValue));// checking with 1 flexibility exercise where the person needs strength and correct intensity set
        //Endurance and intensity is tested below
        assertTrue(whatHappens12.equalsIgnoreCase(expectedValue));// checking with 1 enduranceExercise where the person needs endurance and the intensity set correct
        assertFalse(whatHappens13.equalsIgnoreCase(expectedValue));// checking with 1 enduranceExercise where the person needs endurance and the intensity set wrong
        assertFalse(whatHappens14.equalsIgnoreCase(expectedValue));// checking with 1 enduranceExercise where the person needs strength and the intensity set correct

    }
    @Test
    public void test3_2_buildProgram(){
        ArrayList<Exercise> exercisesToBePassed = new ArrayList<>();
        Exercise test = new StrengthExercise("testExercise", 50,1,1,50,3,"none");
        assertTrue(ExerciseManager.buildProgram(exercisesToBePassed, "test").name.equalsIgnoreCase("test"));
        //asserting that when we send the exercises into this function that it builds a new program called test
    }
    @Test
    public void test3_3_recomendProgram(){



        // here comes code that will be rejected by the program.
        ArrayList<Program> arrayToBeTested = new ArrayList<>();
        ArrayList<Exercise> exercises = new ArrayList<>();

        Exercise balance1 = new BalanceExercise("testBalance", 3,3,3,50,"none");
        exercises.add(balance1);
        Program balanceProgram = new Program(exercises, "testProgramRejected");
        arrayToBeTested.add(balanceProgram);
        Person testPerson = new Person("Erna Solberg", ExerciseType.ENDURANCE, 22, balanceProgram);

        String whatHappens = ExerciseManager.recommendProgram(testPerson, arrayToBeTested);
        String whatShouldHappen = "We are sorry, but this persons preferences does not match any of our programs";

        //here comes code that gets accepted by the program
        ArrayList<Program> arrayTobeTested2 = new ArrayList<>();
        ArrayList<Exercise> exercises2 = new ArrayList<>();

        Exercise enduranceExercise = new EnduranceExercise("testEndurance", 3,3,50,22,"none");
        exercises2.add(enduranceExercise);
        Program enduranceProgram = new Program(exercises2, "enduranceTest");
        arrayTobeTested2.add(enduranceProgram);

        String whatHappens2 = ExerciseManager.recommendProgram(testPerson, arrayTobeTested2);
        String whatShouldHappen2 = "We think enduranceTest will be a great choice for Erna Solberg";

        //here is the asserts
        assertTrue(whatHappens.equalsIgnoreCase(whatShouldHappen));
        assertTrue(whatHappens2.equalsIgnoreCase(whatShouldHappen2));


    }
}
