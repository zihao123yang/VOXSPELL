package sample;

/**
 * Created by zihao123yang on 21/09/16.
 */
public class Level {

    private static int _levelUnlocked = 0;
    private static int _currentLevel = 0;

    public static void setLevel(int level) {

        _currentLevel = level;
    }

    public static int getCurrentlevel() {

        return _currentLevel;
    }

    public static void setUnlockedlevel(int level) {

        _levelUnlocked = level;
    }

    public static int getUnlockedlevel() {

        return _levelUnlocked;
    }

    public static void nextlevelUnlocked() {

        if (_levelUnlocked < 10) {
            _levelUnlocked++;
        }
    }

    public static void nextLevel() {
        _currentLevel++;
        _levelUnlocked++;
    }


}
