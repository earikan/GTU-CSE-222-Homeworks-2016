/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.lang.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author eda
 */
public class Teacher implements User {

    private int userID;
    private String userName;

    protected ArrayList<Course> courseListOfTeacher = new ArrayList<>();

    /**
     * Teacher class'inin constructor'i
     *
     * @param userID int tipinde degisken
     * @param userName String tipinde degisken
     */
    public Teacher(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    /**
     * Teacher class'nin getter'i
     *
     * @return userID
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Teacher class'nin getter'i
     *
     * @return userName
     */
    @Override
    public String getUserName() {
        return userName;
    }

    /**
     * Teacher class'nin getter'i
     *
     * @return courseListOfTeacher
     */
    public ArrayList<Course> getCourseListOfTeacher() {
        return courseListOfTeacher;
    }

    /**
     * Teacher class'nin setter'i
     *
     * @param userID
     */
    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Teacher class'nin setter'i
     *
     * @param userName
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Teacher class'nin setter'i
     *
     * @param courseListOfTeacher
     */
    public void setCourseListOfTeacher(ArrayList<Course> courseListOfTeacher) {
        this.courseListOfTeacher = courseListOfTeacher;
    }

    /**
     * sisteme kayit fonksiyonu
     *
     * @return boolean
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
        }
        return false;
    }

    /**
     * teacher butun course'lari goruntuleyebilir
     */
    public void listCourses() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.courseList.size(); ++i) {

                java.lang.System.out.print(MoodleSystem.courseList.get(i));

            }
        } else {
            java.lang.System.out.println("You can't list a teacher courses. You are not user.");

        }
    }

    /**
     * teacher butun userleri goruntuleyebilir
     */
    public void listAllUsers() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {

                java.lang.System.out.print(MoodleSystem.userList.get(i));

            }
        } else {
            java.lang.System.out.println("You can't list a teacher courses. You are not user.");

        }
    }

    /**
     * teacher bir dersteki studentlari goruntuleyebilir
     *
     * @param course
     */
    public void listUsersInACourse(Course course) {

        if (isUserInSystem(this)) {
            for (int i = 0; i < course.studentList.size(); ++i) {

                java.lang.System.out.print(course.studentList.get(i));

            }
        } else {
            java.lang.System.out.println("You can't list a teacher courses. You are not user.");

        }
    }

    /**
     * bir teacher'in sahip oldugu ders listesi
     */
    public void listTeacherCourses() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < this.courseListOfTeacher.size(); ++i) {

                java.lang.System.out.print(this.courseListOfTeacher.get(i));

            }
        } else {
            java.lang.System.out.println("You can't list a teacher courses. You are not user.");

        }
    }

    /**
     * teacher derse document ekleyebilir
     *
     * @param course document eklenecek ders
     * @param document eklenecek document
     * @return boolean
     */
    public boolean addDocument(Course course, Document document) {

        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (!isOldCourse(course)) {
                            course.documentList.add(document);
                            return true;
                        } else {
                            java.lang.System.out.println("You can't add a document to this course. This course closed.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't add a document to this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't add a document to this course. This course doesn't exist in the list.");

                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add a document to this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * ogretmen sadece kendi dersinin documentlerina erisebilir
     *
     * @param course
     */
    public void listDocumentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInTeacherCourseList(course)) {

                    for (int i = 0; i < course.documentList.size(); ++i) {

                        java.lang.System.out.print(course.documentList.get(i));

                    }
                } else {
                    java.lang.System.out.println("You can't list documents of this course..This courses owner isn't you.");
                }
            } else {
                java.lang.System.out.println("You can't list documents of this course. This course doesn't exist in the course list");
            }
        } else {
            java.lang.System.out.println("You can't list documents of this course. You are not user.");
        }

    }

    /**
     * ogretmen ekledigi documenti silebilir
     *
     * @param course document silecegi ders
     * @param document silinecek document
     * @return boolean
     */
    public boolean removeDocument(Course course, Document document) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (isDocumentInDocumentList(course, document)) {
                            if (!isOldCourse(course)) {
                                int index;
                                index = course.documentList.indexOf(document);
                                course.documentList.remove(index);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't remove document of this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't remove document of this course. Document doesn't exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't remove documents of this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't remove documents of this course. This course doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't remove documents of this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * teacher kendi dersinden ogrenci silebilir
     *
     * @param course ogrenci silecegi ders
     * @param student siliecek ogrenci
     * @return boolean
     */
    public boolean removeUserFromCourse(Course course, Student student) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (isStudentInCourse(course, student)) {
                            if (!isOldCourse(course)) {
                                int index;
                                index = course.studentList.indexOf(student);
                                course.studentList.remove(index);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't remove this user from this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't remove this user from this course. User doesn't exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't remove this user from this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't remove  this user from this course.  This course doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't remove  this user from this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;

    }

    /**
     * teacher bir derse ogrenci ekleyebilir
     *
     * @param course ogrenci eklenecek ders
     * @param student eklenecek ogrenci
     * @return boolean
     */
    public boolean addUserToCourse(Course course, Student student) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (!isStudentInCourse(course, student)) {
                            if (!isOldCourse(course)) {
                                course.studentList.add(student);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't add this user to this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't add this user to this course. User already exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't add this user  to this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't add  this user  to this course. This course doesn't exist in the list. ");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add  this user  to this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;

    }

    /**
     * teacher bir derse assignment ekleyebilir
     *
     * @param course assignment eklenecek ders
     * @param assignment eklenecek assignment
     * @return boolean
     */
    public boolean addAssignmentToCourse(Course course, Assignment assignment) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (!isAssignmentInCourse(course, assignment)) {
                            if (!isOldCourse(course)) {
                                course.assignmentList.add(assignment);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't add a assignment to this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't add a assignment to this course. This assignment already exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't add a assignment to this course. This courses owner isn't you. ");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't add a assignment to this course. This course doesn't exist in the list. ");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add a assignment to this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * ogretmen ekledigi assignmenti silebilir
     *
     * @param course assignment silemk istedigi ders
     * @param assignment silinecek assignment
     * @return
     */
    public boolean removeAssignmentFromCourse(Course course, Assignment assignment) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (isAssignmentInCourse(course, assignment)) {
                            if (!isOldCourse(course)) {
                                course.assignmentList.remove(assignment);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't remove a assignment to this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't remove a assignment to this course. This assignment doesn't exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't remove a assignment to this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't remove a assignment to this course. This course doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't remove a assignment to this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * teacher kendi dersindekii assignmentlari listeleyebilir
     *
     * @param course listelenecek dersin ismi
     */
    public void listAssignmentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInTeacherCourseList(course)) {

                    for (int i = 0; i < course.assignmentList.size(); ++i) {

                        java.lang.System.out.print(course.assignmentList.get(i));

                    }
                } else {
                    java.lang.System.out.println("You can't list assignments of this course. This courses owner isn't you.");
                }
            } else {
                java.lang.System.out.println("You can't list assignments of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list assignments of this course. You are not user.");
        }

    }

    /**
     * teacher bir assignmente upload edilmis dosyalari goruntuleyebilir
     *
     * @param course
     */
    public void listStudentUploadsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInTeacherCourseList(course)) {

                    for (int i = 0; i < course.assignmentList.size(); ++i) {

                        for (int j = 0; j < course.assignmentList.get(i).submissionStudentList.size(); ++j) {
                            java.lang.System.out.print(course.assignmentList.get(i).submissionStudentList.get(j));

                        }
                    }
                } else {
                    java.lang.System.out.println("You can't list uploads of this course. This courses owner isn't you.");
                }
            } else {
                java.lang.System.out.println("You can't list uploads of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list uploads of this course. You are not user.");
        }

    }

    /**
     * teacher eski course'lari listeyebilir
     */
    public void listOldCourses() {
        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.courseList.size(); ++i) {

                if (MoodleSystem.courseList.get(i).courseYear.get(Calendar.YEAR) <= date.get(Calendar.YEAR)) {

                    java.lang.System.out.print(MoodleSystem.courseList.get(i));
                }

            }
        } else {
            java.lang.System.out.println("You can't list uploads of this course. You are not user.");
        }

    }

    /**
     * teacher bir course'a tutor ekleyebilir
     *
     * @param course tutor eklenecek ders
     * @param tutor eklenecek tutor
     * @return boolean
     */
    public boolean addTutorToCourse(Course course, Tutor tutor) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInTeacherCourseList(course)) {
                        if (!isStudentInCourse(course, tutor)) {
                            if (!isTutor(course, tutor)) {
                                if (!isOldCourse(course)) {
                                    course.studentList.add(tutor);
                                    return true;
                                } else {
                                    java.lang.System.out.println("You can't add this user to this course. This course closed.");
                                    return false;
                                }
                            }
                        } else {
                            java.lang.System.out.println("You can't add this user to this course. User already exist in the list.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't add this user  to this course. This courses owner isn't you.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't add  this user  to this course. This course doesn't exist in the list. ");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add  this user  to this course. You are not user.");
                return false;
            }
            return false;
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * teacher kendi dersindeki tutorlari listeyebilir
     *
     * @param course
     */
    public void listTutorInCourse(Course course) {
        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInTeacherCourseList(course)) {

                    for (int i = 0; i < course.studentList.size(); ++i) {

                        if (course.studentList.get(i) instanceof Tutor) {
                            java.lang.System.out.print(course.studentList.get(i));
                        }

                    }
                } else {
                    java.lang.System.out.println("You can't list documents of this course. This courses owner isn't you.");
                }
            } else {
                java.lang.System.out.println("You can't list documents of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list documents of this course. You are not user.");
        }

    }

    /**
     * girilen user sisteme kayitli mi kontrol ediliyor
     *
     * @param user
     * @return boolean
     */
    private boolean isUserInSystem(User user) {

        for (int i = 0; i < MoodleSystem.userList.size(); ++i) {

            if (MoodleSystem.userList.get(i).getUserID() == user.getUserID()) {
                return true;
            }
        }
        return false;
    }

    /**
     * girilen ders courseListte mi kontrol ediliyor
     *
     * @param course
     * @return boolean
     */
    private boolean isCourseInCourseList(Course course) {

        return MoodleSystem.courseList.indexOf(course) != -1;

    }

    /**
     * teacher o kursa sahip mi kontrol ediliyor
     *
     * @param course
     * @return boolean
     */
    private boolean isInTeacherCourseList(Course course) {

        return courseListOfTeacher.indexOf(course) != -1;

    }

    /**
     * o document documentListte var mi kontrol ediliyor
     *
     * @param course
     * @param document
     * @return boolean
     */
    private boolean isDocumentInDocumentList(Course course, Document document) {

        return course.documentList.indexOf(document) != -1;

    }

    /**
     * student o derse kayitli mi kontrol ediliyor
     *
     * @param aCourse
     * @param student
     * @return boolean
     */
    private boolean isStudentInCourse(Course aCourse, Student student) {

        return aCourse.studentList.indexOf(student) != -1;

    }

    /**
     * girilen assignment o derste var mi kontrol ediliyor
     *
     * @param course
     * @param assignment
     * @return boolean
     */
    private boolean isAssignmentInCourse(Course course, Assignment assignment) {

        return course.assignmentList.indexOf(assignment) != -1;

    }

    /**
     * girilen tutor o dersin tutoru mu kontrol ediliyor
     *
     * @param course
     * @param tutor
     * @return boolean
     */
    private boolean isTutor(Course course, Tutor tutor) {

        if (tutor instanceof Tutor) {

            return course.studentList.indexOf(this) != -1;

        }
        return false;

    }

    /**
     * girilne course eski mi kontrol ediliyor
     *
     * @param course
     * @return boolean
     */
    private boolean isOldCourse(Course course) {

        return course.courseYear.get(Calendar.YEAR) < date.get(Calendar.YEAR);

    }

    /**
     * Teacher class'i toString fonksiyonu
     *
     * @return
     */
    @Override
    public String toString() {
        return ("User ID: " + userID + " " + "User Name:" + userName + "\n");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Teacher class'i equal fonksiyonu
     *
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
        final Teacher other = (Teacher) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
  

}
