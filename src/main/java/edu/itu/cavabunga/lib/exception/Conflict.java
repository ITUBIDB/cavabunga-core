package edu.itu.cavabunga.lib.exception;

public class Conflict extends RuntimeException {
    public Conflict(){

    }

    public Conflict(String message){
        super(message);
    }
    public Conflict(Throwable cause){
        super(cause);
    }
}
