
//HW03_Eda_Arikan_131044050

package com.mycompany.hw03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eda
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //cok uzun bir main yazmak yerine her biri icin ayri bir test olusturmak istedim
        forStringTest();
        forIntegerTest();
        forDoubleTest();

    }

    /**
     * String tipi icin mainde cagirilacak test fonksiyonu
     */
    static void forStringTest() {

        //first list olusturulup eleman ekleniyor
        Collection<String> firstList = new ArrayList<>();
        firstList.add("Kalem");
        firstList.add("Dolap");
        firstList.add("Maket");
        firstList.add("Bilgisayar");
        firstList.add("Defter");
        System.out.println("First List Elements: ");
        System.out.print("\t" + firstList + "\n");

        //second list olusturulup eleman ekleniyor
        SpecList<String> secondList = new SpecList<>();
        secondList.add("Bilgisayar");
        secondList.add("Defter");
        secondList.add("Ekran Karti");
        secondList.add("Defter");
        secondList.add("Kalemlik");
        secondList.add("Zeytin");
        System.out.println("Second List Elements: ");
        System.out.print("\t" + secondList + "\n");

        //kesisim kumesi bulunuyor 
        Collection<String> intersectionList;
        intersectionList = secondList.getIntersectList(firstList);
        System.out.println("Their Intersect List: ");
        System.out.print("\t" + intersectionList + "\n");

        //second listin basina first listi ekleyelim
        secondList.addAllAtHead(firstList);
        System.out.println("First List added front of the Second List: ");
        System.out.print("\t" + secondList + "\n");

        //second list sort ediliyor, azalan siralaniyor
        secondList.sortList(0);
        System.out.println("Sorting the Second List (decreasing order): ");
        System.out.print("\t" + secondList + "\n");
        //second list sort ediliyor, artan siralaniyor
        secondList.sortList(1);
        System.out.println("Sorting the Second List (increasing order): ");
        System.out.print("\t" + secondList + "\n");

    }

    /**
     * Integer tipi icin mainde cagirilacak test fonksiyonu
     */
    static void forIntegerTest() {

        //first list olusturulup eleman ekleniyor
        Collection<Integer> firstList = new ArrayList<>();

        firstList.add(5);
        firstList.add(65);
        firstList.add(74);
        firstList.add(2);
        firstList.add(6);
        System.out.println("\nFirst List Elements: ");
        System.out.print("\t" + firstList + "\n");

        //second list olusturulup eleman ekleniyor
        SpecList<Integer> secondList = new SpecList<>();
        secondList.add(2);
        secondList.add(65);
        secondList.add(8541);
        secondList.add(25);
        secondList.add(13);
        secondList.add(54);
        System.out.println("Second List Elements: ");
        System.out.print("\t" + secondList + "\n");

        //kesisim kumesi bulunuyor 
        Collection<Integer> intersectionList;
        intersectionList = secondList.getIntersectList(firstList);
        System.out.println("Their Intersect List: ");
        System.out.print("\t" + intersectionList + "\n");

        //second listin basina first listi ekleyelim
        secondList.addAllAtHead(firstList);
        System.out.println("First List added front of the Second List: ");
        System.out.print("\t" + secondList + "\n");

        //second list sort ediliyor, azalan siralaniyor
        secondList.sortList(0);
        System.out.println("Sorting the Second List (decreasing order): ");
        System.out.print("\t" + secondList + "\n");
        //second list sort ediliyor, artan siralaniyor
        secondList.sortList(1);
        System.out.println("Sorting the Second List (increasing order): ");
        System.out.print("\t" + secondList + "\n");

    }

    /**
     * Double tipi icin mainde cagirilacak test fonksiyonu
     */
    static void forDoubleTest() {

        //first list olusturulup eleman ekleniyor
        Collection<Double> firstList = new ArrayList<>();

        firstList.add(58.36);
        firstList.add(58.375);
        firstList.add(14.6);
        firstList.add(8.5);
        firstList.add(12.33);
        System.out.println("\nFirst List Elements: ");
        System.out.print("\t" + firstList + "\n");

        //second list olusturulup eleman ekleniyor
        SpecList<Double> secondList = new SpecList<>();
        secondList.add(58.375);
        secondList.add(25.76);
        secondList.add(357.02);
        secondList.add(3.6);
        secondList.add(25.7);
        secondList.add(6.2);
        System.out.println("Second List Elements: ");
        System.out.print("\t" + secondList + "\n");

        //kesisim kumesi bulunuyor 
        Collection<Double> intersectionList;
        intersectionList = secondList.getIntersectList(firstList);
        System.out.println("Their Intersect List: ");
        System.out.print("\t" + intersectionList + "\n");

        //second listin basina first listi ekleyelim
        secondList.addAllAtHead(firstList);
        System.out.println("First List added front of the Second List: ");
        System.out.print("\t" + secondList + "\n");

        //second list sort ediliyor, azalan siralaniyor
        secondList.sortList(0);
        System.out.println("Sorting the Second List (decreasing order): ");
        System.out.print("\t" + secondList + "\n");
        //second list sort ediliyor, artan siralaniyor
        secondList.sortList(1);
        System.out.println("Sorting the Second List (increasing order): ");
        System.out.print("\t" + secondList + "\n");

    }

}
