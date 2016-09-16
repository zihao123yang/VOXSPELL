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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class DataBase {


    private File _statsFile = new File(".stats.ser");
    private File _failedFile = new File("failedStats.ser");
    private ArrayList<Word> _wordList;
    private ArrayList<Word> _failedList;
    private ArrayList<String> _originalList;

    public DataBase() {
        _wordList = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
        _originalList = new ArrayList<String>();
        importWordList2();

    }

    public void importWordList2() {

        String currentLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader("wordlist"));

            while ((currentLine = br.readLine()) != null) {
                _originalList.add(currentLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sortList() {
        Collections.sort(_wordList);

    }

    public void clearStats() {
        _wordList = new ArrayList<Word>();
        _failedList = new ArrayList<Word>();
    }

    public void save() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(_statsFile);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(_wordList);
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
        _wordList = (ArrayList<Word>) objectIn.readObject();
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
        _wordList.add(word);
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

    public void randomizeOriginalList() {

        long seed = System.nanoTime();
        Collections.shuffle(_originalList, new Random(seed));
    }

    public void randomizefailedList() {

        long seed = System.nanoTime();
        Collections.shuffle(_failedList, new Random(seed));
    }

    public int sizeOfFailed() {
        return _failedList.size();
    }

    public int sizeOfStats() {
        return _wordList.size();
    }

    public String getWordName(int index) {

        return _wordList.get(index).getWord();
    }

    public String getWordOrignal(int index) {
        return _originalList.get(index);
    }

    public Word getWordStatsList(Word word) {

        if (_wordList.contains(word)) {
            int index = _wordList.indexOf(word);
            return _wordList.get(index);
        } else {
            return null;
        }

    }

    public Word getAWord(int index) {
        return _wordList.get(index);
    }

    public Word getFailedWord(int index) {
        return _failedList.get(index);
    }


    public boolean checkWordListContains(Word word) {
        if (_wordList.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void printWordList() {

        for (int i = 0; i < _wordList.size(); i++) {
            System.out.println(_failedList.get(i).getWord());
        }
    }

}
