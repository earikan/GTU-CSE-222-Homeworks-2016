/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.hw05_eda_arikan_131044050.linklistRec;
import com.mycompany.hw05_eda_arikan_131044050.myHanoi;
import com.mycompany.hw05_eda_arikan_131044050.recursiveOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eda
 */
public class JUnitTest {

    public JUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TowerOfHanoii() {
        myHanoi hanoi = new myHanoi();

        Stack<Integer> src = new Stack();
        Stack<Integer> dst = new Stack();
        Stack<Integer> aux = new Stack();

        hanoi.TowerOfHanoi(3, src, dst, aux);

        Stack<Integer> temp = new Stack();
        temp.push(3);
        temp.push(2);

        temp.push(1);

        Assert.assertEquals(dst.peek(), temp.peek());

    }

    @Test
    public void linklistRec() {
        linklistRec<Integer> var1 = new linklistRec();
        linklistRec<Integer> var2 = new linklistRec();
        var1.add(5);
        var1.add(8);
        var1.add(8);
        var1.add(3);
        var1.add(8);
        var1.add(6);
        var1.add(8);

        Assert.assertEquals(true, var1.remove(3));

    }

    @Test
    public void recursiveIntersection() {
        recursiveOperations ex3 = new recursiveOperations();

        List list = new ArrayList();
        list.add(7);
        list.add(1);
        list.add(99);
        list.add(2);

        Assert.assertEquals(list, ex3.intersectionOfList());
    }

    @Test
    public void recursiveUnion() {
        recursiveOperations ex3 = new recursiveOperations();

        List list = new ArrayList();
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(99);
        list.add(61);
        list.add(2);
        list.add(9);
        list.add(3);
        list.add(13);

        Assert.assertEquals(list, ex3.unionOfLists());

    }

}
