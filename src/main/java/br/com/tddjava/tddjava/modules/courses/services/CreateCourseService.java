package br.com.tddjava.tddjava.modules.courses.services;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.ICourseRepository;

public class CreateCourseService {

    private ICourseRepository repository;
    public CreateCourseService(ICourseRepository repository){
        this.repository = repository;
    }

    public Course execute(Course course){
        Course existedCourse = this.repository.findByName(course.getName());
        if(existedCourse != null){
            throw new Error("O curso já existe!");
        }
        return repository.save(course);
    }
}
