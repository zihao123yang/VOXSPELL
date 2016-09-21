package sample;



import java.util.*;

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


        if (_failedList.containsKey(_level)) {

            ArrayList failedLevel = _failedList.get(_level);
            long seed = System.nanoTime();
            Collections.shuffle(failedLevel, new Random(seed));

            return failedLevel;
        } else {
            return null;
        }
    }

    public void removeFromLevel(Word word) {

        ArrayList<Word> levelList = _failedList.get(_level);

        if (levelList.contains(word)) {
            levelList.remove(word);
        }
    }




}
