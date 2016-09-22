package sample;

/**
 * Created by zihao123yang on 22/09/16.
 */
public class DisplayingStats {

    DataBase _db = DataBase.getInstance();

    /**
     * returns a string representation of the users stats, to be displayed in the view stats scene.
     * @param levelToDisplay
     * @return
     */

    public String printStatistics(int levelToDisplay){

        StringBuilder sb = new StringBuilder();

        int timesAppeared;

        for(Word word : _db.getStoredStats()){

            // if the level the user specifies is equal to the level of the current word
            if(word.getLevel() == levelToDisplay){

                timesAppeared = word.getNumMastered() + word.getNumFaulted() + word.getNumFailed();

                sb.append(word.toString() + "\n");
                sb.append("\n");
                sb.append("    Times appeared: " + timesAppeared + "\n");
                sb.append("    Times mastered: " + word.getNumMastered() + "\n");
                sb.append("    Times faulted:  " + word.getNumFaulted() + "\n");
                sb.append("    Times failed:   " + word.getNumFailed() + "\n");
                sb.append("\n");

            }

        }

        return sb.toString();

    }
}
