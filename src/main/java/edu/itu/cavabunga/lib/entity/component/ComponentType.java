package edu.itu.cavabunga.lib.entity.component;

import edu.itu.cavabunga.lib.entity.Component;

public enum ComponentType {

    Calendar {
        public Component create() {
            return new Calendar();
        }
    },
    Alarm {
        public Component create(){
            return new Alarm();
        }
    },
    Daylight {
        public Component create(){
            return new Daylight();
        }
    },
    Event {
        public Component create() {
            return new Event();
        }
    },
    Freebusy {
        public Component create(){
            return new Freebusy();
        }
    },
    Journal {
        public Component create(){
            return new Journal();
        }
    },
    Standard {
        public Component create(){
            return new Standard();
        }
    },
    Timezone {
        public Component create(){
            return new Timezone();
        }
    },
    Todo {
        public Component create(){
            return new Todo();
        }
    };

    public Component create() {
        return null;
    }
}
