/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Calendar;
import java.util.Objects;

/**
 * 
 * @author eda
 */
public class Student implements User {

    private int userID;
    private String userName;

    /**
     * Student class'inin constructor'i
     *
     * @param userID int tipinde degisken
     * @param userName Sring tipinde degisken
     */
    public Student(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    /**
     * Student class'inin getter'i
     *
     * @return kullanici id'si
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Student class'inin getter'i
     *
     * @return kullanici adi
     */
    @Override
    public String getUserName() {
        return userName;
    }

    /**
     * Student class'nin setter'i
     *
     * @param userID int tipinde kullanici id'si
     */
    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Student class'inin setter'i
     *
     * @param userName string tipinde kullanici adi
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * sisteme kayit fonksiyonu
     *
     * @return
     */
    @Override
    public boolean LoginSystem() {
        try {
            int control = 0;

            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {

                if (MoodleSystem.userList.get(i).getUserID() == this.getUserID()) {

                    control = 1;
                }
            }
            if (control == 0) {
                MoodleSystem.userList.add(this);
                return true;
            } else {
                java.lang.System.out.println("You can't login the system. This user already exist in the system.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * yeni course'larin listelenmesi 
     * ogrenciler eski tarihli dersleri goremezler
     */
    public void listCourses() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.courseList.size(); ++i) {
                if (MoodleSystem.courseList.get(i).courseYear.get(Calendar.YEAR) > date.get(Calendar.YEAR)) {
                    java.lang.System.out.print(MoodleSystem.courseList.get(i));
                }

            }
        } else {
            java.lang.System.out.println("You can't list courses. You are not user.");

        }
    }

    /**
     * ogrencinin derse kayit fonksiyonu
     *
     * @param course kayit olmak istedigi dersin ismi
     * @return boolean
     */
    public boolean enrollCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (!isInStudentList(course)) {

                        course.studentList.add(this);
                        return true;

                    } else {
                        java.lang.System.out.println("You can't enroll this course. You are already exist in the list.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't enroll this course. This courses doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't enroll this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     *ogrencinin dersten cikmasi
     * @param course cikmak istenen dersin ismi
     * @return boolean
     */
    public boolean unenrollCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInStudentList(course)) {

                        course.studentList.remove(this);
                        return true;

                    } else {
                        java.lang.System.out.println("You can't unenroll  this course. You are doesn't exist in the list.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't enroll this course. This courses doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't unenroll this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;

    }

    /**
     * bir course'taki dokumanlari listeleme fonksiyonu
     * @param course dokumanlari listelenmek isteyen course'un ismi
     */
    public void listDocumentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInStudentList(course)) {
                    for (int i = 0; i < course.documentList.size(); ++i) {

                        java.lang.System.out.print(course.documentList.get(i));

                    }
                } else {
                    java.lang.System.out.println("You can't  list documents of  this course. You are doesn't exist in the student list.");

                }
            } else {
                java.lang.System.out.println("You can't list documents of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list documents of this course. You are not user.");
        }

    }

    /**
     * bir course'taki hocanin verdigi tum assignmentlarin listelenmesi
     * @param course assignment listelenmek isteyen course'un ismi
     */
    public void listAssignmentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInStudentList(course)) {
                    for (int i = 0; i < course.assignmentList.size(); ++i) {

                        java.lang.System.out.print(course.assignmentList.get(i));

                    }
                } else {
                    java.lang.System.out.println("You can't  list assignment of  this course. You are doesn't exist in the student list.");
                }

            } else {
                java.lang.System.out.println("You can't list assignment of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list assignment of this course. You are not user.");
        }

    }

    /**
     * ogrenci bir ders bir assignment upload edebiliyor
     * @param course upload edilecek dersin ismi
     * @param assignment teacher'in verdigi assignment
     * @param upAssignment ogrencinin yapmak istedi upload
     * @return boolean
     */
    public boolean uploadAssignment(Course course, Assignment assignment, UploadAssignment upAssignment) {
        try {
            int control;
            control = MoodleSystem.courseList.indexOf(course);

            if (control == -1) {
                java.lang.System.out.println("You can't upload to this course assignment. This course doesn't exist in the list.");
            } else {
                if (isUserInSystem(this)) {
                    for (int i = 0; i < course.studentList.size(); ++i) {

                        if (this.equals(course.studentList.get(i))) {
                            for (int j = 0; j < course.assignmentList.size(); ++j) {
                                if (assignment.equals(course.assignmentList.get(j))) {
                                    if (upAssignment.submissionDate.before(assignment.lateDeadline)) {
                                        assignment.submissionStudentList.add(this);

                                        return true;
                                    } else {
                                        java.lang.System.out.println("Submission has ended.");
                                        return false;
                                    }
                                }
                            }

                            if (control != 1) {
                                java.lang.System.out.println("This assignment doesn't exist.");
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * aranan course courseListte var mi kontrol ediliyor
     * @param course
     * @return boolean
     */
    private boolean isCourseInCourseList(Course course) {
        try {
            return MoodleSystem.courseList.indexOf(course) != -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * aranan user sistemde var mi kontrol ediliyor
     * @param user
     * @return boolean
     */
    private boolean isUserInSystem(User user) {
        try {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {

                if (MoodleSystem.userList.get(i).getUserID() == user.getUserID()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * girilen ogrenci o kursa kayitli mi kontrol ediliyor
     * @param course
     * @return boolean
     */
    private boolean isInStudentList(Course course) {
        try {
            return course.studentList.indexOf(this) != -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Student class'i equal fonksiyonu
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    /**
     * student class'i toString fonksiyonu
     * @return 
     */
    @Override
    public String toString() {
        return ("User ID: " + userID + " " + "User Name:" + userName + "\n");
    }

}
