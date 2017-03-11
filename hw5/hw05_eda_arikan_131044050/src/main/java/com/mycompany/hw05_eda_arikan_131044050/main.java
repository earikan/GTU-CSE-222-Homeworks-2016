package com.mycompany.hw05_eda_arikan_131044050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
          /**
           * Part 1
         * ****************************************************
         */
        System.out.println("\nPart I");
        
        myHanoi variable = new myHanoi();
        
        Stack<Integer> src = new Stack();
        Stack<Integer> dst = new Stack();
        Stack<Integer> aux = new Stack();

        variable.TowerOfHanoi(3, src, dst, aux);  //disk size baslangic olarak 3 verdim 

        /**
         * Part 2
         * ****************************************************
         */
        linklistRec<Integer> variable1 = new linklistRec();
        
        variable1.add(5);
        variable1.add(8);
        variable1.add(8);
        variable1.add(3);
        variable1.add(8);
        variable1.add(6);
        variable1.add(8);

        System.out.println("\nPart II");

        System.out.print("List: " + variable1);

        variable1.remove(8);

        System.out.print("\nAfter removed 8 from this list:");

        System.out.print("\n" + "List: " + variable1);

        /**
         * Part3
         * ****************************************************
         */
        System.out.println("\n\nPart III");

        recursiveOperations variable2 = new recursiveOperations();

        System.out.println("First List: " + variable2.getList1());

        System.out.println("Second List: " + variable2.getList2());

        System.out.println("Intersection: " + variable2.intersectionOfList());

        System.out.println("Union: " + variable2.unionOfLists());

        System.out.println("Is second list subset of first list?: " + variable2.isSubset());

    }

}
