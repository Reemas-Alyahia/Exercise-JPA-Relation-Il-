package com.example.jpa121.Service;

import com.example.jpa121.ApiResponse.ApiException;
import com.example.jpa121.Model.Course;
import com.example.jpa121.Model.Teacher;
import com.example.jpa121.Repository.CourseRepository;
import com.example.jpa121.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final TeacherRepository teacherRepository;

    public List<Course>getAllCourse(){
        return courseRepository.findAll();
    }

    public void addNewCourse(Integer teacher_id,Course course){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        if(teacher==null){
            throw new ApiException("Teacher cannot found ");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }
   public void updateCourse(Integer id,Course course){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("Course cannot found");
        }
        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);
}

public void deleteCourse(Integer id){
    Course course=courseRepository.findCourseById(id);
    if(course==null){
        throw new ApiException("Course cannot found");
    }
    courseRepository.delete(course);
}




}
