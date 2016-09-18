package sample;

/**
 * Created by zihao123yang on 16/09/16.
 */

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


    private File _statsFile = new File(".stats.ser");
    private File _failedFile = new File("failedStats.ser");
    private ArrayList<Word> _wordListOld;
    private ArrayList<Word> _failedList;
    //private ArrayList<String> _wordList;


    private Map<Integer, ArrayList<Word>> _wordList;


    public DataBase() {
        _wordListOld = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
        //_wordList = new ArrayList<String>();

        if (_wordList == null) {
            _wordList = new HashMap<Integer, ArrayList<Word>>();
            importWordList();
        }


    }

    public void importWordList() {
        String currentLine;
        int level = 1;
        ArrayList<Word> levelList = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("NZCER-spelling-lists.txt"));

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.charAt(0) == '%') {
                    level = currentLine.charAt(1);
                    levelList = new ArrayList<Word>();
                    if (level < 11) {
                        _wordList.put(level - 1, levelList);
                    }
                } else {
                    levelList.add(new Word(currentLine, level));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Word> makeQuizList(int level) {
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


        ArrayList<Word> levelList = _wordList.get(level);
        int size = levelList.size();

        randomizeList(levelList);

        if (level > 10) {
            System.out.println("no more levels");
        } else if (size >= 10) {
            return (ArrayList<Word>) levelList.subList(0, 9);

        } else {
            return levelList;
        }

        // debug statements
        // levelList debug
        for  (int debug = 0; debug < levelList.size(); debug++) {
            System.out.print(levelList.get(debug) + " ");
        }
        System.out.println();

    }



    public void sortList() {
        Collections.sort(_wordListOld);

    }


    public void clearStats() {
        _wordListOld = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
    }


    public void save() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(_statsFile);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_wordListOld);
        fileOut.close();
        objectOut.close();
        fileOut = new FileOutputStream(_failedFile);
        objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_failedList);
        objectOut.close();
        fileOut.close();
    }


    public void loadStats() throws IOException, ClassNotFoundException {
        if (!_statsFile.exists()) {
            return;
        }
        FileInputStream fileIn = new FileInputStream(_statsFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        _wordListOld = (ArrayList<Word>) objectIn.readObject();
        fileIn.close();
        objectIn.close();
    }


    public void loadFailed() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(_failedFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        _failedList = (ArrayList<Word>) objectIn.readObject();
        fileIn.close();
        objectIn.close();
    }


    public void addToWordList(Word word) {

        _wordListOld.add(word);
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


    public void randomizeList(ArrayList<Word> list) {

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

        return _wordListOld.size();
    }

    public void printOriginal() {
        for (int i = 0; i < _wordList.size(); i++) {
            System.out.print(_wordList.get(i) + " ");
        }
        System.out.println();
    }


}
