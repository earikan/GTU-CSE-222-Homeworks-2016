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
public class UploadAssignment {

    String uploadName;
    Calendar submissionDate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

    /**
     * UploadAssignment class'inin constructor'i
     * @param uploadName
     * @param submissionDate 
     */
    public UploadAssignment(String uploadName, Calendar submissionDate) {
        this.uploadName = uploadName;
        this.submissionDate = submissionDate;
    }

    /**
     *  UploadAssignment class'inin getter'i
     * @return uploadName
     */
    public String getUploadName() {
        return uploadName;
    }

    /**
     * UploadAssignment class'inin getter'i
     * @return submissionDate
     */
    public Calendar getSubmissionDate() {
        return submissionDate;
    }

    /**
     * UploadAssignment class'inin getter'i
     * @return sdf
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * UploadAssignment class'inin setter'i
     * @param uploadName 
     */
    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    /**
     * UploadAssignment class'inin setter'i
     * @param submissionDate 
     */
    public void setSubmissionDate(Calendar submissionDate) {
        this.submissionDate = submissionDate;
    }

    /**
     * UploadAssignment class'inin setter'i
     * @param sdf 
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

  
    
}
