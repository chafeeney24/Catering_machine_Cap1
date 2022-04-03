package com.techelevator.view;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserInputTest {
@Rule
    public final TextFromStandardInputStream systemInMock=emptyStandardInputStream();
@Test
    public void lowerD(){
    systemInMock.provideLines("d");
    String expected="Display";
    String actual=UserInput.showMainMenu();
    Assert.assertEquals(expected,actual);
}
    @Test
    public void capitalD(){
        systemInMock.provideLines("D");
        String expected="Display";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void capitalP(){
        systemInMock.provideLines("P");
        String expected="Purchase";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerP(){
        systemInMock.provideLines("p");
        String expected="Purchase";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerE(){
        systemInMock.provideLines("e");
        String expected="Exit";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void capitalE(){
        systemInMock.provideLines("E");
        String expected="Exit";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerS(){
        systemInMock.provideLines("s");
        String expected="Sales Report";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void capitalS(){
        systemInMock.provideLines("S");
        String expected="Sales Report";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerq(){
        systemInMock.provideLines("q");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerX(){
        systemInMock.provideLines("x");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void lowerDP(){
        systemInMock.provideLines("dp");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void capitalED(){
        systemInMock.provideLines("ED");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
}
