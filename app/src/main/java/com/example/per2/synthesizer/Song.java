package com.example.per2.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private List<Note> notes;
    private List<Integer> delays;

    public Song() {
        notes = new ArrayList<>();
    }

    public void add(Note note){
        notes.add(note);
    }

    public Song(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
