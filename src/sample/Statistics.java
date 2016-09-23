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


    public Statistics() {
        _numWords = 0;
        _mastered = 0;
        _faulted = 0;
        _failed = 0;
        _wordsTested = 0;
    }

    public void setNumWords(int num) {
        _numWords = num;
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

    /**
     * returns accuarcy as a percentage
     * @return
     */
    public double calculateAccurracy() {


        return Math.round(((double)_mastered)/((double)_wordsTested)*100);
    }

    public boolean levelPassed() {
        if (_mastered >= 9) {
            return true;
        } else {
            return false;
        }

    }
}
