package org.itstep.api;

import org.itstep.data.Repository;
import org.itstep.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    Repository<Student, Integer> studentRepository;

    public StudentRestController(Repository<Student, Integer> studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getOneStudent(@PathVariable int id) {
        return studentRepository.find(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        Integer id = studentRepository.save(student);
        return studentRepository.find(id);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable int id) {
        studentRepository.delete(studentRepository.find(id));
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
                               consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        studentRepository.update(student);
        return studentRepository.find(id);
    }
}
