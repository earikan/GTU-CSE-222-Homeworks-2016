/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author eda
 */
public class GroupProject extends Assignment {

    /**
     * GroupProject class'inin construtor'u
     *
     * @param assignmentName String tipinde degisken
     * @param deadline Calendar tipinde degisken
     * @param lateDeadline Calendar tipinde degisken
     */
    public GroupProject(String assignmentName, Calendar deadline, Calendar lateDeadline) {
        super(assignmentName, deadline, lateDeadline);
    }

    /**
     * GroupProject class'inin getter'i
     *
     * @return deadline
     */
    public Calendar getDeadline() {
        return deadline;
    }

    /**
     * GroupProject class'inin getter'i
     *
     * @return lateDeadline
     */
    public Calendar getLateDeadline() {
        return lateDeadline;
    }

    /**
     * GroupProject class'inin getter'i
     *
     * @return assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * GroupProject class'inin setter'i
     *
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * GroupProject class'inin getter'i
     *
     * @return sdf
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * GroupProject class'inin setter'i
     *
     * @param sdf
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

}
