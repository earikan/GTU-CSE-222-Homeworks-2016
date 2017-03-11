/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Calendar;

/**
 *
 * @author eda
 */
public class Homework extends Assignment {

    /**
     * Homework class'inin constructor'i
     *
     * @param assignmentName String tipinde degisken
     * @param deadline Calendar tipinde degisken
     * @param lateDeadline Calendar tipinde degisken
     */
    public Homework(String assignmentName, Calendar deadline, Calendar lateDeadline) {
        super(assignmentName, deadline, lateDeadline);
    }

    /**
     * Homework class'inin getter'i
     *
     * @return deadline
     */
    public Calendar getDeadline() {
        return deadline;
    }

    /**
     * Homework class'inin getter'i
     *
     * @return lateDeadline
     */
    public Calendar getLateDeadline() {
        return lateDeadline;
    }

    /**
     * Homework class'inin getter'i
     *
     * @return assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * Homework class'inin setter'i
     *
     * @param deadline Calender tipinde degisken
     */
    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }

    /**
     * Homework class'inin setter'i
     *
     * @param lateDeadline Calender tipinde degisken
     */
    public void setLateDeadline(Calendar lateDeadline) {
        this.lateDeadline = lateDeadline;
    }

    /**
     * Homework class'inin setter'i
     *
     * @param assignmentName Calender tipinde degisken
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

}
