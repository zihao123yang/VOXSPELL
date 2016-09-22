package sample;



import java.io.*;
import java.util.*;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class RevisionQuiz {

    private File _failedFile = new File("failedStats.ser");
    private Map<Integer, ArrayList<Word>> _failedList;
    private int _level;

    private static RevisionQuiz instance = null;



    private RevisionQuiz() {

        _failedList = new HashMap<Integer, ArrayList<Word>>();
        _level = Level.getCurrentlevel();

        if (_failedList == null) {
            _failedList = new HashMap<Integer, ArrayList<Word>>();

        }
    }

    public static RevisionQuiz getInstance() {
        if (instance == null) {
            instance = new RevisionQuiz();
        }

        return instance;
    }





    public void loadFailed() throws IOException, ClassNotFoundException {
        if (!_failedFile.exists()) {
            return;
        }
        FileInputStream fileIn = new FileInputStream(_failedFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        _failedList = (Map<Integer, ArrayList<Word>>) objectIn.readObject();
        fileIn.close();
        objectIn.close();
    }

    public void saveFailed() throws IOException  {
        FileOutputStream fileOut = new FileOutputStream(_failedFile);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_failedList);
        objectOut.close();
        fileOut.close();
    }



    public void addToFailed(Word word) {

        if (_failedList.containsKey(_level)) {
            ArrayList<Word> failedLevelList = _failedList.get(_level);
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

    public void printfailed() {

    }

    public boolean checkAnyWords(int level) {

        if (_failedList.containsKey(level)) {
            return true;
        } else {
            return false;
        }
    }




}
