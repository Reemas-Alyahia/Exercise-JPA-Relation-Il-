package com.example.jpa121.Controller;


import com.example.jpa121.ApiResponse.ApiResponse;
import com.example.jpa121.Model.Course;
import com.example.jpa121.Model.Teacher;
import com.example.jpa121.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id,@RequestBody @Valid Course course){
        courseService.addNewCourse(teacher_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
     courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
      courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }


}
