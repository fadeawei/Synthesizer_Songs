package com.example.per2.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private List<Integer> noteIds;
    private int delay;
    public static final int WHOLE_NOTE = 1000;

    public Note(List<Integer> notes, int delay) {
        this.noteIds = notes;
        this.delay = delay;
    }

    public Note(int noteId) {
        this.noteIds = new ArrayList<>();
        noteIds.add(noteId);
        this.delay= WHOLE_NOTE;

    }

    public Note(int note, int delay) {
        this.noteIds = new ArrayList<>();
        noteIds.add(note);
        this.delay = delay;
    }

    public void add(int noteId){
        noteIds.add(noteId);
    }

    public int getNoteIds(int i) {
        return noteIds.get(i);
    }

    public List<Integer> returnList(){
        return noteIds;
    }

    public int size(){
        return noteIds.size();
    }

    public void setNoteIds(List<Integer> noteIds) {
        this.noteIds = noteIds;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteIds +
                ", delay=" +  +
                '}';
    }
}
