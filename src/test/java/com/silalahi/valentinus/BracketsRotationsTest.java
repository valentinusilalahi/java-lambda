package com.silalahi.valentinus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BracketsRotationsTest {

    private BracketsRotations solution;

    @Before
    public void setUp() {
        this.solution = new BracketsRotations();
    }

    @Test
    public void testNull() {
        Assert.assertEquals(0, solution.solution(null, 0));
        Assert.assertEquals(0, solution.solution(null, 2));
        Assert.assertEquals(0, solution.solution("", 0));
        Assert.assertEquals(0, solution.solution("", 2));
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, solution.solution("((()))", 0));
        Assert.assertEquals(6, solution.solution("((()))", 1));
        Assert.assertEquals(6, solution.solution("((()))", 2));
        Assert.assertEquals(6, solution.solution("((()))", 3));
        Assert.assertEquals(6, solution.solution("((()))", 4));
        Assert.assertEquals(6, solution.solution("((()))", 5));
        Assert.assertEquals(6, solution.solution("((()))", 6));
    }
}
