package com.zhagnqianchun;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        MessageTask.Builder builder = new MessageTask.Builder();

        MessageTask task = builder.setTaskId("槼�")
                .setContent("����槼���ˣ�ɣ�")
                .setTaskName("һ����ˣ")
                .setMessageId(String.valueOf(ThreadLocalRandom.current().nextLong()))
                .build();

        System.out.println(task);

        User user = User.UserBuilder.anUser().setAddress("����")
                .setHobby("��ɽ")
                .setPassword("123")
                .setUsername("С槼�")
                .build();

        System.out.println(user);
    }





}
