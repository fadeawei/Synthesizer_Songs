package com.example.per2.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHa;
    private Button buttonHbb;
    private Button buttonHb;
    private Button buttonHc;
    private Button buttonHcs;
    private Button buttonHd;
    private Button buttonHds;
    private Button buttonHe;
    private Button buttonHf;
    private Button buttonHfs;
    private Button buttonHg;
    private Button buttonHgs;
    private Map<Integer, Integer> noteMap;

    private Button buttonScale;
    private Button xxxchanges;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHa;
    private int noteHbb;
    private int noteHb;
    private int noteHc;
    private int noteHcs;
    private int noteHd;
    private int noteHds;
    private int noteHe;
    private int noteHf;
    private int noteHfs;
    private int noteHg;
    private int noteHgs;

    private Handler handler;


    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final int WHOLE_NOTE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        wirewidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_ha, noteHa);
        noteMap.put(R.id.button_synth_hbb, noteHbb);
        noteMap.put(R.id.button_synth_hb, noteHb);
        noteMap.put(R.id.button_synth_hc, noteHc);
        noteMap.put(R.id.button_synth_hcs, noteHcs);
        noteMap.put(R.id.button_synth_hd, noteHd);
        noteMap.put(R.id.button_synth_hds, noteHds);
        noteMap.put(R.id.button_synth_he, noteHe);
        noteMap.put(R.id.button_synth_hf, noteHf);
        noteMap.put(R.id.button_synth_hfs, noteHfs);
        noteMap.put(R.id.button_synth_hg, noteHg);
        noteMap.put(R.id.button_synth_hgs, noteHgs);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);
        noteHa = soundPool.load(this, R.raw.scalehigha, 1);
        noteHbb = soundPool.load(this, R.raw.scalehighbb, 1);
        noteHb = soundPool.load(this, R.raw.scalehighb, 1);
        noteHc = soundPool.load(this, R.raw.scalehighc, 1);
        noteHcs = soundPool.load(this, R.raw.scalehighcs, 1);
        noteHd = soundPool.load(this, R.raw.scalehighd, 1);
        noteHds = soundPool.load(this, R.raw.scalehighds, 1);
        noteHe = soundPool.load(this, R.raw.scalehighe, 1);
        noteHf = soundPool.load(this, R.raw.scalehighf, 1);
        noteHfs = soundPool.load(this, R.raw.scalehighfs, 1);
        noteHg = soundPool.load(this, R.raw.scalehighg, 1);
        noteHgs = soundPool.load(this, R.raw.scalehighgs, 1);


    }

    private void setListeners() {
        keyboardNoteListener noteListener = new keyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonHa.setOnClickListener(noteListener);
        buttonHbb.setOnClickListener(noteListener);
        buttonHb.setOnClickListener(noteListener);
        buttonHc.setOnClickListener(noteListener);
        buttonHcs.setOnClickListener(noteListener);
        buttonHd.setOnClickListener(noteListener);
        buttonHds.setOnClickListener(noteListener);
        buttonHe.setOnClickListener(noteListener);
        buttonHf.setOnClickListener(noteListener);
        buttonHfs.setOnClickListener(noteListener);
        buttonHg.setOnClickListener(noteListener);
        buttonHgs.setOnClickListener(noteListener);
        buttonScale.setOnClickListener(this);
        xxxchanges.setOnClickListener(this);
    }

    private void wirewidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonHa = findViewById(R.id.button_synth_ha);
        buttonHbb = findViewById(R.id.button_synth_hbb);
        buttonHb = findViewById(R.id.button_synth_hb);
        buttonHc = findViewById(R.id.button_synth_hc);
        buttonHcs = findViewById(R.id.button_synth_hcs);
        buttonHd = findViewById(R.id.button_synth_hd);
        buttonHds = findViewById(R.id.button_synth_hds);
        buttonHe = findViewById(R.id.button_synth_he);
        buttonHf = findViewById(R.id.button_synth_hf);
        buttonHfs = findViewById(R.id.button_synth_hfs);
        buttonHg = findViewById(R.id.button_synth_hg);
        buttonHgs = findViewById(R.id.button_synth_hgs);
        buttonScale = findViewById(R.id.button_main_scale);
        xxxchanges = findViewById(R.id.button_main_xxx);

    }

    @Override
    public void onClick(View view) {
        // one method to handle clicks of all buttons
        // but dont't forget to tell the buttons who is doing
        // the listening
        switch (view.getId()){
//            case R.id.button_synth_a:
//                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_bb:
//                Toast.makeText(this, "Bb", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteBb, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_b:
//                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteB, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_c:
//                Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteC, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_cs:
//                Toast.makeText(this, "Cs", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteCs, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_d:
//                Toast.makeText(this, "D", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteD, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_ds:
//                Toast.makeText(this, "Ds", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteDs, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_e:
//                Toast.makeText(this, "E", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteE, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_f:
//                Toast.makeText(this, "F", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteF, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_fs:
//                Toast.makeText(this, "Fs", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteFs, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_g:
//                Toast.makeText(this, "G", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteG, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_gs:
//                Toast.makeText(this, "Gs", Toast.LENGTH_SHORT).show();
//                soundPool.play(noteGs, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
            case R.id.button_main_scale:
                playScale();
                break;
            case R.id.button_main_xxx:
                playxScale();
                break;

        }
    }


    private void playScale(){
        Song scale = new Song();
        scale.add(new Note(noteBb, 1000));
        scale.add(new Note(noteBb, 1000));
        scale.add(new Note(noteF, 1000));
        scale.add(new Note(noteF,1000));
        scale.add(new Note(noteG,1000));
        scale.add(new Note(noteG,1000));
        scale.add(new Note(noteF, 1500));
        scale.add(new Note(noteDs,1000));
        scale.add(new Note(noteDs, 1000));
        scale.add(new Note(noteD, 1000));
        scale.add(new Note(noteD, 1000));
        scale.add(new Note(noteC,1000));
        scale.add(new Note(noteC, 1000));
        scale.add(new Note(noteBb, 1000));

        playSong(scale);

//        List <Note> notes = new ArrayList<>();
//        notes.add(new Note(noteA));
//        notes.add(new Note(noteBb));
//        notes.add(new Note(noteB));
//
//        for (Note n: notes){
//            playNote(n);
//            delay(n.getDelay());
//        }



//        playNote(noteA);
//        delay(WHOLE_NOTE);
//        playNote(noteBb);
//        delay(WHOLE_NOTE);
//        playNote(noteB);

    }
    private void playxScale() {
        Song scale = new Song();
        Note chord1 = new Note(new ArrayList<Integer>(), 1000);
        chord1.add(noteE);
        chord1.add(noteHb);
        scale.add(chord1);
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        Note chord2 = new Note(new ArrayList<Integer>(), 1000);
        chord2.add(noteCs);
        chord2.add(noteHb);
        scale.add(chord2);
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        Note chord3 = new Note(new ArrayList<Integer>(), 1000);
        chord3.add(noteGs);
        chord3.add(noteHb);
        scale.add(chord3);
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        scale.add(new Note(noteHb, 1000));
        scale.add(chord3);
        scale.add(new Note(noteHb, 500));
        scale.add(new Note(noteB, 500));
        scale.add(new Note(noteHb, 500));
        scale.add(new Note(noteB, 250));
        scale.add(new Note(noteB, 250));
        scale.add(new Note(noteDs, 300));
        scale.add(new Note(noteCs, 250));
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteBb, 250));
        for(int i = 0; i < 2; i++) {
        Note chord4 = new Note(new ArrayList<Integer>(), 250);
        chord4.add(noteHb);
        chord4.add(noteE);
        chord4.add(noteB);
        for (int e = 0; e < 2; e++) {
            scale.add(chord4);
            scale.add(new Note(noteB, 300));
            scale.add(new Note(noteHb, 300));
            scale.add(new Note(noteB, 300));
            Note chord5 = new Note(new ArrayList<Integer>(), 300);
            chord5.add(noteHb);
            chord5.add(noteB);
            scale.add(chord5);
            scale.add(new Note(noteCs, 300));
            scale.add(chord5);
            scale.add(new Note(noteBb, 300));
        }
        Note chord6 = new Note(new ArrayList<Integer>(), 300);
        chord6.add(noteHb);
        chord6.add(noteGs);
        chord6.add(noteB);
        scale.add(chord6);
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 150));
        scale.add(new Note(noteB, 150));
        Note chord5 = new Note(new ArrayList<Integer>(), 300);
        chord5.add(noteHb);
        chord5.add(noteB);
        scale.add(chord5);
        scale.add(new Note(noteCs, 300));
        scale.add(chord5);
        scale.add(new Note(noteBb, 300));
        scale.add(chord6);
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 250));
        scale.add(new Note(noteB, 250));
            Note chord8 = new Note(new ArrayList<Integer>(), 300);
            chord8.add(noteDs);
            chord8.add(noteHb);
            scale.add(chord8);
        scale.add(new Note(noteCs, 250));
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteBb, 250));
    }
        Note chord4 = new Note(new ArrayList<Integer>(), 250);
        chord4.add(noteHb);
        chord4.add(noteE);
        chord4.add(noteB);
        for (int e = 0; e < 2; e++) {
            scale.add(chord4);
            scale.add(new Note(noteB, 300));
            scale.add(new Note(noteHb, 300));
            scale.add(new Note(noteB, 300));
            Note chord5 = new Note(new ArrayList<Integer>(), 300);
            chord5.add(noteHb);
            chord5.add(noteB);
            scale.add(chord5);
            scale.add(new Note(noteCs, 300));
            scale.add(chord5);
            scale.add(new Note(noteBb, 300));
        }
        Note chord6 = new Note(new ArrayList<Integer>(), 300);
        chord6.add(noteHb);
        chord6.add(noteGs);
        chord6.add(noteB);
        scale.add(chord6);
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 150));
        scale.add(new Note(noteB, 150));
        Note chord5 = new Note(new ArrayList<Integer>(), 300);
        chord5.add(noteHb);
        chord5.add(noteB);
        scale.add(chord5);
        scale.add(new Note(noteCs, 300));
        scale.add(chord5);
        scale.add(new Note(noteBb, 300));
        scale.add(chord6);
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteHb, 300));
        scale.add(new Note(noteB, 250));
        scale.add(new Note(noteB, 250));
        scale.add(new Note(noteDs, 250));
        scale.add(new Note(noteCs, 250));
        scale.add(new Note(noteB, 300));
        scale.add(new Note(noteBb, 250));






        scheduleSongs(500, scale.getNotes().toArray(new Note[scale.getNotes().size()]));

    }
    private Song getSong1() {
        Song scale1 = new Song();
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));//add notes to your song
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        scale1.add(new Note(noteHb, 1000));
        return scale1;
    }

    private Song getSong2() {
        Song scale2 = new Song();
        scale2.add(new Note(noteE, 4000));
        scale2.add(new Note(noteCs, 4000));
        scale2.add(new Note(noteGs, 4000));
        scale2.add(new Note(noteGs, 1500));
        scale2.add(new Note(noteHb, 1000));
        scale2.add(new Note(noteHb, 250));
        scale2.add(new Note(noteHb, 250));
        scale2.add(new Note(noteHds, 300));
        scale2.add(new Note(noteHcs, 250));
        scale2.add(new Note(noteHb, 300));
        scale2.add(new Note(noteHbb, 500));
        return scale2;
    }

    private void scheduleSongs(long startDelay, Note[]... songs) {
        //the start delay makes sure all tasks are scheduled before songs are played
        long base = SystemClock.uptimeMillis() + startDelay;
        for (Note[] song: songs) {
            //delay accumulates as the song plays
            long delay = 0;
            for (final Note note: song) {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        for(int noteId: note.returnList()) {
                            soundPool.play(noteId, 1f, 1f, 1, 0, 1f);
                        }
                    }
                }, base + delay); //schedule the note to play at the sum of the uptime and the delay
                delay = delay + note.getDelay();
            }
        }
    }

    private void playSong(Song song) {
        for (Note note: song.getNotes()){
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void playNote(Note n) {
        for(int i = 0; i < n.size(); i++) {
            playNote(n.getNoteIds(i), 0);
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private class keyboardNoteListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int note = noteMap.get(id);
            playNote(note);
        }
    }
}
