package com.pangchun.test;
import com.pangchun.pojo.PersonBean;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    /* 双重for循环去重 */
    @Test
    public void test1() {
        List<PersonBean> personBeanList = new ArrayList<PersonBean>();
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p1",1000));

        List<PersonBean> newPersonBeanList = new ArrayList<PersonBean>();

        for (PersonBean p:personBeanList) {
            if (newPersonBeanList.isEmpty()) {
                newPersonBeanList.add(p);
            }else {
                boolean isSame = false;
                for (PersonBean p1:newPersonBeanList) {
                    /* 依靠name和money来判断有无重复元素，有就跳过 */
                    if (p1.getName().equals(p.getName()) && p1.getMoney().equals(p.getMoney())) {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame) {
                    newPersonBeanList.add(p);
                }
            }
        }

        System.out.println("========输出新的List============");
        for (PersonBean p:newPersonBeanList) {
            System.out.println(p.toString());
        }
    }
}
