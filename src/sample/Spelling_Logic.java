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

    private boolean _isNewQuiz;
    private boolean _inputFlag;
    private boolean _repeatFlag;
    private int _position;
    private int _numWords;





    public Spelling_Logic() {

        _dataBase = DataBase.getInstance();
    }



    public void setUpQuiz (boolean newQuiz) {
        _inputFlag = false;
        _repeatFlag = false;

        if (newQuiz == true) {
            _wordList = _dataBase.makeQuizList(Level.getCurrentlevel());
        } else {

            _dataBase.randomizefailedList();

            int size = _dataBase.sizeOfFailed();

            if
            // temporary, revision quiz logic not completed- revision quiz for each level?
            _wordList = new ArrayList<String>();
        }

        System.out.println(_wordList.size());
        _numWords = 10;

        _position = 0;

        _stats = new Statistics(_wordList.size());

    }


    public void spellingQuiz(String input) {

        // this is only for debug purpose, GUI hasnt been implemented yet

        if (_inputFlag == false) {


            //festival call
            // "Please spell the word " + _wordList.get(_position) +" . " + _wordList.get(_position)
//            Festival.callFestival("Please spell the word " + _wordList.get(_position) +" ... " + _wordList.get(_position));
            System.out.println("Spell word: " + _wordList.get(_position));
            _inputFlag = true;
            return;


        }

        if (_repeatFlag == false) {

            Word word = new Word(_wordList.get(_position), Level.getCurrentlevel());
            if (_wordList.get(_position).equals(input)) {
                // festival call - correct!
//                Festival.callFestival("Correct.");
//                Festival.callFestival("...");

                System.out.println("correct! this");

                if (!_isNewQuiz) {

                }

                if (_dataBase.wordSeen(word)) {
                    word = _dataBase.getWordStatsList(word);
                    word.addMastered();
                } else {
                    word.addMastered();
                    _dataBase.addToWordList(word);
                }

                _stats.increaseMastered();

            } else {

//                Festival.callFestival("Incorrect! Please try again" + _wordList.get(_position) + "... " + _wordList.get(_position));
                System.out.println("incorrect, try again");

                _repeatFlag = true;
                return;
            }

        }

        if (_repeatFlag == true) {

            Word word = new Word(_wordList.get(_position), Level.getCurrentlevel());
            if (_wordList.get(_position).equals(input)) {
//                Festival.callFestival("Correct...");
                System.out.println("correct!");

                if (!_isNewQuiz) {

                }

                if (_dataBase.wordSeen(word)) {
                    word = _dataBase.getWordStatsList(word);
                    word.addFaulted();
                } else {
                    word.addFaulted();
                    _dataBase.addToWordList(word);
                }

                _stats.increaseFaulted();

            } else {
//                Festival.callFestival("Incorrect...");
                System.out.println("incorrect");

                if (!_isNewQuiz) {

                }

                if (_dataBase.wordSeen(word)) {
                    word = _dataBase.getWordStatsList(word);
                    word.addFailed();
                } else {
                    word.addFailed();
                    _dataBase.addToWordList(word);
                }

                _dataBase.addToFailedList(word);
                _stats.increaseFailed();


            }
        }

        _repeatFlag = false;
        _position++;

        if (_position < _numWords ) {
//            Festival.callFestival("Please spell the word " + _wordList.get(_position) +" ... " + _wordList.get(_position));
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
            } else {

            }


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
