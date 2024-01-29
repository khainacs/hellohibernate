package org.example.util;

import org.example.entites.Classes;
import org.example.entites.Student;
import org.example.service.impl.StudentImplService;
import org.junit.Assert;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import  org.junit.jupiter.api.*;

class StudentImplServiceTest {
    private static StudentImplService studentImplService = new StudentImplService();
    private static List<Student> students = new ArrayList<>();
    @BeforeAll
    public static void init(){
        Classes class1 = new Classes(1L, "Math101", "Floor1", new Date(), new Time(System.currentTimeMillis()),  null);
        Classes class2 = new Classes(2L, "History202", "Floor2", new Date(), new Time(System.currentTimeMillis()),  null);
        Classes class3 = new Classes(3L, "Physics303", "Floor3", new Date(), new Time(System.currentTimeMillis()), null);

        Student student1 = new Student(1L, "John Doe", new Date(), "A101", "Spring", class1, null);
        Student student2 = new Student(2L, "Jane Smith", new Date(), "B202", "Fall", class2, null);
        Student student3 = new Student(3L, "Bob Johnson", new Date(), "C303", "Summer", class3, null);
        Student student4 = new Student(4L, "Alice Brown", new Date(), "D404", "Winter", class1, null);
        Student student5 = new Student(5L, "Charlie Wilson", new Date(), "E505", "Spring", class2, null);
        Student student6 = new Student(6L, "Eva Davis", new Date(), "F606", "Fall", class3, null);
        Student student7 = new Student(7L, "Frank White", new Date(), "G707", "Summer", class1, null);
        Student student8 = new Student(8L, "Grace Miller", new Date(), "H808", "Winter", class3, null);
        Student student9 = new Student(9L, "Henry Taylor", new Date(), "I909", "Spring", class2, null);
        Student student10 = new Student(10L, "Ivy Martin", new Date(), "J1010", "Fall", class1, null);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
    }

    @Test
    public void saveTest(){
        for (Student i: students) {
            boolean answer = studentImplService.save(i);
            Assert.assertEquals(true, answer);
        }
    }

    @Test
    void getById() {
        for (Student i: students) {
            Student student = (Student) studentImplService.getById(i.getId());
            Assert.assertEquals(i.getId(), student.getId());
        }
    }

    @Test
    void getAll() {
        Assert.assertFalse(studentImplService.getAll("from student").isEmpty());
    }


    @Test
    void delete() {
        for (Student i: students) {
            boolean answer = studentImplService.delete(i);
            Assert.assertEquals(true, answer);
        }
    }
}