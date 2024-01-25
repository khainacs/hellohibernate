package org.example.Util;

import org.example.Entites.Classes;
import org.example.Entites.Student;
import org.example.Service.ClassesDao;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ClassesDaoTest {
    private static ClassesDao classesDao = new ClassesDao();
    private static List<Classes> classes = new ArrayList<>();

    @BeforeAll
    public static void init(){
        Student student1 = new Student(1L, "John Doe", new Date(), "A101", "Spring", null, null);
        Student student2 = new Student(2L, "Jane Smith", new Date(), "B202", "Fall", null, null);
        Student student3 = new Student(3L, "Bob Johnson", new Date(), "C303", "Summer", null, null);
        Student student4 = new Student(4L, "Alice Brown", new Date(), "D404", "Winter", null, null);
        Student student5 = new Student(5L, "Charlie Wilson", new Date(), "E505", "Spring", null, null);
        Student student6 = new Student(6L, "Eva Davis", new Date(), "F606", "Fall", null, null);
        Student student7 = new Student(7L, "Frank White", new Date(), "G707", "Summer", null, null);
        Student student8 = new Student(8L, "Grace Miller", new Date(), "H808", "Winter", null, null);
        Student student9 = new Student(9L, "Henry Taylor", new Date(), "I909", "Spring", null, null);
        Student student10 = new Student(10L, "Ivy Martin", new Date(), "J1010", "Fall", null, null);

        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);

        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(student4);
        students2.add(student5);
        students2.add(student6);

        ArrayList<Student> students3 = new ArrayList<>();
        students3.add(student7);
        students3.add(student8);
        students3.add(student9);
        students3.add(student10);

        Classes class1 = new Classes(1L, "Math101", "Floor1", new Date(), new Time(System.currentTimeMillis()), students1);
        Classes class2 = new Classes(2L, "History202", "Floor2", new Date(), new Time(System.currentTimeMillis()), students2);
        Classes class3 = new Classes(3L, "Physics303", "Floor3", new Date(), new Time(System.currentTimeMillis()),  students3);

        classes.add(class1);
        classes.add(class2);
        classes.add(class3);
    }

    @Test
    public void saveTest(){
        for (Classes i: classes) {
            boolean answer = classesDao.save(i);
            Assert.assertEquals(true, answer);
        }
    }

    private static Classes classes1;
    @Test
    void getById() {
//        for (Classes i: classes) {
//            Classes classes1 = (Classes) classesDao.getById(i.getId());
//            Assert.assertEquals(i.getId(), classes1.getId());
//        }

        classes1 = classesDao.getById(1L);
        System.out.println(classes1.getName());
    }

    @Test
    void test(){
        System.out.println(classes1.getId());
        System.out.println(classes1.getName());
    }

    @Test
    void getAll() {
        Assert.assertFalse(classesDao.getAll("from Classes").isEmpty());
    }


    @Test
    void delete() {
        for (Classes i: classes) {
            boolean answer = classesDao.delete(i);
            Assert.assertEquals(true, answer);
        }
    }

}