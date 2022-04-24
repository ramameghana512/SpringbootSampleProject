package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private CourseService courseService;
  List<Course> list = new ArrayList<>();

  @GetMapping("/home")
  public String sample() {
    return "Sample one working!!";
  }

  @GetMapping("/courses")
  public List<Course> getCourses() {

    return courseService.getCourses();
  }

  @GetMapping("/course/{courseId}")
  public Course getCourse(@PathVariable String courseId) {

   return courseService.getCourse(Long.parseLong(courseId));
  }

  @PostMapping("/courses")
  public Course addCourse(@RequestBody Course course) {
    return courseService.addCourse(course);
  }

}
