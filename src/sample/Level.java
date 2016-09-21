package sample;

/**
 * Created by zihao123yang on 21/09/16.
 */
public class Level {

    private static int _currentLevel;

    public static void setLevel(int level) {

        _currentLevel = level;
    }

    public static int getCurrentlevel() {
        return _currentLevel;
    }
}
