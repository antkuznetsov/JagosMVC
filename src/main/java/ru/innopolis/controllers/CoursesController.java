package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class CoursesController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @RequestMapping("/courses/")
    public String courses(Model model) {

        model.addAttribute("title", "Курсы");

        return "dashboard";

    }
}