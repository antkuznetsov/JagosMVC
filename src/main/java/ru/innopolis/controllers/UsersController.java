package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class UsersController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @RequestMapping("/users/")
    public String users(@RequestParam(value="action", required=false) String action,
                        @RequestParam(value="id", required=false) String id, Model model) {

        if ("add".equals(action)) {
            model.addAttribute("title", "Добавить пользователя");
        } else if ("edit".equals(action)) {
            model.addAttribute("title", "Изменить пользователя " + id);
        } else if ("delete".equals(action)) {
            model.addAttribute("title", "Удалить пользователя " + id);
        } else {
            model.addAttribute("title", "Пользователи");
        }

        return "dashboard";

    }
}
