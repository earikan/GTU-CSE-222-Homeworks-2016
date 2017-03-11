/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.hw04_eda_arikan_131044050.InfixToPosfix;
import com.mycompany.hw04_eda_arikan_131044050.PostfixEvaluater;
import com.mycompany.hw04_eda_arikan_131044050.Variable;
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
    public void addVariable() {

        Variable myVar = new Variable();

        Assert.assertEquals("$t0", myVar.addVariable("82"));

    }

    @Test
    public void deleteDigitRegister() {
        Variable myVar = new Variable();
        myVar.addVariable("82");
        myVar.addVariable("6");
        myVar.addVariable("a");

        Assert.assertEquals(true, myVar.deleteDigitRegisters());
    }

    @Test
    public void getVariableRegister() {
        Variable myVar = new Variable();
        myVar.addVariable("82");
        myVar.addVariable("6");
        myVar.addVariable("a");

        Assert.assertEquals("$t2", myVar.getVariableRegister("a"));
    }

    @Test
    public void isItVariable() {
        PostfixEvaluater myVar = new PostfixEvaluater();

        Assert.assertEquals(true, myVar.isOperator('+'));

    }
    
}
