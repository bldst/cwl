package com.Controller;

import com.Mapper.StudentMapper;
import com.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;
    @GetMapping("/getall")
    public List<Student> getStudent(){
        return studentMapper.finAll();
    }
    @GetMapping("/getone")
    public List<Student>getOne(int id){
        return studentMapper.findone(id);
    }
    @PostMapping("/addstudent")
    public int addStudent(Student student){
        return  studentMapper.insert(student);
    }
    @PutMapping("/updata")
    public int updata(Student student){
        return studentMapper.updateById(student);
    }
    @DeleteMapping("/delete")
    public int deleteone(Student student){
        return studentMapper.deleteById(student);
    }



}
