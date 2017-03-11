/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_eda_arikan_131044050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eda
 */
public class recursiveOperations {

    private List list1;
    private List list2;
    private List intersectionList = new ArrayList();
    private List unionList = new ArrayList();

    /**
     * constructor
     */
    public recursiveOperations() {

        list1 = new ArrayList();
        list2 = new ArrayList();

        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(1);
        list1.add(99);
        list1.add(61);
        list1.add(2);

        list2.add(9);
        list2.add(3);
        list2.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(99);
        list2.add(13);
        list2.add(7);

    }

    /**
     * kesisim kumesini bulan fonksiyon wrapperi
     *
     * @return kesisim kumesi listi
     */
    public List intersectionOfList() {
        try {
            intersectionOfLists(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return intersectionList;

    }

    /**
     * kesisim kumesini bulan fonksiyon
     *
     * @param index recursive olarak elemanlarin uzerinden gecmek icin kullanila
     * parametre
     */
    public void intersectionOfLists(int index) {

        if (list1.isEmpty() || list2.isEmpty()) {
            return;
        }
        if (list2.contains(list1.get(index)) && !intersectionList.contains(list1.get(index))) {
            intersectionList.add(list1.get(index));
        }
        if (index == list1.size() - 1) {
            return;
        } else {
            intersectionOfLists(index + 1);
        }

    }

    /**
     * bilesim kumesini bulan fonksiyonun wrapperi
     *
     * @return bilesim kumesi listi
     */
    public List unionOfLists() {

        try {

            for (int i = 0; i < list1.size(); ++i) {
                unionList.add(list1.get(i));
            }
            unionOfLists(0);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return unionList;

    }

    /**
     * bilesim kumesini bulan fonksiyon
     *
     * @param index bilesim kumesi listi
     */
    public void unionOfLists(int index) {

        if (list2.isEmpty() || list2.isEmpty()) {
            return;
        }

        if (!unionList.contains(list2.get(index))) {
            unionList.add(list2.get(index));
        }

        if (index == list2.size() - 1) {
            return;
        } else {
            unionOfLists(index + 1);
        }
    }

    /**
     * list2 list1'in alt kumesi mi kontrol eden wrapper
     *
     * @return boolean
     */
    public boolean isSubset() {

        return isSubset(0);

    }

    /**
     * list2 list1'in alt kumesi mi kontrol edenfonksiyon
     *
     * @param index recursive olarak elemanlarin uzerinden gecmek icin
     * kullanilan parametre
     * @return boolean
     */
    public boolean isSubset(int index) {
        if (list2.isEmpty()) {
            return true;
        }

        if (list1.isEmpty()) {
            return false;
        }

        if (index == list2.size() - 1) {
            return true;
        }

        if (list1.contains((list2.get(index)))) {
            return true && isSubset(index + 1);
        } else {
            return false;
        }
    }

    /**
     * list1 getteri
     *
     * @return
     */
    public List getList1() {
        return list1;
    }

    /**
     * list2 getteri
     *
     * @return
     */
    public List getList2() {
        return list2;
    }

}
