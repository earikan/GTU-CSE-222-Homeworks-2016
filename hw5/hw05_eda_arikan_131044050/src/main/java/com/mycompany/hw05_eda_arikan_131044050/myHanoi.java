package com.mycompany.hw05_eda_arikan_131044050;

import static java.lang.Math.pow;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eda
 */
public class myHanoi {

    private char d = 'D';
    private char s = 'S';
    private char a = 'A';

    /**
     * constructor
     */
    public myHanoi() {
    }

    /**
     * disk sayisi kontrolu disk sayisinin tek veya cift olmasi minimum hamle
     * icin etkili
     *
     * @param disksize disk sayisi
     */
    public void disksizeControl(int disksize) {

        if (disksize % 2 == 0) {
            char temp = a;
            a = d;
            d = temp;
        }

    }

    /**
     * diskler boyutuna gore bir stacke push ediliyor
     *
     * @param src ilk cubuk
     * @param disksize disk sayisi
     */
    public void fillSource(Stack<Integer> src, int disksize) {

        for (int i = disksize; i >= 1; --i) {
            src.push(i);
        }

    }

    /**
     * tower of hanoi'de total hamlelere bakildiginda her 3 hamlede bir
     * gerceklesen hamlelerde belli cubuklar arasinda senkron var, kontrol
     * ediyoruz, cubuklari stack gibi dusunuyoruz
     *
     * @param disksize disk sayisi
     * @param src source stacki
     * @param dst destination stacki
     * @param aux auxiliary stacki
     */
    public void TowerOfHanoi(int disksize, Stack<Integer> src, Stack<Integer> dst, Stack<Integer> aux) {

        disksizeControl(disksize);

        fillSource(src, disksize);

        int allMoves = (int) pow(2, disksize) - 1; // total hamle (2^n) -1

        for (int i = 1; i <= allMoves; ++i) {

            if (i % 3 == 1) { // her 3 hamlede bir belirli cubuklar arasinda hamle yapiliyor
                move(src, dst, s, d);
            } else if (i % 3 == 2) {
                move(src, aux, s, a);
            } else if (i % 3 == 0) {
                move(aux, dst, a, d);
            }

        }

    }

    /**
     * hamle icin cagirilan fonksiyon her bir hamle icin bir stackten digerine
     * eleman atiliyor gelen parametrelere gore bu fonksiyonda source ve
     * destination degisiyor(s d, s a, a d)
     * 
     * @param src temp source stacki
     * @param dst temp destination stacki
     * @param s ekrana basilacak source karakteri
     * @param d ekrana basilacak destination karakteri
     */
    public void move(Stack<Integer> src, Stack<Integer> dst, char s, char d) {

        try {
            if (src.empty()) { //source bossa source'a atiliyor
                int topElementOfSecondPeg = dst.pop();
                src.push(topElementOfSecondPeg);
                System.out.println("Move disk " + topElementOfSecondPeg + "  " + d + " -> " + s);

            } else if (dst.empty()) { //destination bossa oraya atiliyor
                int topElementOfFirstPeg = src.pop();
                dst.push(topElementOfFirstPeg);
                System.out.println("Move disk " + topElementOfFirstPeg + "  " + s + " -> " + d);

            } else if (src.peek() < dst.peek()) { //source'ta en ustteki eleman destinationdaki elemandan kucukse sourcetan destinationa atiliyor
                int topElementOfFirstPeg = src.pop();
                dst.push(topElementOfFirstPeg);
                System.out.println("Move disk " + topElementOfFirstPeg + "  " + s + " -> " + d);

            } else if (src.peek() > dst.peek()) {//destinationdaki en ustteki eleman sourcetan elemandan kucukse destinationdan sourcea atiliyor
                int topElementOfSecondPeg = dst.pop();
                src.push(topElementOfSecondPeg);
                System.out.println("Move disk " + topElementOfSecondPeg + "  " + d + " -> " + s);

            }

        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

    }
}
