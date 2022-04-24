package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("courseService")
public class CourseServiceImp implements CourseService{

  List<Course> list;
  public CourseServiceImp() {

    list = new ArrayList<>();
    list.add(new Course(1,"Java Course","Full tutorial"));
    list.add(new Course(2,"Python","some modules"));
    list.add(new Course(3,"C++","Full tutorial"));
  }
  @Override
  public List<Course> getCourses() {
    return list;
  }

  @Override
  public Course getCourse(long courseId) {
    for(int i=0;i<list.size();i++) {
      if(list.get(i).getId() == courseId)
        return list.get(i);
    }
    return null;
  }

  @Override
  public Course addCourse(Course course) {
    list.add(course);
    System.out.println("in service");
    System.out.println(course);
    return course;
  }
}
