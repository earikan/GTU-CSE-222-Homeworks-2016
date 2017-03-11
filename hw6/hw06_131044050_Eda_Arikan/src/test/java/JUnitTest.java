/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.hw06_131044050_eda_arikan.BinarySearchTree;
import com.mycompany.hw06_131044050_eda_arikan.BinarySearchTree.bstIterator;
import com.mycompany.hw06_131044050_eda_arikan.HuffmanTree;
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
    public void bstAdd() {

        BinarySearchTree<Integer> Btree = new BinarySearchTree<Integer>();
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(11);
        Btree.add(0);

        Assert.assertEquals(true, Btree.add(20));

    }

    @Test
    public void bstDelete() {

        BinarySearchTree<Integer> Btree = new BinarySearchTree<Integer>();
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(11);
        Btree.add(0);

        Assert.assertEquals(null, Btree.delete(13));

    }

    @Test
    public void bstTraverse() {

        String temp = "";
        String beklenen = "0121112"; //kucukten buyuge
        BinarySearchTree<Integer> Btree = new BinarySearchTree<Integer>();
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(11);
        Btree.add(0);

        bstIterator itr = new bstIterator(Btree.getRoot());

        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.println(element);
            temp += element;
        }

        Assert.assertEquals(beklenen, temp);

    }

    @Test
    public void huffmanDecode() {

        HuffmanTree Htree = new HuffmanTree();

        // Create symbol array
        HuffmanTree.HuffData[] symbols = {
            new HuffmanTree.HuffData(186, '_'),
            new HuffmanTree.HuffData(103, 'e'),
            new HuffmanTree.HuffData(80, 't'),
            new HuffmanTree.HuffData(64, 'a'),
            new HuffmanTree.HuffData(63, 'o'),
            new HuffmanTree.HuffData(57, 'i'),
            new HuffmanTree.HuffData(57, 'n'),
            new HuffmanTree.HuffData(51, 's'),
            new HuffmanTree.HuffData(48, 'r'),
            new HuffmanTree.HuffData(47, 'h'),
            new HuffmanTree.HuffData(32, 'd'),
            new HuffmanTree.HuffData(32, 'l'),
            new HuffmanTree.HuffData(23, 'u'),
            new HuffmanTree.HuffData(22, 'c'),
            new HuffmanTree.HuffData(21, 'f'),
            new HuffmanTree.HuffData(20, 'm'),
            new HuffmanTree.HuffData(18, 'w'),
            new HuffmanTree.HuffData(16, 'y'),
            new HuffmanTree.HuffData(15, 'g'),
            new HuffmanTree.HuffData(15, 'p'),
            new HuffmanTree.HuffData(13, 'b'),
            new HuffmanTree.HuffData(8, 'v'),
            new HuffmanTree.HuffData(5, 'k'),
            new HuffmanTree.HuffData(1, 'j'),
            new HuffmanTree.HuffData(1, 'q'),
            new HuffmanTree.HuffData(1, 'x'),
            new HuffmanTree.HuffData(1, 'z')
        };

        // Build hufffman tree 
        Htree.buildTree(symbols);

        // Print huffman codes of the symbols
        String EncodedSymbolList = Htree.toString();

        String code = "010101111010";
        String decodedCode = Htree.decode(code);

        Assert.assertEquals("eda", decodedCode);
    }

    @Test
    public void huffmanEncode() {

        HuffmanTree Htree = new HuffmanTree();

        // Create symbol array
        HuffmanTree.HuffData[] symbols = {
            new HuffmanTree.HuffData(186, '_'),
            new HuffmanTree.HuffData(103, 'e'),
            new HuffmanTree.HuffData(80, 't'),
            new HuffmanTree.HuffData(64, 'a'),
            new HuffmanTree.HuffData(63, 'o'),
            new HuffmanTree.HuffData(57, 'i'),
            new HuffmanTree.HuffData(57, 'n'),
            new HuffmanTree.HuffData(51, 's'),
            new HuffmanTree.HuffData(48, 'r'),
            new HuffmanTree.HuffData(47, 'h'),
            new HuffmanTree.HuffData(32, 'd'),
            new HuffmanTree.HuffData(32, 'l'),
            new HuffmanTree.HuffData(23, 'u'),
            new HuffmanTree.HuffData(22, 'c'),
            new HuffmanTree.HuffData(21, 'f'),
            new HuffmanTree.HuffData(20, 'm'),
            new HuffmanTree.HuffData(18, 'w'),
            new HuffmanTree.HuffData(16, 'y'),
            new HuffmanTree.HuffData(15, 'g'),
            new HuffmanTree.HuffData(15, 'p'),
            new HuffmanTree.HuffData(13, 'b'),
            new HuffmanTree.HuffData(8, 'v'),
            new HuffmanTree.HuffData(5, 'k'),
            new HuffmanTree.HuffData(1, 'j'),
            new HuffmanTree.HuffData(1, 'q'),
            new HuffmanTree.HuffData(1, 'x'),
            new HuffmanTree.HuffData(1, 'z')
        };

        // Build hufffman tree 
        Htree.buildTree(symbols);

        // Print huffman codes of the symbols
        String EncodedSymbolList = Htree.toString();

        String code2 = "mor";
        String encodedCode = Htree.encode(code2);

        Assert.assertEquals("11001010010010", encodedCode);

    }

}
