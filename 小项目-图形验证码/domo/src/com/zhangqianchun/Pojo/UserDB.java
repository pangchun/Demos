package com.zhangqianchun.Pojo;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private static List<User> list = new ArrayList<>();

    static {
        list.add(new User("老亚瑟","123"));
        list.add(new User("子龙哥哥","123"));
        list.add(new User("小鲁班","123"));
        list.add(new User("小妲己","123"));
    }

    public static User find(String username,String password) {

        for (User user:list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }
}
