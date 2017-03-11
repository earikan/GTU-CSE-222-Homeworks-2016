/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_eda_arikan_131044050;

/**
 * linklistRec classi ve metodlarini kitaptan aldim
 * @author eda
 * @param <E>
 */
public class linklistRec<E> {

    private Node<E> head;

    /**
     * inner node classi
     *
     * @param <E> generic type
     */
    private static class Node<E> {

        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;

        }

        private Node(E dataItem, Node<E> nodeRef) {

            data = dataItem;
            next = nodeRef;

        }

    }

    /**
     * bir linkedlisten duplicate eleman silme fonksiyonu
     *
     * @param head ilk node
     * @param pred head'den onceki node
     * @param outData silinecek eleman
     * @return boolean
     */
    private boolean remove(Node<E> head, Node<E> pred, E outData) {
        if (head == null) {
            return false;
        } else if (head.data.equals(outData)) {
            pred.next = head.next;
            remove(head.next, pred, outData);
            return true;
        } else {
            return remove(head.next, head, outData);
        }

    }

    /**
     * wrapper remove fonksiyonu
     *
     * @param outData silinecek eleman
     * @return boolean
     */
    public boolean remove(E outData) {
        if (head == null) {
            return false;
        } else if (head.data.equals(outData)) {
            head = head.next;
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }

    /**
     * eleman eklemek icin kullanilan add fonksiyonu
     *
     * @param head ilk node
     * @param data eklenecek data
     */
    private void add(Node<E> head, E data) {
        if (head.next == null) {
            head.next = new Node<E>(data);
        } else {
            add(head.next, data);
        }
    }

    /**
     * wrapper add fonksiyonu
     *
     * @param data eklenecek data
     */
    public void add(E data) {
        if (head == null) {
            head = new Node<E>(data);
        } else {
            add(head, data);
        }
    }

    /**
     * ekrana basmak icin toString fonksiyonu
     *
     * @param head ilk node
     * @return string
     */
    public String toString(Node<E> head) {
        if (head == null) {
            return "";
        } else {
            return head.data + " " + toString(head.next);
        }
    }

    /**
     * wrapper toString fonksiyonu
     *
     * @return string
     */
    public String toString() {
        return toString(head);
    }

}
