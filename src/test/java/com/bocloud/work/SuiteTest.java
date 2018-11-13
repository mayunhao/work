package com.bocloud.work;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件类
 * 测试套件是用来组织多个测试类一起运行的，使用 @RunWith注解
 * 更改测试运行器为Suite.class，将要测试的类作为数组传入
 * 到Suite.SuiteClasses({})中，测试套件类不能包含其他测试方法
 * 
 * 样例如下：
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TaskTest1.class, TaskTest2.class})
public class SuiteTest {}