/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author eda
 */
public class Assignment {

    Calendar deadline;
    Calendar lateDeadline;
    String assignmentName;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
    protected ArrayList<Student> submissionStudentList = new ArrayList<>();

    /**
     * Assignment class'i constructor'i
     *
     * @param assignmentName String tipinde bir degisken
     * @param deadline Calendar tipinde bir degisken
     * @param lateDeadline Calendar tipinde bir degisken
     */
    public Assignment(String assignmentName, Calendar deadline, Calendar lateDeadline) {
        this.deadline = deadline;
        this.lateDeadline = lateDeadline;
        this.assignmentName = assignmentName;
    }

    /**
     * Assignment class'i toSting fonksiyonu
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("Assignment Name: " + assignmentName + " - " + "Deadline: " + sdf.format(deadline.getTime()) + " - " + "Late Deadline: " + sdf.format(lateDeadline.getTime()) + "\n");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Assignment class'i equal fonksiyonu
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
        final Assignment other = (Assignment) obj;
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        if (!Objects.equals(this.lateDeadline, other.lateDeadline)) {
            return false;
        }
        if (!Objects.equals(this.assignmentName, other.assignmentName)) {
            return false;
        }
        return true;
    }

}
