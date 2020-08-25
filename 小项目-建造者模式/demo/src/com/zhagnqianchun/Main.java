package com.zhagnqianchun;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        MessageTask.Builder builder = new MessageTask.Builder();

        MessageTask task = builder.setTaskId("妲己")
                .setContent("来和妲己玩耍吧！")
                .setTaskName("一起玩耍")
                .setMessageId(String.valueOf(ThreadLocalRandom.current().nextLong()))
                .build();

        System.out.println(task);

        User user = User.UserBuilder.anUser().setAddress("北京")
                .setHobby("爬山")
                .setPassword("123")
                .setUsername("小妲己")
                .build();

        System.out.println(user);
    }





}
