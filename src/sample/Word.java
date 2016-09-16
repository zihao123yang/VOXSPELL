package sample;

import java.io.Serializable;

/**
 * Created by zihao123yang on 16/09/16.
 */
public class Word implements Serializable, Comparable<Word> {

    private static final long serialVersionUID = 1L;
    String _word;
    int _numMastered;
    int _numFaulted;
    int _numFailed;
    int _level;


    public Word(String word, int level) {
        _word = word;
        _level = level;
    }

    public void addMastered() {
        _numMastered++;
    }

    public void addFaulted() {
        _numFaulted++;
    }

    public void addFailed() {
        _numFailed++;
    }

    public String getWord() {
        return _word;
    }

    @Override
    public int compareTo(Word o) {
        return _word.compareTo(o._word);
    }



}

