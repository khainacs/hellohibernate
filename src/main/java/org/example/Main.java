package org.example;

import org.example.Entites.Classes;
import org.example.Entites.Student;
import org.example.Service.ClassesDao;

public class Main {
    private static ClassesDao classesDao = new ClassesDao();
    private static Student student = new Student();

    public static void main(String[] args) {
        Classes classes = classesDao.getById(3L);
        System.out.println(classes);
    }
}
