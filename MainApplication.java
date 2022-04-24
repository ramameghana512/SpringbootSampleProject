package com.demo.api.catalogue;

import com.demo.api.catalog.client.api.MyControllerApi;
import com.demo.api.catalog.client.model.Course;
import java.util.List;

public class MainApplication {

  public static void main(String[] args) {

    MyControllerApi myControllerApi = new MyControllerApi();


    //For Sample Testing
    try{
      String testing = myControllerApi.sampleUsingGET();
      System.out.println(testing);
    }
    catch (Exception e) {
      System.out.println("Exception occured at invoking sampleUsingGET");
      e.printStackTrace();
    }

    //Getting Course Details by using CourseId
    try{
      String courseId = "1";
      Course course = myControllerApi.getCourseUsingGET(courseId);
      System.out.println(course.toString());
    }
    catch (Exception e) {
      System.out.println("Exception occured at invoking getCourseUsingGET");
      e.printStackTrace();
    }

    //Getting all the Course Details
    try{
      List<Course> courseList = myControllerApi.getCoursesUsingGET();
      for(int i=0;i<courseList.size();i++) {
        System.out.println("course Id" + courseList.get(i).getId());
        System.out.println("course Title" + courseList.get(i).getTitle());
        System.out.println("course Description" + courseList.get(i).getDescription());
        System.out.println("       ");
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured at invoking getCoursesUsingGET");
      e.printStackTrace();
    }

    //Adding Course Details
    try{
      Course c1 = new Course();
      c1.setId((long) 5);
      c1.setDescription("Dropwizard");
      c1.setTitle("Full course");
      Course sample = myControllerApi.addCourseUsingPOST(c1);
      System.out.println(sample.toString());
    }
    catch(Exception e) {
      System.out.println("Exception occured at invoking addCourseUsingPOST");
      e.printStackTrace();
    }
  }



}
