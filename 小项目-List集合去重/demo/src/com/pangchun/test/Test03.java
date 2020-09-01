package com.pangchun.test;

import com.pangchun.pojo.PersonBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test03 {

    @Test
    public void test1() {
        List<PersonBean> personBeanList = new ArrayList<PersonBean>();
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p2",10000));

        List<PersonBean> newPersonBeanList = new ArrayList<PersonBean>();

        /* set去重 */
        HashSet<PersonBean> set = new HashSet<>(personBeanList);
        newPersonBeanList.addAll(set);

        System.out.println("========输出新的List============");
        for (PersonBean p:newPersonBeanList) {
            System.out.println(p.toString());
        }
    }
}
