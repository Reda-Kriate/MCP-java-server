package org.reda.mcp_server.service;

import jakarta.annotation.PostConstruct;
import org.reda.mcp_server.models.Course;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        courses.add(new Course("MCP","https://www.youtube.com/watch?v=5aS35FFqY18&t=5244s"));
        courses.add(new Course("RAG","https://www.youtube.com/watch?v=45n5ja4jsqY&t=14252s"));
        courses.add(new Course("Prompt Engineering","https://www.youtube.com/watch?v=fssGlao8ndc"));
    }

    @Tool(name = "get_all_courses",description = "get all pr Abdellah Moutaouakkil courses")
    public List<Course> getAllCourses(){
        return courses;
    }

    @Tool(name = "get_course_by_title",description = "get pr Abdellah Moutaouakkil course by title")
    public Course getCourseByTitle(String title){
        return courses.stream().filter(c->c.title().equals(title)).findFirst().orElseThrow();
    }
}
