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
    DataBase _db = DataBase.getInstance();


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

    public double calculateLevelAccuracy(int level) {

        int numMasteredOnLevel = 0;
        int wordsAppearedOnLevel = 0;



        for(Word word : _db.getStoredStats()){
            if(word.getLevel() == level){

                wordsAppearedOnLevel += word.getNumFailed() + word.getNumFaulted() + word.getNumMastered();
                numMasteredOnLevel += word.getNumMastered();
            }
        }

        System.out.println("num mastered" + numMasteredOnLevel);
        System.out.println("words appeared on lvl" + wordsAppearedOnLevel);

        if (wordsAppearedOnLevel == 0){
            System.out.println("User has not attempted quiz for this level");
            return 100.0;
        }

        return Math.round(((double)numMasteredOnLevel)/((double)wordsAppearedOnLevel)*100);

    }

}
