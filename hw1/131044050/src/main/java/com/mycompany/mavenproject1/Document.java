/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Objects;

/**
 *
 * @author eda
 */
public class Document {

    private String documentsName;

    /**
     * Document class'inin constructor'i
     *
     * @param documentsName string tipinde document adi
     */
    public Document(String documentsName) {
        this.documentsName = documentsName;
    }

    /**
     * Document class'inin setter'i
     *
     * @param documentsName string tipinde document adi
     */
    public void setDocumentsName(String documentsName) {
        this.documentsName = documentsName;
    }

    /**
     * Document class'inin getteri'i
     *
     * @return string tipinde document adi
     */
    public String getDocumentsName() {
        return documentsName;
    }

    /**
     * Document class'inin toString fonksiyonu
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("Documents Name: " + documentsName + "\n");
    }

    /**
     * Document class'inin equal fonksiyonu
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
        final Document other = (Document) obj;
        if (!Objects.equals(this.documentsName, other.documentsName)) {
            return false;
        }
        return true;
    }

}
