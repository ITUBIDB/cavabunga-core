package tr.edu.itu.cavabunga.lib.entity.participant;

import tr.edu.itu.cavabunga.lib.entity.Participant;

public enum ParticipantType {
    User {
        public Participant create(){
            return new User();
        }
    },
    Group {
        public Participant create(){
            return new Group();
        }
    },
    Resource {
        public Participant create(){ return new Resource(); }
    }
    ;

    public Participant create() { return null; }
}
