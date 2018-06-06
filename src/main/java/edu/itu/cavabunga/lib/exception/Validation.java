package edu.itu.cavabunga.lib.exception;

public class Validation extends RuntimeException {
    public Validation(){

    }

    public Validation(String message) { super(message); }
    public Validation(Throwable cause) { super(cause); }
}
