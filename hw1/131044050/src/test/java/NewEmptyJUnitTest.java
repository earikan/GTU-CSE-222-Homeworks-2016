/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.Admin;
import com.mycompany.mavenproject1.Course;
import com.mycompany.mavenproject1.Homework;
import com.mycompany.mavenproject1.Student;
import com.mycompany.mavenproject1.Teacher;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eda
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addUserTest() {

        Admin admin = new Admin(56827, "Senay Fazla");
        admin.LoginSystem();
        Student student = new Student(56582, "Begum Gerin");

        Assert.assertEquals(true, admin.addUser(student));

    }

    @Test
    public void removeUserTest() {

        Admin admin = new Admin(568, "Begum Fazla");
        admin.LoginSystem();
        Student student = new Student(568, "Begum Gerin");

        Assert.assertEquals(true, admin.removeUser(student));

    }

    @Test
    public void removeUserTest2() {

        Admin admin = new Admin(568, "Begum Fazla");
        Student student = new Student(568, "Begum Gerin");

        Assert.assertEquals(true, admin.removeUser(student));

    }

    @Test
    public void removeCourseTest() {

        Admin admin = new Admin(568, "Begum Fazla");
        Teacher teacher = new Teacher(454, "Hasan Arslan");
        Course course = new Course("fizik 101", teacher);
        admin.addCourse(course);

        Assert.assertEquals(true, admin.removeCourse(course));

    }

    @Test
    public void enrollCourseTest2() {

        Admin admin = new Admin(5078, "Begum Fazla");
        admin.LoginSystem();
        Student student = new Student(454, "Macide Uyar");
        student.LoginSystem();
        Teacher teacher = new Teacher(458, "Hasan Arslan");
        Course course = new Course("fizik 101", teacher);
        admin.addCourse(course);

        Assert.assertEquals(true, student.enrollCourse(course));

    }

    @Test
    public void addCourseToTeacherTest() {

        Admin admin = new Admin(567, "Begum Fazla");
        admin.LoginSystem();
        Teacher teacher = new Teacher(454, "Hasan Arslan");
        Course course = new Course("fizik 101", teacher);

        Assert.assertEquals(true, admin.addCourseToTeacher(teacher, course));

    }

    @Test
    public void addAssignmentTest() {

        Admin admin = new Admin(205, "Ahmet Sirin");
        admin.LoginSystem();
        Teacher teacher = new Teacher(100, "Hasan Osman");
        admin.addUser(teacher);
        Course course = new Course("fizik 144", teacher);
        admin.addCourse(course);
        admin.addCourseToTeacher(teacher, course);

        Assert.assertEquals(true, teacher.addAssignmentToCourse(course, new Homework("odev1", new GregorianCalendar(2015, 1, 1), new GregorianCalendar(2015, 1, 8))));

    }

    @Test
    public void unenrollCourseTest() {
        Admin admin = new Admin(552, "Emre Turgut");
        admin.LoginSystem();
        Student student = new Student(464, "Mert San");
        student.LoginSystem();
        Teacher teacher = new Teacher(107, "Hasan Mehmet");
        Course course = new Course("fizik 454", teacher);
        admin.addCourse(course);
        student.enrollCourse(course);

        Assert.assertEquals(true, student.unenrollCourse(course));

    }

}
