/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.lang.*;
import java.util.Objects;

/**
 *
 * @author eda
 */
public class Admin implements User {

    private int userID;
    private String userName;

    /**
     * Admin class'inin constructor'i
     *
     * @param userID int tipinde kullanici id'si
     * @param userName string tipinde kullanici adi
     */
    public Admin(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    /**
     * Admin class'inin getter'i
     *
     * @return kullanici id'si
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Admin class'inin getter'i
     *
     * @return kullanici adi
     */
    @Override
    public String getUserName() {
        return userName;
    }

    /**
     * Admin class'nin setter'i
     *
     * @param userID int tipinde kullanici id'si
     */
    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Admin class'inin setter'i
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
            return false;
        }
    }

    /**
     * sisteme admin tarafindan uye ekleme fonksiyonu
     *
     * @param user User tipinde bir degisken
     * @return boolean
     */
    public boolean addUser(User user) {
        try {
            if (isUserInSystem(this)) {
                if (!isUserInSystem(user)) {
                    MoodleSystem.userList.add(user);
                    return true;
                } else {
                    java.lang.System.out.println("You can't add user to this system. This user already exist in the system.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add a user to this system. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * sistemden admin tarafindan uye silme fonksiyonu
     *
     * @param user User tipinde bir degisken
     * @return boolean
     */
    public boolean removeUser(User user) {
        try {
            if (isUserInSystem(this)) {
                if (isUserInSystem(user)) {
                    MoodleSystem.userList.remove(user);
                    return true;
                } else {
                    java.lang.System.out.println("You can't remove user to this system. This user doesn't exist in the system.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't remove a user to this system. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * admin tarafindan sisteme ders ekleme fonksiyonu
     *
     * @param course Course tipinde bir degisken
     * @return boolean
     */
    public boolean addCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (!isCourseInSystem(course)) {
                    MoodleSystem.courseList.add(course);
                    return true;
                } else {
                    java.lang.System.out.println("You can't add this course to this system. This course already exist in the system.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add this course to this system. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * admin tarafindan sistemden ders silme fonksiyonu
     *
     * @param course Course tipinde bir degisken
     * @return boolean
     */
    public boolean removeCourse(Course course) {
        try {
            if (isUserInSystem(this)) {
                if (isCourseInSystem(course)) {
                    MoodleSystem.courseList.remove(course);
                    return true;
                } else {
                    java.lang.System.out.println("You can't add this course to this system. This course already exist in the system.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add this course tothis system. You are not user.");
                return false;
            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * adminin dersleri listelemesini saglayan fonksiyon
     */
    public void listCourses() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.courseList.size(); ++i) {

                java.lang.System.out.print(MoodleSystem.courseList.get(i));

            }
        } else {
            java.lang.System.out.println("You can't add this course to this system. You are not user.");

        }
    }

    /**
     * adminin kullanicilari listelemesini saglayan fonksiyon
     */
    public void listUsers() {

        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {

                java.lang.System.out.print(MoodleSystem.userList.get(i));
            }
        } else {
            java.lang.System.out.println("You can't add this course to this system. You are not user.");

        }

    }

    public void listTeachers() {
        if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {
                if (MoodleSystem.userList.get(i) instanceof Teacher) {
                    java.lang.System.out.print(MoodleSystem.userList.get(i));
                }
            }
        } else {
            java.lang.System.out.println("You can't add this course to this system. You are not user.");

        }

    }
    
    public void listAdmins(){
          if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {
                if (MoodleSystem.userList.get(i) instanceof Admin) {
                    java.lang.System.out.print(MoodleSystem.userList.get(i));
                }
            }
        } else {
            java.lang.System.out.println("You can't add this course to this system. You are not user.");

        }
        
        
    }
    
     public void listStudents(){
          if (isUserInSystem(this)) {
            for (int i = 0; i < MoodleSystem.userList.size(); ++i) {
                if (MoodleSystem.userList.get(i) instanceof Student) {
                    java.lang.System.out.print(MoodleSystem.userList.get(i));
                }
            }
        } else {
            java.lang.System.out.println("You can't add this course to this system. You are not user.");

        }
        
        
    }
    
    

    /**
     * admin bir derse ogretmen atayabiliyor
     *
     * @param teacher Teacher tipinde bir degisken
     * @param course Course tipinde bir degisken
     * @return boolean
     */
    public boolean addCourseToTeacher(Teacher teacher, Course course) {
        try {
            int control;
            course.setCourseTeacher(teacher);
            control = teacher.courseListOfTeacher.indexOf(course);
               
            if (isUserInSystem(this)) {
                if (control == -1) {
                 
                    teacher.courseListOfTeacher.add(course);
                    return true;
                } else {
                    java.lang.System.out.println("You can't add this course to courseList. This course already in the list.");
                    return false;
                }
            } else {
                java.lang.System.out.println("You can't add this course to this system. You are not user.");
                return false;

            }
        } catch (ClassCastException | NullPointerException e) {
            java.lang.System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * kullanici isim ve id'lerinin ekrana basilmasini saglayan fonksiyon
     */
    @Override
    public String toString() {
        return ("User ID: " + userID + " " + "User Name:" + userName + "\n");
    }

    /**
     * parametre olarak girilen kullanici sisteme kayitli mi kontrol ediliyor
     *
     * @param userUser tipinde bir degisken
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
     * parametre olarak girilen course sistemde var mi kontrol ediliyor
     *
     * @param course Course tipinde bir degisken
     * @return boolean
     */
    private boolean isCourseInSystem(Course course) {
        try {
            return MoodleSystem.courseList.indexOf(course) != -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            java.lang.System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Admin sinifi equal fonksiyonu
     *
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
        final Admin other = (Admin) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

}
