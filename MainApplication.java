package com.demo.api.catalog.client.api;

import com.demo.api.catalog.client.model.Course;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {

  public static void main(String[] args) throws IOException {


    Map<String, String> data = new HashMap<String, String>();
    String methodName = "";
    String attributes = "";
    String payload = "";

    for(int i=0;i<args.length;i++) {
      if(args[i].equalsIgnoreCase("-m")) {

        if (i + 1 < args.length)
          methodName = args[i + 1];
        else
          System.out.println("please enter valid methodName");
      }
      else if(args[i].equalsIgnoreCase("-q")) {
        if(i + 1 < args.length) {
          attributes = args[i + 1];
          String[] arrOfStr = attributes.split("=");
          data.put(arrOfStr[0], arrOfStr[1]);
        }
        else
          System.out.println("please enter valid attributes");
      }
      else if(args[i].equalsIgnoreCase("-d")) {
        if(i + 1 < args.length)
          payload = args[i+1];
        else
          System.out.println("please enter valid Payload");
      }
    }

    System.out.println("Method Name");
    System.out.println(methodName);


    if (data.size() > 0) {
      System.out.println("Attributes");
      for (Map.Entry<String, String> me : data.entrySet()) {
        System.out.print(me.getKey() + ":");
        System.out.println(me.getValue());
      }
    } else {
      System.out.println("No Attributes");
    }


    if (payload.length() > 0) {
      System.out.println("Payload");
      System.out.println(payload);
    }
    else
      System.out.println("No Payload");


    System.out.println("        ");
    MyControllerApi myControllerApi = new MyControllerApi();

    //Checking Sample Get Api By executing jar
    if (methodName.equalsIgnoreCase("sampleUsingGET")) {
      try {
        String sample = myControllerApi.sampleUsingGET();
        System.out.println(sample);
      } catch (Exception e) {
        System.out.println("Exception occured at sampleUsingGET");
        e.printStackTrace();
      }
    }

    //Getting Course Details by using CourseId
    if (methodName.equalsIgnoreCase("getCourseUsingGET")) {
      try {
        String courseId = data.get("courseId");
        Course course = myControllerApi.getCourseUsingGET(courseId);
        System.out.println(course.toString());
      } catch (Exception e) {
        System.out.println("Exception occured at invoking getCourseUsingGET");
        e.printStackTrace();
      }
    }

    //Getting all the Course Details
    if (methodName.equalsIgnoreCase("getCoursesUsingGET")) {
      try {
        List<Course> courseList = myControllerApi.getCoursesUsingGET();
        for (int i = 0; i < courseList.size(); i++) {
          System.out.println("course Id    " + courseList.get(i).getId());
          System.out.println("course Title    " + courseList.get(i).getTitle());
          System.out.println("course Description   " + courseList.get(i).getDescription());
          System.out.println("       ");
        }
      } catch (Exception e) {
        System.out.println("Exception occured at invoking getCoursesUsingGET");
        e.printStackTrace();
      }
    }

    //Adding Course Details
    if (methodName.equalsIgnoreCase("addCourseUsingPOST")) {
      try {
        String json = payload;
        Gson gson = new Gson();
        Course c1 = gson.fromJson(json,Course.class);
        Course sample = myControllerApi.addCourseUsingPOST(c1);
        System.out.println(sample.toString());
      } catch (Exception e) {
        System.out.println("Exception occured at invoking addCourseUsingPOST");
        e.printStackTrace();
      }
    }


  }

}
