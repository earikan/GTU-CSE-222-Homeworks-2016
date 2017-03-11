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
public class Quiz extends Assignment {

    /**
     * Quiz sinifinin constructor'İ
     *
     * @param assignmentName String tipinde degisken
     * @param deadline Calendar tipinde degisken
     * @param lateDeadline Calendar tipinde degisken
     */
    public Quiz(String assignmentName, Calendar deadline, Calendar lateDeadline) {
        super(assignmentName, deadline, lateDeadline);
    }

    /**
     * Quiz class'inin getter'i
     *
     * @return deadline
     */
    public Calendar getDeadline() {
        return deadline;
    }

    /**
     * Quiz class'inin getter'i
     *
     * @return lateDeadline
     */
    public Calendar getLateDeadline() {
        return lateDeadline;
    }

    /**
     * Quiz class'inin getter'i
     *
     * @return assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * Quiz class'inin setter'i
     *
     * @param deadline Calendar tipinde degisken
     */
    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }

    /**
     * Quiz class'inin setter'i
     *
     * @param lateDeadline Calendar tipinde degisken
     */
    public void setLateDeadline(Calendar lateDeadline) {
        this.lateDeadline = lateDeadline;
    }

    /**
     * Quiz class'inin setter'i
     *
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

}
