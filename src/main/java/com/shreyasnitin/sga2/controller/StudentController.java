package com.shreyasnitin.sga2.controller;
import com.shreyasnitin.sga2.entity.Students;
import com.shreyasnitin.sga2.service.StudentService;
import com.shreyasnitin.sga2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    //Read - list all students
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "studentList";
    }
    //Create student
    @PostMapping("/students")
    public String createStudent(@ModelAttribute Students student){
        studentService.createStudents(student);
        return "redirect:/students";
    }
    //Creating new student form
    @GetMapping("/students/new")
    public String showCreateForm(Model model){
        model.addAttribute("student", new Students());
        model.addAttribute("courses", courseService.findAllCourses());
        return "addStudent";
    }
    //Updating student
    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Students student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    //Creating update student form
    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentsById(id));
        model.addAttribute("courses", courseService.findAllCourses());
        return "updateStudent";
    }
}