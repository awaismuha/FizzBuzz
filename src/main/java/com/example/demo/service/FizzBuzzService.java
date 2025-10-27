package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FizzBuzzService {

    @Cacheable(value = "fizzbuzz", key = "T(String).format('%d-%d', #start, #end)")
    public ArrayList<String> FizzBuzz(Integer start, Integer end) {
        ArrayList<String> responseArray = new ArrayList<>();

        try {
            Thread.sleep(100); 
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int numbner = start; numbner <= end; numbner++) {
            String response;
            if (numbner % 3 == 0 && numbner % 5 == 0) {
                response = numbner + ": FizzBuzz";
            } else if (numbner % 3 == 0) {
                response = numbner + ": Fizz";
            } else if (numbner % 5 == 0) {
                response = numbner + ": Buzz";
            } else {
                response = String.valueOf(numbner);
            }
            responseArray.add(response);
        }

        return responseArray;
    }
}
