package com.zhangqianchun.pojo;

import java.util.ArrayList;
import java.util.List;

// ���ü򵥼���ģ��һ�����ݿ�
public class UserDB {
    private static List<User> list =new ArrayList<>();

    static {
        list.add(new User("槼�","123"));
        list.add(new User("����","123"));
        list.add(new User("������","123"));
        list.add(new User("��߸","123"));
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
