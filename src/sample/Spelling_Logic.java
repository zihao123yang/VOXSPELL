package sample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zihao123yang on 16/09/16.
 */
public class Spelling_Logic {

    private DataBase _dataBase;
    private ArrayList<String> _wordList;

    private boolean _isNewQuiz;
    private boolean _inputFlag;
    private boolean _repeatFlag;
    private int _position;
    private int _numWords;

    private SpellingQuizController _quizController;


    public Spelling_Logic() {

        _dataBase = new DataBase();
    }



    public void setUpQuiz (int level, boolean newQuiz) {
        _inputFlag = false;
        _repeatFlag = false;

        if (newQuiz == true) {
            _wordList = _dataBase.makeQuizList(level);
        } else {
            // temporary, revision quiz logic not completed- revision quiz for each level?
            _wordList = new ArrayList<String>();

        }

        System.out.println(_wordList.size());
        _numWords = 10;

        _position = 0;

    }


    public void spellingQuiz(String input) {

        // this is only for debug purpose, GUI hasnt been implemented yet

        if (_inputFlag == false) {


            //festival call
            // "Please spell the word " + _wordList.get(_position) +" . " + _wordList.get(_position)
            System.out.println("Spell word: " + _wordList.get(_position));
            _inputFlag = true;
            return;


        }

        if (_repeatFlag == false) {

            if (_wordList.get(_position).equals(input)) {
                // festival call - correct!
                System.out.println("correct!");

            } else {

                System.out.println("incorrect, try again");

                _repeatFlag = true;
                return;
            }

        }

        if (_repeatFlag == true) {

            if (_wordList.get(_position).equals(input)) {
                System.out.println("correct!");
            } else {
                System.out.println("incorrect");
            }
        }

        _repeatFlag = false;
        _position++;

        if (_position < _numWords ) {
            System.out.println("Spell word: " + _wordList.get(_position));
            return;
        } else {
            System.out.println("Quiz finished");
        }


    }







}
