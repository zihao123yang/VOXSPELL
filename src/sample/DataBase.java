package sample;

/**
 * Created by zihao123yang on 16/09/16.
 */

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class DataBase {

    private static DataBase instance = null;

    private File _statsFile = new File("stats.ser");
    private File _failedFile = new File("failedStats.ser");
    private ArrayList<Word> _storedStats;
    private ArrayList<Word> _failedList;
    //private ArrayList<String> _wordList;

    private Map<Integer, ArrayList<String>> _wordList;


    private DataBase() {
        _storedStats = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
        //_wordList = new ArrayList<String>();

        if (_wordList == null) {
            _wordList = new HashMap<Integer, ArrayList<String>>();
            importWordList();
        }
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }

        return instance;
    }




    public void saveStats() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(_statsFile);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_storedStats);
        fileOut.close();
        objectOut.close();
        /*
        fileOut = new FileOutputStream(_failedFile);
        objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_failedList);
        objectOut.close();
        fileOut.close();
        */
    }


    public void loadStats() throws IOException, ClassNotFoundException {
        if (!_statsFile.exists()) {
            return;
        }
        FileInputStream fileIn = new FileInputStream(_statsFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        _storedStats = (ArrayList<Word>) objectIn.readObject();
        fileIn.close();
        objectIn.close();
    }


    public void loadFailed() throws IOException, ClassNotFoundException {
        if (!_failedFile.exists()) {
            return;
        }
        FileInputStream fileIn = new FileInputStream(_failedFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        _failedList = (ArrayList<Word>) objectIn.readObject();
        fileIn.close();
        objectIn.close();
    }


    public void importWordList() {

        String currentLine;
        int level = 1;
        ArrayList<String> levelList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("NZCER-spelling-lists.txt"));

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.charAt(0) == '%') {

                    levelList = new ArrayList<String>();
                    if (level < 11 && level > 0) {
                        _wordList.put(level, levelList);
                    }
                    level++;
                } else {
                    levelList.add(currentLine);
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> makeQuizList(int level) {
//        System.out.println("entering method");
//        int lowerBound = _wordList.indexOf(Integer.toString(level));
//        System.out.println("lowerBound: "+ lowerBound);
//        int upperBound = _wordList.indexOf(level++);
//        System.out.println("upperBound: " + upperBound);
//        int size = upperBound - (lowerBound + 1);
//        ArrayList<String> levelList = new ArrayList<String>();
//        ArrayList<String> newQuiz = new ArrayList<String>();
//
//        for (int i = lowerBound  + 1; i < upperBound; i++) {
//            levelList.add(_wordList.get(i));


        ArrayList<String> levelList = _wordList.get(level);
        int size = levelList.size();
        randomizeList(levelList);

/*
        //--------------------------------------------------------
        for  (int debug = 0; debug < levelList.size(); debug++) {
            System.out.print(levelList.get(debug) + " ");
        }
        System.out.println();
        //--------------------------------------------------------


        randomizeList(levelList);


        //--------------------------------------------------------
        for  (int debug = 0; debug < levelList.size(); debug++) {
            System.out.print(levelList.get(debug) + " ");
        }
        System.out.println();
        //--------------------------------------------------------

*/

        if (level > 10) {
            return null;
        } else if (size >= 10) {
            return new ArrayList<String> (levelList.subList(0, 10));

        } else {
            return levelList;
        }

        // debug statements
        // levelList debug


    }



    public void sortList() {
        Collections.sort(_storedStats);

    }


    public void clearStats() {
        _storedStats = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
    }


    public void addToWordList(Word word) {

        _storedStats.add(word);
    }


    public void addToFailedList(Word word) {
        if (!_failedList.contains(word)) {
            _failedList.add(word);
        }
    }


    public void removeFromFailedList(Word word) {
        if (_failedList.contains(word)) {
            _failedList.remove(word);
        }
    }


    public void randomizeList(ArrayList<String> list) {

        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
    }


    public void randomizefailedList() {

        long seed = System.nanoTime();
        Collections.shuffle(_failedList, new Random(seed));
    }


    public int sizeOfFailed() {

        return _failedList.size();
    }


    public int sizeOfStats() {

        return _storedStats.size();
    }

    public void printSavedFIles() {


        for (int i = 0; i < _storedStats.size(); i++) {

        }



        for (int i =0; i < _failedList.size(); i++) {

        }

    }

    public boolean wordSeen(Word word) {
        if (_storedStats.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    public Word getWordStatsList(Word word) {


        if (_storedStats.contains(word)) {
            int index = _storedStats.indexOf(word);
            return _storedStats.get(index);
        } else {
            return word;
        }
    }

    public ArrayList<Word> getStoredStats(){
        return _storedStats;
    }

}
