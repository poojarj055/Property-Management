package com.mycompany.property_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mycompany.property_management.dto.CalculateDTO;
import org.springframework.http.ResponseEntity; // Import this
import org.springframework.http.HttpStatus; // Import this

@RestController
@RequestMapping("/api/v1/calculator") // Class-level mapping of URL to the controller
public class CalculatorController {

    @GetMapping("/add") // Method-level mapping of URL to the controller
    // http://localhost:8080/api/v1/calculator/add?num1=5.7&num2=8.6
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num3}")
    public Double subtract(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @PathVariable("num3") Double num3) {
        return num1 - num2 - num3;
    }

    @GetMapping("/multiply/{num1}/{num2}") // Map the values of the URL to path variables
    public Double multiply(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return num1 * num2;
    }

    @PostMapping("/mul") // Map the values of the URL to path variables
    public ResponseEntity<Double> mul(@RequestBody CalculateDTO calculateDTO) {
        Double result = calculateDTO.getNum1() * calculateDTO.getNum2() * calculateDTO.getNum3();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/divide/{num1}/{num2}")
    public Double divide(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
