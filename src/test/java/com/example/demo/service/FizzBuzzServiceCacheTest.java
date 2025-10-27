package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceCacheTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    void testCachingEffectivenessAndResultSize() {
        // First call — should compute and cache
        long startTime = System.currentTimeMillis();
        ArrayList<String> firstResult = fizzBuzzService.FizzBuzz(1, 100);
        long firstDuration = System.currentTimeMillis() - startTime;

        // Ensure result is correct
        assertNotNull(firstResult, "Result should not be null");
        assertEquals(100, firstResult.size(), "Should return 100 elements for range 1–100");

        // Second call — should hit cache
        startTime = System.currentTimeMillis();
        ArrayList<String> secondResult = fizzBuzzService.FizzBuzz(1, 100);
        long secondDuration = System.currentTimeMillis() - startTime;

        // Validate caching behavior
        System.out.println("First call: " + firstDuration + "ms, Second call: " + secondDuration + "ms");

        assertTrue(secondDuration < firstDuration / 2,
                "Second call should be significantly faster due to caching");

        // Validate that cached result is identical in content and size
        assertEquals(firstResult.size(), secondResult.size(), "Cached result should have same size");
        assertEquals(firstResult, secondResult, "Cached result content should be identical");
    }

    @Test
    void testCachingForSingleElementRange() {
        ArrayList<String> result = fizzBuzzService.FizzBuzz(5, 5);

        // Assert correctness
        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "Should return exactly one element for range 5–5");
        assertEquals("5: Buzz", result.get(0), "Single element should be '5: Buzz'");
    }
}
