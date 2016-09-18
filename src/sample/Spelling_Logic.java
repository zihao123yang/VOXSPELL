package sample;

import java.util.ArrayList;

/**
 * Created by zihao123yang on 16/09/16.
 */
public class Spelling_Logic {

    private DataBase _dataBase;
    private ArrayList<String> _wordsToTest;

    private boolean _isNewQuiz;
    private boolean _inputFlag;
    private boolean _repeatFlag;
    private boolean _



    public void setUpQuiz (int level, boolean newQuiz) {
        _inputFlag = true;
        _repeatFlag = false;
        ArrayList<Word> wordlist;

        if (newQuiz == true) {
            wordlist = _dataBase.makeQuizList(level);
        } else {
            // temporary, revision quiz logic not completed- revision quiz for each level?
            wordlist = new ArrayList<Word>();

        }




    }


    public void spellingQuiz() {

        if (_inputFlag == true) {

        }

    }







}
