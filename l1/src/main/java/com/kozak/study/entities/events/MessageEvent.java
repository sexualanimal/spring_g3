package com.kozak.study.entities.events;

import java.util.Date;

public class MessageEvent extends BaseEvent {
    private String message;

    public MessageEvent(long id, Date date) {
        super(id, date);
    }

    public MessageEvent(long id, Date date, String message) {
        super(id, date);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", message='" + message + '\'' +
                '}';
    }
}
