package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zihao123yang on 16/09/16.
 */
public class Spelling_Logic {

    private DataBase _dataBase;
    private ArrayList<String> _wordList;
    private Statistics _stats;
    private RevisionQuiz _revisionData;

    public static boolean _isNewQuiz;
    private boolean _inputFlag;
    private boolean _repeatFlag;
    private int _position;
    private int _numWords;
    private Word _word;



    public Spelling_Logic() {

        _dataBase = DataBase.getInstance();
        _revisionData = RevisionQuiz.getInstance();
        _wordList = new ArrayList<String>();
    }


    public void setUpQuiz () {
        _inputFlag = false;
        _repeatFlag = false;


        if (_isNewQuiz == true) {

            _wordList = _dataBase.makeQuizList(Level.getCurrentlevel());
        } else {

            ArrayList<Word> preparationList = _revisionData.levelListForRevise();

            if (preparationList == null) {

                //go to next scene

            } else if (preparationList.size() < 10) {

                for (int i = 0; i < preparationList.size(); i++) {
                    _wordList.add(preparationList.get(i).name());
                }

            } else if (preparationList.size() >= 10) {

                for (int i = 0; i < 10; i++) {
                    _wordList.add(preparationList.get(i).name());
                }
            }

        }

        System.out.println(_wordList.size());

        _numWords = _wordList.size();

        _position = 0;

        _stats = new Statistics(_wordList.size());

    }


    public void spellingQuiz(String input) {

        // this is only for debug purpose, GUI hasn't been implemented yet

        if (_inputFlag == false) {

            _word = new Word(_wordList.get(_position),Level.getCurrentlevel());

            Festival.callFestival("Please spell the word " + _wordList.get(_position) +" ... " + _wordList.get(_position));
            System.out.println("Spell word: " + _wordList.get(_position));
            _inputFlag = true;
            return;


        }

        if (_repeatFlag == false) {

            _word = new Word(_wordList.get(_position), Level.getCurrentlevel());
            if (_wordList.get(_position).toLowerCase().trim().equals(input.toLowerCase().trim())) {

                Festival.callFestival("Correct, well done");

                System.out.println("correct! hello");

                if (!_isNewQuiz) {
                    _revisionData.removeFromLevel(_word);
                }

                if (_dataBase.wordSeen(_word)) {
                    _word = _dataBase.getWordStatsList(_word);
                    _word.addMastered();
                } else {
                    _word.addMastered();
                    _dataBase.addToWordList(_word);
                }

                _stats.increaseMastered();

            } else {

                Festival.callFestival("Incorrect! Please try again. " + _wordList.get(_position) + "... " + _wordList.get(_position));
                System.out.println("incorrect, try again");

                _repeatFlag = true;
                return;
            }

        }

        if (_repeatFlag == true) {

            _word = new Word(_wordList.get(_position), Level.getCurrentlevel());
            if (_wordList.get(_position).toLowerCase().trim().equals(input.toLowerCase().trim())) {
                Festival.callFestival("Correct");
                System.out.println("correct!");

                if (!_isNewQuiz) {
                    _revisionData.removeFromLevel(_word);
                }

                if (_dataBase.wordSeen(_word)) {
                    _word = _dataBase.getWordStatsList(_word);
                    _word.addFaulted();
                } else {
                    _word.addFaulted();
                    _dataBase.addToWordList(_word);
                }

                _stats.increaseFaulted();

            } else {
                Festival.callFestival("Incorrect...");
                System.out.println("incorrect");



                _revisionData.addToFailed(_word);

                if (_dataBase.wordSeen(_word)) {
                    _word = _dataBase.getWordStatsList(_word);
                    _word.addFailed();
                } else {
                    _word.addFailed();
                    _dataBase.addToWordList(_word);
                }

               // _revisionData.addToFailed(word);
                _stats.increaseFailed();


            }
        }

        _repeatFlag = false;
        _position++;

        System.out.println("position: " + _position + "    numwords: " + _numWords);
        if (_position < _numWords ) {
            _word = new Word(_wordList.get(_position), Level.getCurrentlevel());
            Festival.callFestival("Please spell the word " + _wordList.get(_position) +" ... " + _wordList.get(_position));
            System.out.println("Spell word: " + _wordList.get(_position));
            return;
        } else {
            System.out.println("Quiz finished");

            if (Level.getCurrentlevel() <= 10) {
                if (_stats.levelPassed()) {
                    levelComplete();
                } else {
                    levelFailed();
                }
            }
        }

    }

    public String currentWord() {
        return _word.name();
    }

    public int whichIteration() {
        if (_repeatFlag) {
            return 2;
        } else {
            return 1;
        }
    }

    public boolean spellingCorrect(String input) {
        if (_wordList.get(_position).toLowerCase().trim().equals(input.toLowerCase().trim())) {
            return true;
        } else {
            return false;
        }
    }

    public void levelComplete()  {
        Stage stage = Main.getPrimaryStage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("LevelComplete.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Level.nextlevelUnlocked();

        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void levelFailed() {
        Stage stage = Main.getPrimaryStage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("LevelFailed.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
