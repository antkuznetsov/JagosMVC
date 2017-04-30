package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.models.entities.Course;
import ru.innopolis.services.interfaces.CourseService;

import java.util.List;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class CoursesController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses/", method = RequestMethod.GET)
    public ModelAndView courses(@RequestParam(value="action", required=false) String action,
                              @RequestParam(value="id", required=false) String id, Model model) {

        ModelAndView mav = new ModelAndView("pages/courses/list");

        if ("add".equals(action)) {

            model.addAttribute("title", "Добавить курс");
            model.addAttribute("action", "/courses/add/");

            mav = new ModelAndView("pages/courses/add-edit", "command", new Course());

        } else if ("edit".equals(action)) {

            Course course = courseService.getById(Integer.parseInt(id));

            model.addAttribute("title", "Изменить курс");
            model.addAttribute("action", "/courses/edit/");

            mav = new ModelAndView("pages/courses/add-edit", "command", course);

        } else if ("delete".equals(action)) {

            courseService.delete(Integer.parseInt(id));

            mav = new ModelAndView("redirect:/courses/");

        } else {

            List<Course> courses = courseService.getList();
            model.addAttribute("title", "Курсы");
            model.addAttribute("courses", courses);

        }
        return mav;
    }

    @RequestMapping(value="/courses/add/", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("course") Course course){
        courseService.add(course);
        return new ModelAndView("redirect:/courses/");
    }

    @RequestMapping(value="/courses/edit/", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("course") Course course){
        courseService.update(course);
        return new ModelAndView("redirect:/courses/");
    }
}