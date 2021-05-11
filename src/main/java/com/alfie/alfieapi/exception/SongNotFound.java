package com.alfie.alfieapi.exception;

public class SongNotFound extends Exception {
    public SongNotFound(String id) {
        super(String.format("Song not found with id{%s}", id));
    }
}
