package roma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;



/**
 * @author Dominic Roenicke <droenicke@cyberport.de>
 */
public class RomaTest
{
    private Map<String, Integer> testData;

    private Roma roma;

    @Before
    public void setUp()
    {
        testData = new HashMap<>();

        testData.put("I", 1);
        testData.put("II", 2);
        testData.put("IV", 4);
        testData.put("V", 5);
        testData.put("IX", 9);
        testData.put("X", 10);
        testData.put("XLII", 42);
        testData.put("XCIX", 99);
        testData.put("D", 500);
        testData.put("MMXIII", 2013);
        testData.put("MMM", 3000);

        roma = new Roma();
    }

    @Test
    public void testRoma()
    {
        for (final String roma : testData.keySet()) {
            final Integer expected = testData.get(roma);

            Assert.assertEquals(expected, this.roma.calculateNumeral(roma));
        }
    }

    @Test(expected = InvalidArgumentException.class)
    public void testNegativeNullRoma()
    {
        this.roma.calculateNumeral(null);
    }

    @Test(expected = InvalidArgumentException.class)
    public void testNegativeInvalidSemanticRoma()
    {
        this.roma.calculateNumeral("IC");
    }

    @Test(expected = InvalidArgumentException.class)
    public void testNegativeInvalidSyntaxRoma()
    {
        this.roma.calculateNumeral("ZZZ");
    }

    @Test(expected = InvalidArgumentException.class)
    public void testNegativeInvalidSymantic4Roma()
    {
        this.roma.calculateNumeral("XIIIIX");
    }
}
