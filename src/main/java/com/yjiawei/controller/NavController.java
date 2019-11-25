package com.yjiawei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class NavController {

    @Value("Jarvis")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/badminton-club")
    public String goToBadmintonClub(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "badminton-club";
    }

    @GetMapping("/music-club")
    public String goToMusicClub(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "music-club";
    }
}