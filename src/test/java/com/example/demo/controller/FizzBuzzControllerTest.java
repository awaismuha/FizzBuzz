package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(FizzBuzzController.class)
class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService fizzBuzzService;

    private ArrayList<String> mockResponse;

    @BeforeEach
    void setUp() {
        mockResponse = new ArrayList<>(Arrays.asList("1", "2", "3: Fizz"));
    }

    @Test
    void testFizzBuzzEndpoint() throws Exception {
        Mockito.when(fizzBuzzService.FizzBuzz(1, 3)).thenReturn(mockResponse);

        mockMvc.perform(get("/fizzbuzz")
                        .param("start", "1")
                        .param("end", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0]", is("1")))
                .andExpect(jsonPath("$[2]", is("3: Fizz")));
    }

    @Test
    void testFizzBuzzDefaultParams() throws Exception {
        Mockito.when(fizzBuzzService.FizzBuzz(1, 100)).thenReturn(new ArrayList<>(Arrays.asList("1", "2", "3: Fizz")));

        mockMvc.perform(get("/fizzbuzz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2]", is("3: Fizz")));
    }
}
