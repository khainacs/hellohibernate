package org.example.service.impl;

import org.example.entites.Student;
import org.example.service.StudentService;

public class StudentImplService extends AbtractBaseService<Student> implements StudentService<Student> {
    @Override
    public String getNumberOfParents(Student entity) {
        return null;
    }
}
