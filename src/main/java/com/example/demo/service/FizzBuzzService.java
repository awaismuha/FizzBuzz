package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FizzBuzzService {

    //ToDo: Apply Caching to get the results from this FizzBuzzService --- DONE

    @Cacheable(value = "fizzbuzz", key = "#s + '-' + #e")
    public ArrayList FizzBuzz(int s, int e) {
        ArrayList responseArray = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            String response = "";

            if (i % 3 == 0) {
                response = i + ": Fizz";
            }
            if (i % 5 == 0) {
                response = i + ": Buzz";
            }
            if (i % 3 == 0 && i % 5 == 0) {
                response = i + ": FizzBuzz";
            }
            if (i % 3 != 0 && i % 5 != 0) {
                response = "" + i;
            }
            responseArray.add(response);
        }

        System.out.println("Result Generated for the First Time Only: ");
        System.out.print(responseArray);
        System.out.println("");
        System.out.println("*****************************************");

        return responseArray;

    }

}
