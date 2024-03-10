package com.example.lab5q1.Controller;
import com.example.lab5q1.Api.ApiResponse;
import com.example.lab5q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/Student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping()
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/addStudents")
    public ApiResponse addStudents(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added");
    }

    @PutMapping("/update/{index}")
    public  ApiResponse updatedStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new  ApiResponse(" Student updated ");
    }

    @DeleteMapping("/delete/{index}")
    public  ApiResponse deletedStudent(@PathVariable int index) {
       students.remove(index);
        return  new  ApiResponse("Student Deleted");
    }

    @GetMapping("/getName/{index}")
    public String getName(@PathVariable int index) {

        return students.get(index).getName();
    }

    @GetMapping("/getage/{index}")
    public String getAge(@PathVariable int index) {

        return students.get(index).getAge();
    }
    @GetMapping("/getdegree/{index}")
    public String getDegree(@PathVariable int index) {

        return students.get(index).getDegree();
    }
    @GetMapping("/getStatus/{index}")
    public boolean getStatus(@PathVariable int index) {
if (students.get(index).getStatus().equalsIgnoreCase("graduated"))
        return true;
else return false;
    }

}
