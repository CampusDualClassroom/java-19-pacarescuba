package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Exercise19Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
    }

    @Test
    @DisplayName("Checks if the created one-dimensional array contains the natural numbers from 1 to 5.")
    void testCreateAndPopulateUnidimensionalArray() {
        int[] unidimensionalArray = Exercise19.createAndPopulateUnidimensionalArray(5);
        assertEquals(1, unidimensionalArray[0]);
        assertEquals(2, unidimensionalArray[1]);
        assertEquals(3, unidimensionalArray[2]);
        assertEquals(4, unidimensionalArray[3]);
        assertEquals(5, unidimensionalArray[4]);
    }

    @Test
    @DisplayName("Checks if the created two-dimensional array contains the natural numbers from 1 to 9.")
    void testCreateAndPopulateBidimensionalArray() {
        int[][] bidimensionalArray = Exercise19.createAndPopulateBidimensionalArray(3, 3);
        assertEquals(1, bidimensionalArray[0][0]);
        assertEquals(2, bidimensionalArray[0][1]);
        assertEquals(3, bidimensionalArray[0][2]);
        assertEquals(4, bidimensionalArray[1][0]);
        assertEquals(5, bidimensionalArray[1][1]);
        assertEquals(6, bidimensionalArray[1][2]);
        assertEquals(7, bidimensionalArray[2][0]);
        assertEquals(8, bidimensionalArray[2][1]);
        assertEquals(9, bidimensionalArray[2][2]);
    }

    @Test
    @DisplayName("Checks if the created three-dimensional array contains the natural numbers from 1 to 9.")
    void testCreateAndPopulateTridimensionalArray() {
        int[][][] tridimensionalArray = Exercise19.createAndPopulateTridimensionalArray(2, 2, 2);
        assertEquals(1, tridimensionalArray[0][0][0]);
        assertEquals(2, tridimensionalArray[0][0][1]);
        assertEquals(3, tridimensionalArray[0][1][0]);
        assertEquals(4, tridimensionalArray[0][1][1]);
        assertEquals(5, tridimensionalArray[1][0][0]);
        assertEquals(6, tridimensionalArray[1][0][1]);
        assertEquals(7, tridimensionalArray[1][1][0]);
        assertEquals(8, tridimensionalArray[1][1][1]);
    }

    @Test
    @DisplayName("Check that the String resulting from a one-dimensional array of 5 elements contains the first 5 natural numbers, each separated by 1 space.")
    void testGetUnidimensionalString() {
        int[] unidimensionalArray = Exercise19.createAndPopulateUnidimensionalArray(5);
        String unidimensionalString = Exercise19.getUnidimensionalString(unidimensionalArray);
        assertEquals("1 2 3 4 5", unidimensionalString);
    }

    @Test
    @DisplayName("Check that the String resulting from a two-dimensional array of 3 elements contains the first 9 natural numbers, each separated by 1 space and every 3 elements by a line break.Verify that the String resulting from a two-dimensional array of 3 elements contains the first 9 natural numbers, each separated by 1 space and every 3 elements by a new line.")
    void testGetBidimensionalString() {
        int[][] bidimensionalArray = Exercise19.createAndPopulateBidimensionalArray(3, 3);
        String bidimensionalString = Exercise19.getBidimensionalString(bidimensionalArray);
        assertEquals("1 2 3\n4 5 6\n7 8 9", bidimensionalString);
    }

    @Test
    @DisplayName("Check that a three-dimensional array flattens correctly. Flattening a three-dimensional matrix means to sum the result of the same position in all layers.")
    void testFlattenTridimensionalArray() {
        int[][][] tridimensionalArray = Exercise19.createAndPopulateTridimensionalArray(3, 3, 3);
        int[][] flatMatrix = Exercise19.flatTridimensionalArray(tridimensionalArray);
        assertEquals(30, flatMatrix[0][0]);
        assertEquals(33, flatMatrix[0][1]);
        assertEquals(36, flatMatrix[0][2]);
        assertEquals(39, flatMatrix[1][0]);
        assertEquals(42, flatMatrix[1][1]);
        assertEquals(45, flatMatrix[1][2]);
        assertEquals(48, flatMatrix[2][0]);
        assertEquals(51, flatMatrix[2][1]);
        assertEquals(54, flatMatrix[2][2]);
    }
}