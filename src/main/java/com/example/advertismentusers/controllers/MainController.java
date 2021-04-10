package com.example.advertismentusers.controllers;

import com.example.advertismentusers.data.AdvRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("")
    public String getUsers(Model model) {
        var repo = new AdvRepository();

        model.addAttribute("users", repo.getUsers());

        return "index";
    }

    @GetMapping("/details/{id}")
    public String getAdvertisment(@PathVariable int id, Model model) {
        var repo = new AdvRepository();

        model.addAttribute("advertisment", repo.getById(id));

        return "details";
    }
}
