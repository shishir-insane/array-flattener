package com.sk.intercom.flatten;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlattenArrayTest {

    Integer[] expectedArray;

    @Before
    public void init() {
        expectedArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullThrowsException() {
        Assert.assertNull("Testing a null argument", FlattenArray.flatten(null));
    }

    @Test
    public void testEmptyArray() {
        Assert.assertArrayEquals("Testing an empty array", new Integer[] {}, FlattenArray.flatten(new Object[] {}));
    }

    @Test
    public void testFlatArray() {
        Assert.assertArrayEquals("Testing a flat array", expectedArray,
                FlattenArray.flatten(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    @Test
    public void testNestedArray() {
        Assert.assertArrayEquals("Testing nested array", expectedArray,
                FlattenArray.flatten(new Object[] { 1, 2, 3, 4, new Object[] { 5, 6, 7, 8 }, 9, 10 }));
    }

    @Test
    public void testMultipleNestedArrays() {
        Assert.assertArrayEquals("Testing multiple nested arrays", expectedArray,
                FlattenArray.flatten(new Object[] { 1, 2, new Object[] { 3, 4, new Object[] { 5 }, 6, 7 }, 8, 9, 10 }));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInArray() {
        FlattenArray.flatten(new Object[] { new Object() });
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInNestedArray() {
        FlattenArray.flatten(new Object[] { 1, 2, new Object[] { 3, new Object() } });
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInArray() {
        FlattenArray.flatten(new Object[] { null });
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInNestedArray() {
        FlattenArray.flatten(new Object[] { 1, 2, new Object[] { 3, null } });
    }
}