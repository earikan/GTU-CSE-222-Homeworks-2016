/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.User.date;
import java.util.Calendar;

/**
 *
 * @author eda
 */
public class Tutor extends Student {

    /**
     * Tutor class constructor'İ
     *
     * @param userID
     * @param userName
     */
    public Tutor(int userID, String userName) {
        super(userID, userName);
    }

    /**
     * tutorlar tutor olmadiklari derse enroll olabilir
     *
     * @param course enroll olacagi ders
     * @return boolean
     */
    @Override
    public boolean enrollCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (!isInStudentList(course)) {
                        if (isTutor(course)) {
                            java.lang.System.out.println("You can't enroll  this course. You are tutor.");
                            return false;
                        } else {
                            if (!isOldCourse(course)) {
                                course.studentList.add(this);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't enroll  this course. This course closed.");
                                return false;
                            }
                        }
                    } else {
                        java.lang.System.out.println("You can't enroll  this course. You are student at this course.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't enroll  this course. This course doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't enroll this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;

    }

    /**
     * tutor tutor olmadigi dersten cikabilir
     *
     * @param course unenroll olacagi ders
     * @return boolean
     */
    @Override
    public boolean unenrollCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInCourseList(course)) {
                    if (isInStudentList(course)) {
                        if (!isTutor(course)) {
                            if (!isOldCourse(course)) {
                                course.studentList.remove(this);
                                return true;
                            } else {
                                java.lang.System.out.println("You can't unenroll  this course. This course closed.");
                                return false;
                            }
                        } else {
                            java.lang.System.out.println("You can't unenroll  this course. You are tutor.");
                            return false;
                        }
                    } else {
                        java.lang.System.out.println("You can't unenroll  this course. You are not student at this course.");
                        return false;
                    }
                } else {
                    java.lang.System.out.println("You can't unenroll  this course. This course doesn't exist in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't unenroll this course. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * tutor bir dersin documentlerini listeyebilir
     *
     * @param course
     */
    @Override
    public void listDocumentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInStudentList(course)) {
                    if (isTutor(course)) {

                        for (int i = 0; i < course.documentList.size(); ++i) {

                            java.lang.System.out.print(course.documentList.get(i));

                        }
                    } else {
                        java.lang.System.out.println("You can't list documents of this course. You are not tutor at this course.");
                    }
                } else {
                    java.lang.System.out.println("You can't list documents of this course. You are not student at this course.");
                }
            } else {
                java.lang.System.out.println("You can't list documents of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list documents of this course. You are not user.");
        }
    }

    /**
     * tutor bir dersteki assignmentlari gorebilir
     *
     * @param course
     */
    @Override
    public void listAssignmentsInCourse(Course course) {

        if (isUserInSystem(this)) {
            if (isCourseInCourseList(course)) {
                if (isInStudentList(course)) {
                    if (isTutor(course)) {

                        for (int i = 0; i < course.assignmentList.size(); ++i) {

                            java.lang.System.out.print(course.assignmentList.get(i));

                        }
                    } else {
                        java.lang.System.out.println("You can't list documents of  this course. You are not tutor at this course.");
                    }
                } else {
                    java.lang.System.out.println("You can't list assignment of  this course. You are not student at this course.");
                }

            } else {
                java.lang.System.out.println("You can't list assignment of this course. This course doesn't exist in the list.");
            }
        } else {
            java.lang.System.out.println("You can't list assignment of this course. You are not user.");
        }
    }

    /**
     * tutor eski courslari listeyebilir
     */
    public void listOldCourses() {

        for (int i = 0; i < MoodleSystem.courseList.size(); ++i) {

            if (MoodleSystem.courseList.get(i).courseYear.get(Calendar.YEAR) <= date.get(Calendar.YEAR)) {

                java.lang.System.out.print(MoodleSystem.courseList.get(i));
            }

        }

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
     * girilen user sisteme kayitli mi kontrol ediliyor
     *
     * @param user
     * @return boolean
     */
    private boolean isUserInSystem(User user) {

        return MoodleSystem.userList.indexOf(user) != -1;

    }

    /**
     * girilen ogrenci o dersin studentListine kayitli mi kontrol ediliyor
     *
     * @param course
     * @return boolean
     */
    private boolean isInStudentList(Course course) {

        return course.studentList.indexOf(this) != -1;

    }

    /**
     * girilen ogrenci o dersin tutoru mu kontrol ediliyor
     *
     * @param course
     * @return
     */
    private boolean isTutor(Course course) {

        if (this instanceof Tutor) {

            return course.studentList.indexOf(this) != -1;

        }
        return false;

    }

    /**
     * girilen course eski mi kontrol ediliyor
     *
     * @param course
     * @return
     */
    private boolean isOldCourse(Course course) {

        return course.courseYear.get(Calendar.YEAR) < date.get(Calendar.YEAR);

    }

}
