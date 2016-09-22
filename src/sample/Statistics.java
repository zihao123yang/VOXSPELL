package sample;

import javafx.scene.layout.Pane;

/**
 * Created by eli on 21/09/16.
 */
public class Statistics {

    int _numWords;
    int _mastered;
    int _faulted;
    int _failed;
    int _wordsTested;
    DataBase _db;

    public Statistics(int numWords) {
        _numWords = numWords;
        _mastered = 0;
        _faulted = 0;
        _failed = 0;
        _wordsTested = 0;
    }

    public void increaseMastered() {
        _mastered++;
        _wordsTested++;
    }

    public void increaseFaulted() {
        _faulted++;
        _wordsTested++;
    }

    public void increaseFailed() {
        _failed++;
        _wordsTested++;
    }

    public double calculateAccurracy() {
        return _mastered/_wordsTested;
    }

    public boolean levelPassed() {
        if (_mastered >= 9) {
            return true;
        } else {
            return false;
        }
    }
}
