package com.itnove.hello.web;


import org.testng.annotations.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class HelloFunctionalTest {

    @Test(groups= "functional")
    public void test1() {
        assertTrue("Error, not true", true);
    }

    @Test(groups= "functional")
    public void test2() {
        assertTrue("Error, not true", true);
    }

    @Test(groups= "functional")
    public void test3() {
        Random ran = new Random();
        int x = ran.nextInt(4) + 2;
        int high = 8;
        int low = 3;
        System.out.println(x);
        System.out.println(high);
        System.out.println(low);
        assertTrue("Error, random is too high", high >= x);
        assertTrue("Error, random is too low", low <= x);
    }
}
