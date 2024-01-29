package org.example;

import org.example.entites.Classes;
import org.example.entites.Student;
import org.example.service.impl.ClassesImplService;

public class Main {
    private static ClassesImplService classesImplService = new ClassesImplService();
    private static Student student = new Student();

    public static void main(String[] args) {
        Classes classes = classesImplService.getById(3L);
        System.out.println(classes);
    }
}
