/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * 
 * @author eda
 */
public class Course {

    private String courseName;
    private Teacher courseTeacher;
    protected ArrayList<Document> documentList = new ArrayList<>();
    protected ArrayList<Assignment> assignmentList = new ArrayList<>();
    protected ArrayList<Student> studentList = new ArrayList<>();
    Calendar courseYear;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

    /**
     * Course class'inin constructoru
     *
     * @param courseName String tipinde course name
     * @param courseTeacher String tipinde course teacher
     * @param courseYear Calendar tipinde course year
     */
    public Course(String courseName, Teacher courseTeacher, Calendar courseYear) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseYear = courseYear;
    }

    /**
     * Course class'inin constructoru eger tarih girilmezse otomatik olarak yeni
     * tarihli ders olarak varsayiliyor
     *
     * @param courseName String tipinde course name
     * @param courseTeacher String tipinde course teacher
     */
    public Course(String courseName, Teacher courseTeacher) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseYear = new GregorianCalendar(2016, 1, 1);
    }

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseTeacher = new Teacher(0, " ");
        this.courseYear = new GregorianCalendar(2016, 1, 1);
    }

    
    
    
    /**
     * Course class'inin course name setteri
     *
     * @param courseName String tipinde course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Course class'inin course teacher setteri
     *
     * @param courseTeacher String tipinde course teacher
     */
    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    /**
     * Course class'inin document list setteri
     *
     * @param documentList document tipinde bir arraylist
     */
    public void setDocumentList(ArrayList<Document> documentList) {
        this.documentList = documentList;
    }

    /**
     * Course class'inin assingment list setter'i
     *
     * @param assignmentList assingment tipinde bir arraylist
     */
    public void setAssignmentList(ArrayList<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    /**
     * Course class'inin courseName getteri
     *
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Course class'inin courseTeacher getteri
     *
     * @return courseTeacher
     */
    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    /**
     * Course class'inin documentList getteri
     *
     * @return documentList
     */
    public ArrayList<Document> getDocumentList() {
        return documentList;
    }

    /**
     * Course class'inin assignmentList getteri
     *
     * @return assignmentList
     */
    public ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    /**
     * Course class'inin studentList setteri
     *
     * @param studentList o course'taki ogrenci listesi
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Course class'inin studentList getteri
     *
     * @return studentList
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * Course class'nin toString fonksiyonu
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("Course Date: " + sdf.format(courseYear.getTime())  +"," + "Course Name:" + this.getCourseName() + ", "
                + " Course Teacher: " + this.courseTeacher.getUserName() + " " + "\n");

    }

    /**
     * Course class'nin equals fonksiyonu
     * @param obj eslenecek obje
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.courseName, other.courseName)) {
            return false;
        }
        if (!Objects.equals(this.courseTeacher, other.courseTeacher)) {
            return false;
        }
        if (!Objects.equals(this.documentList, other.documentList)) {
            return false;
        }
        if (!Objects.equals(this.assignmentList, other.assignmentList)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.courseName);
        hash = 97 * hash + Objects.hashCode(this.courseTeacher);
        hash = 97 * hash + Objects.hashCode(this.documentList);
        hash = 97 * hash + Objects.hashCode(this.assignmentList);
        return hash;
    }

};
