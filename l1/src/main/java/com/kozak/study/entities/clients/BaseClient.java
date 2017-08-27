package com.kozak.study.entities.clients;

public abstract class BaseClient {
    private long id;

    public BaseClient(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseClient{" +
                "id=" + id +
                '}';
    }
}
