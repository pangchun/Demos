package com.zhagnqianchun;

public class MessageTask {

    private String taskId;
    private String content;
    private String messageId;
    private String taskName;

    //5.重写toString
    @Override
    public String toString() {
        return "MessageTask{" +
                "taskId='" + taskId + '\'' +
                ", content='" + content + '\'' +
                ", messageId='" + messageId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    //2.增加private构造函数
    private MessageTask(Builder builder) {

        this.taskId = builder.taskId;
        this.content = builder.content;
        this.messageId = builder.messageId;
        this.taskName = builder.taskName;

    }

    //1.创建内部类
    public static class Builder {

        private String taskId;
        private String content;
        private String messageId;
        private String taskName;

        //3.赋值属性得方法（返回的是builder）
        public Builder setTaskId(String taskId) {

            this.taskId = taskId;
            return this;

        }

        public Builder setContent(String content) {

            this.content = content;
            return this;

        }

        public Builder setMessageId(String messageId) {

            this.messageId = messageId;
            return this;

        }

        public Builder setTaskName(String taskName) {

            this.taskName = taskName;
            return this;

        }

        //4.创建builder方法，返回实例
        public MessageTask build() {
            return new MessageTask(this); //这里调用了第二步定义的构造函数
        }


    }
}
