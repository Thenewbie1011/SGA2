package com.shreyasnitin.sga2.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;
    private String course_name;
    private int course_credits;

     @ManyToMany(mappedBy = "courses")
     private List<Students> students;

     public Long getCourse_id(){
        return course_id;
     }
     public String getCourse_name(){
        return course_name;
     }
     public int getCourse_credits(){
        return course_credits;
     }
     public void setCourse_id(Long id){
        this.course_id=id;
     }
     public void setCourse_name(String name){
        this.course_name=name;
     }
     public void setCourse_credits(int credits){
        this.course_credits=credits;
     }
     public List<Students> getStudents(){
        return students;
     }
     public void setStudents(List<Students> students){
        this.students=students;
     }
}
