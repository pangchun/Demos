package com.pangchun.pojo;

import java.util.Objects;

public class PersonBean {
    private String name;
    private Integer money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public PersonBean(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    /* ��дequals���� */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBean that = (PersonBean) o;
        /* ��name��money����ͬʱ����true */
        return Objects.equals(name, that.name) &&
                Objects.equals(money, that.money);
    }

    /* ��дhashcode���� */

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
