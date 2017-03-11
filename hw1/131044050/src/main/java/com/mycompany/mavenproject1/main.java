/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.lang.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author eda
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MoodleSystem mySystem = new MoodleSystem();
        Admin admin = new Admin(1001, "Ahmet Yildiz");
        mySystem.addUser(admin);
        Admin admin2 = new Admin(1002, "Mehmet Aslan"); //admin admini ekleyebiliyor
        admin.addUser(admin2);
        java.lang.System.out.printf("\nAdmin userlari listeliyor:\n");
        admin.listUsers(); //sisteme iki admin eklendi ve sistemdeki kullanicilar ekrana basildi

        Teacher teacher1 = new Teacher(2101, "Fatih Erdogan Sevilgen");
        admin.addUser(teacher1); //sisteme ogretmen ekleniyor

        Course course1 = new Course("Data Structures and Algorithms", teacher1); //course acilip, ogretmen atandi
        admin.addCourseToTeacher(teacher1, course1);
        admin.addCourse(course1); //course sisteme eklendi

        Teacher teacher2 = new Teacher(2136, "Bengu Sezen");
        admin.addUser(teacher2); //sisteme ogretmen ekleniyor

        Course course2 = new Course("Mathematic"); //course acildi, henuz ogretmen atanmadi
        admin.addCourse(course2); //course sisteme eklendi
        java.lang.System.out.printf("\n%s sistemdeki course'lari listeliyor:\n", teacher2.getUserName());
        teacher2.listCourses();//ogretmen sistemdeki dersleri listeleyebiliyor

        admin.addCourseToTeacher(teacher2, course2);
        java.lang.System.out.printf("\nAdmin %s dersine %s ogretmenini atadi.\n", course2.getCourseName(), teacher2.getUserName());
        java.lang.System.out.printf("\n%s sistemdeki course'lari listeliyor:\n", teacher2.getUserName());
        teacher2.listCourses();

        Teacher teacher3 = new Teacher(6524, "Erkan Zergeroglu");
        admin.addUser(teacher3); //sisteme ogretmen ekleniyor

        Course course3 = new Course("Computer Science", teacher1, new GregorianCalendar(2015, 3, 2));
        Course course4 = new Course("System Programing", teacher3);
        admin.addCourse(course4);
        admin.addCourse(course3); //course sisteme eklendi
        admin.addCourseToTeacher(teacher1, course3);
        admin.addCourseToTeacher(teacher3, course4);

        Student student1 = new Student(3254, "Ayse Sahin");
        Student student2 = new Student(5475, "Esra Karatas");
        Student student3 = new Student(1254, "Zehra Guler");
        Student student4 = new Student(6584, "Ufuk Bulut");
        admin.addUser(student4);
        admin.addUser(student3);//admin user ekleyebiliyor
        student1.LoginSystem(); //kullanici kendisi direkt sisteme uye olabiliyor
        student2.LoginSystem();
        java.lang.System.out.printf("\nAdmin userlari listeliyor:\n");
        admin.listUsers();
        java.lang.System.out.printf("\nAdmin studentlari listeliyor:\n");
        admin.listStudents();
        java.lang.System.out.printf("\nAdmin teacherlari listeliyor:\n");
        admin.listTeachers();

        java.lang.System.out.printf("\n%s sistemdeki course'lari listeliyor:\n", teacher1.getUserName());
        teacher1.listCourses();//ogretmen sistemdeki dersleri listeleyebiliyor

        java.lang.System.out.printf("\n%s sistemdeki -kendi- course'lari listeliyor:\n", teacher1.getUserName());
        teacher1.listTeacherCourses();//ogretmen sistemdeki kendi derslerini listeleyebiliyor

        java.lang.System.out.printf("\nStudent %s sistemdeki -guncel- course'lari listeliyor:\n", student1.getUserName());
        student1.listCourses();

        student1.enrollCourse(course4);
        student2.enrollCourse(course4);
        java.lang.System.out.printf("\n");
        teacher2.addUserToCourse(course4, student3); //burada hata basmasi gerekiyor, fatih hoca sistem dersi vermiyor

        teacher3.addUserToCourse(course4, student3); //erkan hoca sistem dersine ogrenci ekleyebilir

        java.lang.System.out.printf("\n%s %s dersindeki ogrencileri listeliyor:\n", teacher3.getUserName(), course4.getCourseName());
        teacher3.listUsersInACourse(course4);

        Tutor tutor1 = new Tutor(5742, "Cemre Sahin");
        tutor1.LoginSystem();
        teacher3.addTutorToCourse(course4, tutor1); //sistem programlama dersine tutor ekleniyor
        java.lang.System.out.printf("\n%s %s dersindeki tutorlari listeliyor:\n", teacher3.getUserName(), course4.getCourseName());
        teacher3.listTutorInCourse(course4);

        File document1 = new File("Multitasking.txt");
        teacher3.addDocument(course4, document1); // erkan hoca dersine dokuman ekliyor
        Slide document2 = new Slide("Killing Process.ppt");
        teacher3.addDocument(course4, document2); // erkan hoca dersine dokuman ekliyor

        java.lang.System.out.printf("\nOgrenci %s %s dersindeki documentlari listeliyor:\n", student3.getUserName(), course4.getCourseName());
        student3.listDocumentsInCourse(course4);

        teacher3.removeDocument(course4, document1);//erkan hoca dokumani siliyor

        java.lang.System.out.printf("\nOgrenci %s %s dersindeki guncel documentlari listeliyor:\n", student3.getUserName(), course4.getCourseName());
        student3.listDocumentsInCourse(course4);

        GroupProject proje = new GroupProject("HW1", new GregorianCalendar(2016, 1, 06), new GregorianCalendar(2016, 1, 20));
        teacher3.addAssignmentToCourse(course4, proje);

        java.lang.System.out.printf("\nOgrenci %s %s dersindeki assignmentlari listeliyor:\n", student3.getUserName(), course4.getCourseName());
        student3.listAssignmentsInCourse(course4);

        UploadAssignment upAssignment = new UploadAssignment("Ayse_Sahin.zip", new GregorianCalendar(2016, 1, 11));
        student1.uploadAssignment(course4, proje, upAssignment); //orgenciler sisteme projelerini yukluyor
        student2.uploadAssignment(course4, proje, new UploadAssignment("Esra_Karatas.zip", new GregorianCalendar(2016, 1, 18)));
        //alttaki assignment hata verecek cunku ogrenci late deadline'dan sonra odev yuklemeye calisiyor
        java.lang.System.out.printf("\n");
        student3.uploadAssignment(course4, proje, new UploadAssignment("Zehra_Guler.zip", new GregorianCalendar(2016, 2, 21)));

        java.lang.System.out.printf("\n%s %s dersindeki upload edenleri listeliyor:\n", teacher3.getUserName(), course4.getCourseName());
        teacher3.listStudentUploadsInCourse(course4);

        java.lang.System.out.printf("\nTutor %s %s dersindeki documentleri listeliyor:\n", tutor1.getUserName(), course4.getCourseName());
        tutor1.listDocumentsInCourse(course4);

        java.lang.System.out.printf("\n");
        tutor1.listDocumentsInCourse(course1);  //hata basacak cunku tutor1 course1'e ait bir ogreci veya tutor degil

        admin.removeCourse(course4);//admin sistem programlama dersini sildi
        java.lang.System.out.printf("\n");
        teacher3.listDocumentsInCourse(course4);  //erkan hoca o dersin dokumanlari listelemeye calisinca hata alacak

        java.lang.System.out.printf("\nAdmin sistemdeki course'lari listeliyor:\n");
        admin.listCourses();
        java.lang.System.out.printf("\n");
        admin.addUser(new Student(2101, "Gizem Dursun")); // hata alacak cunku ayni userID'ye sahip fatih hoca var

    }

}
