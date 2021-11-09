package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.allure.AllureUtils;
import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.helper.TestObject;
import org.junit.jupiter.api.Test;

public class AssertTest {

    @Test
    public void sample() {
        AllureUtils.startStep("ReportAssert.assertEquals");
        ReportAssert.assertEquals("1==1 int", 1, 1);
        ReportAssert.assertEquals("1==1 long", 1l, 1l);
        ReportAssert.assertEquals("\"1.0\"==\"1.0\" String", "1.0", "1.0");
        ReportAssert.assertArrayEquals("[1,2]==[1,2] int[]", new int[]{1,2}, new int[]{1,2});
        ReportAssert.assertArrayEquals("[1,2]==[1,2] long[]", new long[]{1l,2l}, new long[]{1l,2l});
        ReportAssert.assertArrayEquals("[1.0,2.0]==[1.0,2.0] float[]", new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, 0);
        ReportAssert.assertArrayEquals("[1.0,2.0]==[1.0,2.0] double[]", new double[]{1.0,2.0}, new double[]{1.0,2.0}, 0);
        ReportAssert.assertEquals("new TestObject(\"1.0\") == new TestObject(\"1.0\")", new TestObject("1.0"), new TestObject("1.0"));
        AllureUtils.stopStepPassed();

        AllureUtils.startStep("ReportAssert.assertNotEquals");
        ReportAssert.assertNotEquals("1!=2 int", 1, 2);
        ReportAssert.assertNotEquals("1!=2 long", 1l, 2l);
        ReportAssert.assertNotEquals("1.0!=2.0 float", new Float(1.0).floatValue(), new Float(2.0).floatValue());
        ReportAssert.assertNotEquals("1.0!=2.0 double", 1.0,  2.0);
        ReportAssert.assertNotEquals("\"1.0\"!=\"2.0\" String", "1.0", "2.0");
        ReportAssert.assertNotEquals("[1,2]!=[2,2] int[]", new int[]{1,2}, new int[]{2,2});
        ReportAssert.assertNotEquals("[1,2]!=[2,2] long[]", new long[]{1l,2l}, new long[]{2l,2l});
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] float[]", new float[]{new Float(1.0).floatValue(),new Float(2.0).floatValue()}, new float[]{new Float(2.0).floatValue(),new Float(2.0).floatValue()});
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] double[]", new double[]{1.0,2.0}, new double[]{2.0,2.0});
        ReportAssert.assertNotEquals("[1.0,2.0]!=[2.0,2.0] String[]", new String[]{"1.0","2.0"}, new String[]{"2.0","2.0"});
        ReportAssert.assertNotEquals("new TestObject(\"1.0\") != new TestObject(\"2.0\")", new TestObject("1.0"), new TestObject("2.0"));
        AllureUtils.stopStepPassed();

        AllureUtils.startStep("ReportAssert.assertTrue/assertFalse");
        ReportAssert.assertTrue("ReportAssert.assertTrue", true);
        ReportAssert.assertFalse("ReportAssert.assertFalse", false);
        AllureUtils.stopStepPassed();
        AllureUtils.startStep("ReportAssert.assertNull");
        ReportAssert.assertNull("ReportAssert.assertNull null", null);
        AllureUtils.stopStepPassed();
        AllureUtils.startStep("ReportAssert.assertSame/assertNotSame");
        TestObject t = new TestObject("1.0");
        ReportAssert.assertSame("t = new TestObject(\"1.0\"); t == t", t, t);
        ReportAssert.assertNotSame("t = new TestObject(\"1.0\"); t !=  new TestObject(\"1.0\");", t, new TestObject("1.0"));
        AllureUtils.stopStepPassed();
    }

}
