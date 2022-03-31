package com.techelevator.Utilities;

import com.techelevator.item.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StockerTest {
    Stocker stocker;
    @Before
    public void setUp() throws Exception {
        stocker=new Stocker();
    }

    @Test
    public void checkMapIsCreated(){
        Map<String , Item> expected=new HashMap<>();

//        assertTrue(expected.equals(actual));
    }
}
