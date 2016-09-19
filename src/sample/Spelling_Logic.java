package sample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zihao123yang on 16/09/16.
 */
public class Spelling_Logic {

    private DataBase _dataBase;
    private ArrayList<Word> _wordList;

    private boolean _isNewQuiz;
    private boolean _inputFlag;
    private boolean _repeatFlag;
    private int _position;




    public void setUpQuiz (int level, boolean newQuiz) {
        _inputFlag = true;
        _repeatFlag = false;

        if (newQuiz == true) {
            _wordList = _dataBase.makeQuizList(level);
        } else {
            // temporary, revision quiz logic not completed- revision quiz for each level?
            _wordList = new ArrayList<Word>();

        }

        _position = 0;


    }


    public void spellingQuiz() {

        // this is only for debug purpose, GUI hasnt been implemented yet
        Scanner userInput = new Scanner(System.in);

        if (_inputFlag == true) {


            //festival call
            // "Please spell the word " + _wordList.get(_position) +" . " + _wordList.get(_position)
            System.out.println("Spell word " + (_position + 1) + " out of " + _position + ": ");


        }

    }







}
