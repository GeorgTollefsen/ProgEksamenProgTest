package com.company.test;

import com.company.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramTest {
    @Test

    public void test8_1() {

        // Unit test for Program class
        ArrayList<Exercise> exercises = new ArrayList<>();
        Program program = new Program( exercises, "Test name");
        assertEquals(program.name, "Test name");
        assertEquals(program.exercises.size(), 0);
    }

    @Test

    public void test8_2(){
        ArrayList<Exercise> exercises = new ArrayList<>();
        Program program = new Program(exercises, "test");
        assertEquals("test", program.getName());
    }
}
