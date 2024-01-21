package org.example.Util;

import org.example.Entites.Classes;
import org.example.Entites.Student;
import org.junit.Assert;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import  org.junit.jupiter.api.*;

class StudentDaoTest {
    private static StudentDao studentDao = new StudentDao();
    private static List<Student> students = new ArrayList<>();
    @BeforeAll
    public static void init(){
        Classes class1 = new Classes(1L, "Math101", "Floor1", new Date(), new Time(System.currentTimeMillis()), "Math", null);
        Classes class2 = new Classes(2L, "History202", "Floor2", new Date(), new Time(System.currentTimeMillis()), "History", null);
        Classes class3 = new Classes(3L, "Physics303", "Floor3", new Date(), new Time(System.currentTimeMillis()), "Physics", null);
//        Class class4 = new Class(4L, "English404", "Floor4", new Date(), new Time(System.currentTimeMillis()), "English", null);
//        Class class5 = new Class(5L, "Chemistry505", "Floor5", new Date(), new Time(System.currentTimeMillis()), "Chemistry", null);
//        Class class6 = new Class(6L, "Biology606", "Floor6", new Date(), new Time(System.currentTimeMillis()), "Biology", null);
//        Class class7 = new Class(7L, "ComputerScience707", "Floor7", new Date(), new Time(System.currentTimeMillis()), "Computer Science", null);
//        Class class8 = new Class(8L, "Art808", "Floor8", new Date(), new Time(System.currentTimeMillis()), "Art", null);
//        Class class9 = new Class(9L, "Economics909", "Floor9", new Date(), new Time(System.currentTimeMillis()), "Economics", null);
//        Class class10 = new Class(10L, "Psychology1010", "Floor10", new Date(), new Time(System.currentTimeMillis()), "Psychology", null);

        Student student1 = new Student(1L, "John Doe", new Date(), "A101", "Spring", class1);
        Student student2 = new Student(2L, "Jane Smith", new Date(), "B202", "Fall", class2);
        Student student3 = new Student(3L, "Bob Johnson", new Date(), "C303", "Summer", class3);
        Student student4 = new Student(4L, "Alice Brown", new Date(), "D404", "Winter", class1);
        Student student5 = new Student(5L, "Charlie Wilson", new Date(), "E505", "Spring", class2);
        Student student6 = new Student(6L, "Eva Davis", new Date(), "F606", "Fall", class3);
        Student student7 = new Student(7L, "Frank White", new Date(), "G707", "Summer", class1);
        Student student8 = new Student(8L, "Grace Miller", new Date(), "H808", "Winter", class3);
        Student student9 = new Student(9L, "Henry Taylor", new Date(), "I909", "Spring", class2);
        Student student10 = new Student(10L, "Ivy Martin", new Date(), "J1010", "Fall", class1);

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
            boolean answer = studentDao.save(i);
            Assert.assertEquals(true, answer);
        }
    }

    @Test
    void getById() {
        for (Student i: students) {
            Student student = (Student) studentDao.getById(i.getId());
            Assert.assertEquals(i.getId(), student.getId());
        }
    }

    @Test
    void getAll() {
        Assert.assertFalse(studentDao.getAll().isEmpty());
    }


    @Test
    void delete() {
        for (Student i: students) {
            boolean answer = studentDao.delete(i);
            Assert.assertEquals(true, answer);
        }
    }
}