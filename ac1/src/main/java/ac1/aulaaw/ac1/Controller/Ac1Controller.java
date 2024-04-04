package main.java.ac1.aulaaw.ac1.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/students")
public class Ac1Controller {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "João"));
        students.add(new Student(2, "Antonio"));
        students.add(new Student(3, "Marcus"));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @PostMapping("/add")
    public void createStudent(@RequestBody Student student) {
        students.add(student);
        System.out.println("Aluno adicionado: " + student);
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setNome(String name) {
        this.name = name;
    }
}