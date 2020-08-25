package com.zhangqianchun.pojo;

import java.util.ArrayList;
import java.util.List;

// 利用简单集合模拟一个数据库
public class UserDB {
    private static List<User> list =new ArrayList<>();

    static {
        list.add(new User("妲己","123"));
        list.add(new User("纣王","123"));
        list.add(new User("姜子牙","123"));
        list.add(new User("哪吒","123"));
        list.add(new User("lisa","123"));
    }

    public static User find(String username,String password){
        for (User user:list) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

}
