package ru.main.springapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calc")
    public String doCalculation(@RequestParam("a") int a,
                              @RequestParam("b") int b,
                              @RequestParam("action") String action,
                              Model model) {
        int res;
        String message;

        switch (action) {
            case "add" -> {
                res = a + b;
                action = "+";
            }
            case "sub" -> {
                res = a - b;
                action = "-";
            }
            case "div" -> {
                res = a / b;
                action = "/";
            }
            case "mul" -> {
                res = a * b;
                action = "*";
            }
            default -> res = 0;
        }

        message = makeMessage(a, b, res, action);

        model.addAttribute("message", message);
        return "/calculator/calc";

    }

    public static String makeMessage(Integer a, Integer b, Integer res, String action) {
        return a + " " + action + " " + b + " = " + res;
    }
}
