package com.pangchun.test;

import com.pangchun.pojo.PersonBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Test04 {

    @Test
    public void test1() {
        List<PersonBean> personBeanList = new ArrayList<PersonBean>();
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p2",10000));
        personBeanList.add(new PersonBean("p3",100000));

        List<PersonBean> newPersonBeanList = personBeanList.stream().distinct().collect(Collectors.toList());


        System.out.println("========Êä³öÐÂµÄList============");
        for (PersonBean p:newPersonBeanList) {
            System.out.println(p.toString());
        }
    }
}
