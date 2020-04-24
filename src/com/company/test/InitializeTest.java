package com.company.test;

import com.company.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InitializeTest {

    /* The BeforeClass is run before the test of each method, in order to execute some preconditions
       necessary for the test. The BeforeClass annotation indicates
       that the static method to which is attached must be executed once and before all tests in the class */

    @BeforeClass
    public static void setUp() {

        Initialize.intitializeExercises();
        Initialize.initializePrograms();
        Initialize.initializePersons();

    }

    @Test
    public void test10_1() {

        assertEquals(Initialize.persons.size(), 8);

    }

    @Test
    public void test10_2() {

        assertEquals(Initialize.programs.size(), 7);

    }

    @Test
    public void test10_3() {

        assertEquals(Initialize.exercises.size(), 49);
    }

    @Test
    public void test10_4() {

        int burpeesIndex = Initialize.searchFunctionExercises("Burpees");
        assertEquals(burpeesIndex, 9);
        Exercise burpees = Initialize.exercises.get(burpeesIndex);
        assertEquals(burpees.getName(), "Burpees");

    }

    @Test
    public void test10_5() {

        int batmanIndex = Initialize.searchFunctionPrograms("The Batman Program");
        assertEquals(batmanIndex, 3);
        Program theBatmanProgram = Initialize.programs.get(batmanIndex);
        assertEquals(theBatmanProgram.getName(), "The Batman Program");
    }
}
