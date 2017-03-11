/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.lang.*;
import java.util.ArrayList;

/**
 *
 * @author eda
 */
public class MoodleSystem {

    protected static ArrayList<Course> courseList = new ArrayList<Course>();
    protected static ArrayList<User> userList = new ArrayList<User>();

    /**
     * MoodleSystem objesi uzerinde sisteme user ekleme fonksiyonu
     *
     * @param user eklenecek user
     * @return boolena
     */
    public boolean addUser(User user) {
        try {
            int control = 0;

            for (int i = 0; i < userList.size(); ++i) {

                if (userList.get(i).getUserID() == user.getUserID()) {

                    control = 1;
                }
            }
            if (control == 0) {
                userList.add(user);
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
     * MoodleSystem class'nin getter'i
     *
     * @return courseList
     */
    public static ArrayList<Course> getCourseList() {
        return courseList;
    }

    /**
     * MoodleSystem class'nin getter'i
     *
     * @return userList
     */
    public static ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * MoodleSystem class'nin setter'i
     *
     * @param courseList
     */
    public static void setCourseList(ArrayList<Course> courseList) {
        MoodleSystem.courseList = courseList;
    }

    /**
     * MoodleSystem class'nin setter'i
     *
     * @param userList
     */
    public static void setUserList(ArrayList<User> userList) {
        MoodleSystem.userList = userList;
    }

};
