import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalaryCalculatorTest.
 *
 * @author  Andrew Olesak
 * @version November 12, 2015
 */
public class SalaryCalculatorTest
{
    private SalaryCalculator test;
    
    /**
     * Default constructor for test class SalaryCalculatorTest
     */
    public SalaryCalculatorTest()
    {
        this.test = new SalaryCalculator();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testCalcWeeklySalaryShouldBeEightyOnePointSix(){
        Assert.assertEquals("Should be 81.6", 81.6, .001, this.test.calcWeeklySalary(8.5, 12));
    }
    
    @Test
    public void testCalcMonthlySalaryShouldBeThreeZeroSevenPointTwo(){
        Assert.assertEquals("Should be 307.", 307.2, .001, this.test.calcMonthlySalary(8.0, 12));
    }
    
    @Test
    public void testCalcYearlySalaryShouldBeTwoZeroEightZero(){
        Assert.assertEquals("Should be 2080", 2080, .001, this.test.calcYearlySalary(5, 10));
    }
    
    @Test
    public void testTimeToMakeMoneyShouldBeSix(){
        Assert.assertEquals("Should be 12", 12, .001, this.test.timeToMakeMoney(1040, 5, 10));
    }
    
    @Test
    public void testConvertToHourlyWageShouldBeFifty(){
        Assert.assertEquals("Should be 50", 50, .001, this.test.convertToHourlyWage(104000));
    }
}
