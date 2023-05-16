package ru.main.springapp1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        model.addAttribute("message", "hello " + name + " " + surname);

        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam("name") String name,
                              @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("goodbye " + name + " " + surname);

        return "/first/goodbye";
    }
}
