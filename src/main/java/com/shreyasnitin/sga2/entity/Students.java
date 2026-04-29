package com.shreyasnitin.sga2.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_name;
    private String student_gender;
    private int student_age;
    private String student_email;

    @ManyToMany
    @JoinTable(
        name="Student_and_Courses",
        joinColumns=@JoinColumn(name="student_id"),
        inverseJoinColumns=@JoinColumn(name="course_id")
    )
    private List<Courses> courses;

    public Long getStudent_id(){
        return student_id;
    }
    public String getStudent_name(){
        return student_name;
    }
    public String getStudent_gender(){
        return student_gender;
    }
    public int getStudent_age(){
        return student_age;
    }
    public String getStudent_email(){
        return student_email;
    }
    public void setStudent_id(Long id){
        this.student_id=id;
    }
    public void setStudent_name(String name){
        this.student_name=name;
    }
    public void setStudent_gender(String gender){
        this.student_gender=gender;
    }
    public void setStudent_age(int age){
        this.student_age=age;
    }
    public void setStudent_email(String email){
        this.student_email=email;
    }
    public List<Courses> getCourses(){
        return courses;
    }
    public void setCourses(List<Courses> courses){
        this.courses=courses;
    }

}
