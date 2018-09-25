package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;

public enum ParameterType {
    Altrep {
        public Parameter create() {
            return new Altrep();
        }
    },
    Cn {
        public Parameter create() {
            return new Cn();
        }
    },
    Cutype {
        public Parameter create() {
            return new Cutype();
        }
    },
    DelegatedFrom {
        public Parameter create() {
            return new DelegatedFrom();
        }
    },
    DelegatedTo {
        public Parameter create() {
            return new DelegatedTo();
        }
    },
    Dir {
        public Parameter create() {
            return new Dir();
        }
    },
    Encoding {
        public Parameter create() {
            return new Encoding();
        }
    },
    Fbtype {
        public Parameter create() {
            return new Fbtype();
        }
    },
    Member {
        public Parameter create() {
            return new Member();
        }
    },
    Partstat {
        public Parameter create() {
            return new Partstat();
        }
    },
    Range {
        public Parameter create() {
            return new Range();
        }
    },
    Related {
        public Parameter create() {
            return new Related();
        }
    },
    Reltype {
        public Parameter create() {
            return new Reltype();
        }
    },
    Role {
        public Parameter create() {
            return new Role();
        }
    },
    Rsvp {
        public Parameter create() {
            return new Rsvp();
        }
    },
    SentBy {
        public Parameter create() {
            return new SentBy();
        }
    },
    Tzid {
        public Parameter create() {
            return new Tzid();
        }
    },
    Value {
        public Parameter create() {
            return new Value();
        }
    };

    public Parameter create() {
        return null;
    }
}
