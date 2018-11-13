package com.bocloud.work;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit的测试方法必须使用@Test注解
 * 测试方法必须以public void修饰，并且不包含参数
 */
public class ClaculateTest {

    @Test
    public void testAdd() {
    /**
     * assertEquals这个方法是一个断言方法
     * 第一个参数表示预期的结果
     * 第二个参数表示程序的执行结果
     * 当预期结果与执行结果是一致的时候，则表示单元测试成功
     */
    assertEquals(4, new Claculate().add(1, 3));
    }

   
    @Test
    public void testSubtract() {
    assertEquals(4, new Claculate().subtract(9, 5));
    }
    
    @Test
    public void testMultiply() {
    assertEquals(6, new Claculate().multiply(2, 3));
    }
    
    @Test(expected=ArithmeticException.class)
    public void testDivide() {
    assertEquals(3, new Claculate().divide(9, 0));
    }
}
