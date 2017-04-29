package ru.innopolis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String Dashboard(Model model) {

        model.addAttribute("title", "Hello, world!");

        return "dashboard";

    }

}