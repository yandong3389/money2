package d.money;

import java.util.Calendar;
import java.util.Date;

import d.money.common.utils.DateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        TestLangDemo langDemo = new TestLangDemo();
        
        langDemo.charSetDemo();
        langDemo.charSetUtilsDemo();
        langDemo.objectUtilsDemo();
        langDemo.serializationUtilsDemo();
        langDemo.randomStringUtilsDemo();
        langDemo.stringUtilsDemo();
        langDemo.systemUtilsDemo();
        langDemo.classUtilsDemo();
        langDemo.stringEscapeUtilsDemo();
        langDemo.builderDemo();
        langDemo.numberUtils();
        langDemo.dateFormatUtilsDemo();
        langDemo.validateDemo();
        langDemo.wordUtilsDemo();
        
        
    	Date nowDate = new Date();
    	
    	Date backDate = DateUtil.rollDate(nowDate, Calendar.DATE, -7);
    	
    	System.out.println("结算时间为：" + DateUtil.formatDate(backDate, "yyyy-MM-dd HH:mm:ss") +"至"
    	             + DateUtil.formatDate(nowDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
