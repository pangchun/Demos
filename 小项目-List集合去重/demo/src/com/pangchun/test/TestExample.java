package com.pangchun.test;
import org.junit.Test;
public class TestExample {
    @Test
    public void test() {
        System.out.println("test()...");
    }

    /*使用@Test需要导入两个jar包：hamcrest-core-1.3.jar、junit-4.12.jar*/
    /*测试类类名不要取Test，与注解@Test重名会报错*/
}
