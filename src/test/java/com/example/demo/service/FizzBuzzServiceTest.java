package com.example.demo.service;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzServiceTest {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Test
    void testFizzBuzzRange1to15() {
        ArrayList<String> result = fizzBuzzService.FizzBuzz(1, 15);

        assertEquals(15, result.size(), "Should return 15 elements");

        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("3: Fizz", result.get(2));
        assertEquals("5: Buzz", result.get(4));
        assertEquals("15: FizzBuzz", result.get(14));
    }

    @Test
    void testFizzBuzzOnlyMultiplesOfThree() {
        ArrayList<String> result = fizzBuzzService.FizzBuzz(3, 3);
        assertEquals("3: Fizz", result.get(0));
    }

    @Test
    void testFizzBuzzOnlyMultiplesOfFive() {
        ArrayList<String> result = fizzBuzzService.FizzBuzz(5, 5);
        assertEquals("5: Buzz", result.get(0));
    }

    @Test
    void testFizzBuzzForFizzBuzzCase() {
        ArrayList<String> result = fizzBuzzService.FizzBuzz(15, 15);
        assertEquals("15: FizzBuzz", result.get(0));
    }
}
