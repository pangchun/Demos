package com.zhangqianchun.Pojo;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private static List<User> list = new ArrayList<>();

    static {
        list.add(new User("����ɪ","123"));
        list.add(new User("�������","123"));
        list.add(new User("С³��","123"));
        list.add(new User("С槼�","123"));
    }

    public static User find(String username,String password) {

        for (User user:list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }
}
