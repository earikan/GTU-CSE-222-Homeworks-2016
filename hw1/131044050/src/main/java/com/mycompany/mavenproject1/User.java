/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author eda
 */
public interface User {

    /**
     * sisteme user ekleme fonksiyonu
     * @return boolean
     */
    public boolean LoginSystem();

    /**
     * bir tarih belirledim, bu tarihten onceki dersler old course olarak
     * sayiliyor
     */
    public final Calendar date = new GregorianCalendar(2015, 1, 1);

    /**
     * userID getter
     *
     * @return user id
     */
    public int getUserID();

    /**
     * userName getter
     *
     * @return user name
     */
    public String getUserName();

    /**
     * userID setter
     *
     * @param userID user id
     */
    public void setUserID(int userID);

    /**
     * userNmae sette
     *
     * @param userName user name
     */
    public void setUserName(String userName);

};
