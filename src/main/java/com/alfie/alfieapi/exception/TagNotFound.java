package com.alfie.alfieapi.exception;

public class TagNotFound extends Exception {
    public TagNotFound(String tag) {
        super(String.format("Tag %s not found", tag));
    }

}
