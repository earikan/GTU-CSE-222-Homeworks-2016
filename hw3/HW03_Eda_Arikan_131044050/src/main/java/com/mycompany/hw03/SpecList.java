
package com.mycompany.hw03;

import java.util.*;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eda
 * @param <E> generic tip
 */
public class SpecList< E extends Comparable<E>> extends LinkedList<E> {

    /**
     * SpecList constructoru
     *
     * @param c Collection tipinde bir referans
     */
    public SpecList(Collection c) {
        super(c);
    }

    /**
     * SpecList constructoru
     */
    public SpecList() {
        super();
    }

    /**
     * Gelen referansi var olan listenin basina ekliyor
     *
     * @param c Collection tipinde bir referans
     * @return boolean
     */
    public boolean addAllAtHead(Collection<? extends E> c) {

        try {

            final Iterator itr = c.iterator();
            int i = 0;

            if (!itr.hasNext()) { //eklenmek istenen liste bossa
                return false;
            }

            if (c.isEmpty()) { //eklenecek liste boşsa
                return false;
            }

            while (itr.hasNext()) {
                Object lastElement = itr.next();
                add(i, (E) lastElement);
                ++i;
            }

            return true;

        } catch (NoSuchElementException | NullPointerException e) {
            System.out.printf("Exception : " + e.getMessage());
            return false;
        }

    }

    /**
     * Gelen iki listenin ortak elemanlarini bulup, ortak eleman listesi
     * olusturuluyor
     *
     * @param c Collection tipinde bir referans
     * @return kesisim listesi
     */
    public List<E> getIntersectList(Collection<? extends E> c) {

        try {

            final Iterator itr = c.iterator();
            int i = 0;

            List<E> intersection = new <E> LinkedList();

            while (itr.hasNext()) {
                Object element = itr.next();
                if (contains((E) element) && !(intersection.contains((E) element))) {
                    intersection.add((E) element);
                }
                ++i;
            }

            return intersection;

        } catch (NoSuchElementException | NullPointerException e) {
            System.out.printf("Exception : " + e.getMessage());
            return null;
        }

    }

    /**
     * Gelen listeyi azalan ya da artan sekilde siraliyor
     *
     * @param number 0 ise azalan, 1 ise artan siralaniyor
     * @return siralanmis list
     */
    public List<E> sortList(int number) {

        try {

            if (number == 0) { //azalan siralama
                for (int i = 0; i < size() / 2; i++) {
                    boolean swapped = false;
                    for (int j = i; j < size() - i - 1; j++) {
                        if ((get(j)).compareTo(get(j + 1)) < 0) {
                            Collections.swap(this, j, j + 1);
                            swapped = true;
                        }
                    }

                    for (int j = size() - 2 - i; j > i; j--) {
                        if ((get(j)).compareTo(get(j - 1)) > 0) {
                            Collections.swap(this, j, j - 1);
                            swapped = true;
                        }
                    }

                    if (!swapped) {
                        break;
                    }

                }
                return this;
            }

            if (number == 1) { //artan siralama
                boolean swapped;
                do {
                    swapped = false;

                    for (int i = 0; i <= size() - 2; i++) {
                        if ((get(i)).compareTo(get(i + 1)) > 0) {
                            Collections.swap(this, i, i + 1);
                            swapped = true;
                        }
                    }

                    if (!swapped) {
                        break;
                    }

                    swapped = false;

                    for (int i = size() - 2; i >= 0; i--) {
                        if ((get(i)).compareTo(get(i + 1)) > 0) {
                            Collections.swap(this, i, i + 1);
                            swapped = true;
                        }
                    }

                } while (swapped);
                return this;
            }

            return null;
        } catch (NullPointerException e) {
            System.out.printf("Exception : " + e.getMessage());
            return null;
        }

    }

}
