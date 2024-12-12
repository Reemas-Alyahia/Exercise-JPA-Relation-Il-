package com.example.jpa121.Controller;

import com.example.jpa121.ApiResponse.ApiResponse;
import com.example.jpa121.Model.Teacher;
import com.example.jpa121.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.getALLTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
       teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }
    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
      Teacher teacher=  teacherService.getByTeacherId(id);
        return ResponseEntity.status(200).body(teacher);
    }

}
