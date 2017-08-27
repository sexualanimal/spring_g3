package com.kozak.study.entities.events;

import java.util.Date;

public abstract class BaseEvent {
    private long id;
    private Date date;

    public BaseEvent(long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
