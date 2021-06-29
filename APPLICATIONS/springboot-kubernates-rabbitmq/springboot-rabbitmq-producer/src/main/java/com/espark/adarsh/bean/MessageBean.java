package com.espark.adarsh.bean;

public class MessageBean <T>{

    private String messageId;
    private String sender;
    private T data;

    public MessageBean() {
    }

    public MessageBean(String messageId, T data) {
        this.messageId = messageId;
        this.data = data;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "messageId='" + messageId + '\'' +
                ", sender='" + sender + '\'' +
                ", data=" + data +
                '}';
    }
}
