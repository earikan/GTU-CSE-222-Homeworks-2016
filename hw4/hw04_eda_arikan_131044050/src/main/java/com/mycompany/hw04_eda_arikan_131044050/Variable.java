/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw04_eda_arikan_131044050;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author eda
 */
public class Variable {

    protected ArrayList<String> variableName = new ArrayList();
    protected ArrayList<String> registerName = new ArrayList();
    private final int CAPACITY = 9;
    private int size = 0;

    /**
     * Girilen variable register liste ekleniyor
     *
     * @param variable
     * @return String
     */
    public String addVariable(String variable) {

        String temp;
        if (size < CAPACITY) {

            variableName.add(variable);
            temp = "$t" + size;
            registerName.add("$t" + size);
            ++size;
            return temp;

        }
        
        return null;
    }

    /**
     * gecici temp degerleri bu sekilde tutuluyor, daha sonra siliniyorlar
     *
     * @param variable
     * @return String
     */
    public String addTemp(String variable) {

        String temp;
        if (size < CAPACITY) {

            variableName.add(variable);
            temp = "$t" + size;
            registerName.add("$t" + size);
            ++size;
            return temp;

        }
        
        return null;
    }

    /**
     * girilen variable hangi registerda kontrol ediliyor
     *
     * @param variable
     * @return String
     */
    public String getVariableRegister(String variable) { // girilen hangi regde

        for (int i = 0; i < variableName.size(); ++i) {
            if (variableName.get(i).equals(variable)) {

                return registerName.get(i);

            }
        }
        
        return null;
    }

    /**
     * girilen registerda hangi deger var kontrol ediliyor
     *
     * @param variable
     * @return String
     */
    public String getRegister(String variable) { // o regde hangi sayı deger var
        
        for (int i = 0; i < registerName.size(); ++i) {
            if (registerName.get(i).equals(variable)) {

                return variableName.get(i);

            }
        }
        
        return null;

    }

    /**
     * junk register siliniyor
     *
     * @param variable
     */
    public void deleteRegister(String variable) {

        for (int i = 0; i < registerName.size(); ++i) {
            if (registerName.get(i).equals(variable)) {

                variableName.remove(i);
                registerName.remove(i);
                size--;
            }
        }

    }

    /**
     * templer siliniyor
     */
    public void deletebyTemp() {

        for (int i = 0; i < variableName.size(); ++i) {
            if (variableName.get(i).equals("temp")) {

                variableName.remove(i);
                registerName.remove(i);
                size--;
            }
        }

    }

    /**
     * icinde sadece digit tutan registerlar siliniyor
     *
     * @return boolean
     */
    public boolean deleteDigitRegisters() {

        for (int i = 0; i < variableName.size(); ++i) {
            if (isNumeric(variableName.get(i))) {

                variableName.remove(i);
                registerName.remove(i);
                size--;
                return true;
            }
        }

        return false;
    }

    /**
     * girilen string numeric mi kontrol ediliyor
     * @param str
     * @return 
     */
    public boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
