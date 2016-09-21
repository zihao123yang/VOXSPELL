package sample;

/**
 * Created by zihao123yang on 21/09/16.
 */
public class Festival {

    public static void callFestival(String sayThis) {
        String cmd = "echo " + sayThis + " | festival --tts";
        ProcessBuilder speakWord = new ProcessBuilder("/bin/bash", "-c", cmd);
        try{
            @SuppressWarnings("unused")
            Process speakWordProcess = speakWord.start();
        } catch (Exception e){}
    }


}
