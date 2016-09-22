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

    public Statistics(int numWords, DataBase db) {
        _numWords = numWords;
        _mastered = 0;
        _faulted = 0;
        _failed = 0;
        _wordsTested = 0;
        _db = db;
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

    public String printStatistics(int levelToDisplay){

        StringBuilder sb = new StringBuilder();

        int timesAppeared;

        for(Word word : _db.getStoredStats()){

            // if the level the user specifies is equal to the level of the current word
            if(word.getLevel() == levelToDisplay){

                timesAppeared = word.getNumMastered() + word.getNumFaulted() + word.getNumFailed();

                sb.append(word.toString() + "\n");
                sb.append("\n");
                sb.append("    Times appeared: " + timesAppeared + "\n");
                sb.append("    Times mastered: " + word.getNumMastered() + "\n");
                sb.append("    Times faulted:  " + word.getNumFaulted() + "\n");
                sb.append("    Times failed:   " + word.getNumFailed() + "\n");
                sb.append("\n");

            }

        }

        return sb.toString();

    }
}
