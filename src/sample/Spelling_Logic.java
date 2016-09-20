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

        _position = 0;

    }


    public void spellingQuiz(String input) {

        // this is only for debug purpose, GUI hasnt been implemented yet
        Scanner userInput = new Scanner(System.in);

        if (_inputFlag == false) {


            //festival call
            // "Please spell the word " + _wordList.get(_position) +" . " + _wordList.get(_position)
            System.out.println(_wordList.get(_position));
            _quizController.setDisplay("Spell word " + (_position + 1) + " out of " + _position + ": ");
            _inputFlag = true;
            return;


        }

        if (_repeatFlag == false) {

            _quizController.setDisplay(input);

            if (_wordList.get(_position).equals(input)) {
                // festival call - correct!
                _quizController.setDisplay("Correct!");
            }

        }

    }







}
