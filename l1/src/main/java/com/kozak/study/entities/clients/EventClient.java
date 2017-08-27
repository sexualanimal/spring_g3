package com.kozak.study.entities.clients;

import com.kozak.study.entities.events.BaseEvent;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EventClient<T extends BaseEvent> extends BaseClient {
    private String name;
    private List<T> events = new ArrayList<T>();

    public EventClient(long id) {
        super(id);
    }

    public EventClient(long id, String name, List<T> events) {
        super(id);
        this.name = name;
        this.events = events;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public List<T> getEvents() {
        return events;
    }

    public void setEvents(List<T> events) {
        this.events = events;
    }

    @Nullable
    public T getEvent(long id) {
        for (T event : this.events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public void addEvent(T event) {
        this.events.add(event);
    }

    public void deleteEvent(long id) {
        for (T event : this.events) {
            if (event.getId() == id) {
                events.remove(event);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String eventsSt = "";
        for (T event : events) {
            eventsSt = eventsSt.concat("\n        " + event.toString());
        }

        return "EventClient{\n" +
                "    id=" + getId() +
                ",\n    name='" + name + '\'' +
                ",\n    events={" + eventsSt +
                "\n    }\n}";
    }
}
