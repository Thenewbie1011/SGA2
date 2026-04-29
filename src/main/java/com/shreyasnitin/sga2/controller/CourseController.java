package com.shreyasnitin.sga2.controller;
import com.shreyasnitin.sga2.entity.Courses;
import com.shreyasnitin.sga2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    //Read - list all courses
    @GetMapping("/courses")
    public String getAllCourses(Model model){
        model.addAttribute("courses", courseService.findAllCourses());
        return "courseList";
    }
    //Creating a course
    @PostMapping("/courses")
    public String createCourse(@ModelAttribute Courses course){
        courseService.createCourses(course);
        return "redirect:/courses";
    }
    //Creating a new course form
    @GetMapping("/courses/new")
    public String showCreateForm(Model model){
        model.addAttribute("course", new Courses());
        return "addCourse";
    }
    //updating a course
    @PostMapping("/courses/update")
    public String updateCourses(@ModelAttribute Courses course){
        courseService.UpdateCourse(course);
        return "redirect:/courses";
    }
    //showing the form for updating a course
    @GetMapping("/courses/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("course", courseService.getCourseById(id));
        return "updateCourse";
    }
}
