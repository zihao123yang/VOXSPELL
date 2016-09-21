package sample;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class RevisionQuiz {


    private Map<Integer, ArrayList<Word>> _failedList;
    private int _level;

    public RevisionQuiz() {
        _failedList = new HashMap<Integer, ArrayList<Word>>();
        _level = Level.getCurrentlevel();
    }

    public void addToFailed(Word word) {

        if (_failedList.containsKey(_level)) {
            ArrayList<Word> failedLevelList =  _failedList.get(_level);
            if (!failedLevelList.contains(word)) {
                failedLevelList.add(word);

            }
        } else {
            ArrayList<Word> failedLevelList = new ArrayList<Word>();
            failedLevelList.add(word);
            _failedList.put(_level, failedLevelList);
        }

    }

    public ArrayList<Word> levelListForRevise() {
        
    }
}
