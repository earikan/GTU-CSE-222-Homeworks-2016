
import com.mycompany.hw03.SpecList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
    public void addAllAtHeadForString() {
        Collection<String> firstList = new LinkedList<>();
        firstList.add("eda");
        firstList.add("buse");

        SpecList<String> secondList = new SpecList<>();
        secondList.add("begum");
        secondList.add("merve");
        secondList.add("ahmet");

        Assert.assertEquals(true, secondList.addAllAtHead(firstList));

    }

    @Test
    public void addAllAtHeadForInteger() {
        Collection<Integer> firstList = new ArrayList<>();

        firstList.add(58);
        firstList.add(6);
        firstList.add(12);

        SpecList<Integer> secondList = new SpecList<>();
        secondList.add(86);
        secondList.add(3);

        Assert.assertEquals(true, secondList.addAllAtHead(firstList));

    }

    @Test
    public void addAllAtHeadForDouble() {
        Collection<Double> firstList = new LinkedList<>();

        firstList.add(12.45);
        firstList.add(65.625);

        SpecList<Double> secondList = new SpecList<>();
        secondList.add(3.3);
        secondList.add(8.42);

        Assert.assertEquals(true, secondList.addAllAtHead(firstList));

    }

    @Test
    public void intersectListTestForString() {

        Collection<String> firstList = new LinkedList<>();
        firstList.add("eda");
        firstList.add("buse");

        SpecList<String> secondList = new SpecList<>();
        secondList.add("begum");
        secondList.add("merve");
        secondList.add("eda");

        Collection<String> intersectionList = new LinkedList<>();
        intersectionList.add("eda");

        Assert.assertEquals(intersectionList, secondList.getIntersectList(firstList));

    }

    @Test
    public void intersectListTestForInteger() {

        Collection<Integer> firstList = new LinkedList<>();
        firstList.add(56);
        firstList.add(524);
        firstList.add(3);

        SpecList<Integer> secondList = new SpecList<>();
        secondList.add(62);
        secondList.add(456);
        secondList.add(3);

        Collection<Integer> intersectionList = new LinkedList<>();
        intersectionList.add(3);

        Assert.assertEquals(intersectionList, secondList.getIntersectList(firstList));

    }

    @Test
    public void intersectListTestForDouble() {

        Collection<Double> firstList = new LinkedList<>();
        firstList.add(5.6);
        firstList.add(5.24);
        firstList.add(3.4);

        SpecList<Double> secondList = new SpecList<>();
        secondList.add(6.2);
        secondList.add(5.24);
        secondList.add(3.0);

        Collection<Double> intersectionList = new LinkedList<>();
        intersectionList.add(5.24);

        Assert.assertEquals(intersectionList, secondList.getIntersectList(firstList));

    }

    @Test
    public void sortListTestForInteger() {

        SpecList<Integer> firstList = new SpecList<>();

        firstList.add(5);
        firstList.add(65);
        firstList.add(74);
        firstList.add(2);

        SpecList<Integer> intersectionList = new SpecList<>();
        intersectionList.add(74);
        intersectionList.add(65);
        intersectionList.add(5);
        intersectionList.add(2);

        Assert.assertEquals(intersectionList, firstList.sortList(0));
    }

    @Test
    public void sortListTestForDouble() {

        SpecList<Double> firstList = new SpecList<>();

        firstList.add(5.52);
        firstList.add(6.5);
        firstList.add(7.4);
        firstList.add(21.0);

        SpecList<Double> intersectionList = new SpecList<>();
        intersectionList.add(21.0);
        intersectionList.add(7.4);
        intersectionList.add(6.5);
        intersectionList.add(5.52);

        Assert.assertEquals(intersectionList, firstList.sortList(0));
    }

    @Test
    public void sortListTestForString() {

        SpecList<String> firstList = new SpecList<>();

        firstList.add("a");
        firstList.add("z");
        firstList.add("c");
        firstList.add("g");

        SpecList<String> intersectionList = new SpecList<>();
        intersectionList.add("z");
        intersectionList.add("g");
        intersectionList.add("c");
        intersectionList.add("a");

        Assert.assertEquals(intersectionList, firstList.sortList(0));
    }

}
