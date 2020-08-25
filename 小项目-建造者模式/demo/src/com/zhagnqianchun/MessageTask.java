package com.zhagnqianchun;

public class MessageTask {

    private String taskId;
    private String content;
    private String messageId;
    private String taskName;

    //5.��дtoString
    @Override
    public String toString() {
        return "MessageTask{" +
                "taskId='" + taskId + '\'' +
                ", content='" + content + '\'' +
                ", messageId='" + messageId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    //2.����private���캯��
    private MessageTask(Builder builder) {

        this.taskId = builder.taskId;
        this.content = builder.content;
        this.messageId = builder.messageId;
        this.taskName = builder.taskName;

    }

    //1.�����ڲ���
    public static class Builder {

        private String taskId;
        private String content;
        private String messageId;
        private String taskName;

        //3.��ֵ���Ե÷��������ص���builder��
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

        //4.����builder����������ʵ��
        public MessageTask build() {
            return new MessageTask(this); //��������˵ڶ�������Ĺ��캯��
        }


    }
}
