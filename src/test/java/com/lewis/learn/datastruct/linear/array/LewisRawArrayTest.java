package com.lewis.learn.datastruct.linear.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LewisRawArrayTest {

    private LewisRawArray rawArray;

    @Before
    public void setUp() {
        rawArray = new LewisRawArray(5);
        rawArray.insert(0, "zero");
        rawArray.insert(1, "one");
        rawArray.insert(2, "two");
        rawArray.insert(3, "three");
        rawArray.insert(4, "four");
    }

    @Test
    public void testInsert() {
        rawArray.insert(5, "five");
        rawArray.insert(6, "six");
        rawArray.printArray();
    }

    @Test
    public void testDelete() {
        rawArray.delete(2);
        rawArray.printArray();
    }

    @Test
    public void testFind() {
        Assert.assertEquals(rawArray.find(1),"one");
        Assert.assertEquals(rawArray.find(2),"two");
        Assert.assertEquals(rawArray.find(-1),"not_found");
        Assert.assertEquals(rawArray.find(6),"not_found");
    }

}