package sample;

import java.io.*;

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

    public static void callFestival2(String sayThis) {
        String cmd = "festival -b festival.scm";


        String fileText = "sed -i '2i\\anything' textpath";
        ProcessBuilder setFile = new ProcessBuilder("/bin/bash", )

    }


    public static void writeSayThis(String sayThis) {

        try {

            File file = new File("festival.scm");

            if (!file.exists()) {

                file.createNewFile();
            }

            String currentVoice = currentVoice();
            deleteFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(currentVoice);
            bw.newLine();
            bw.write(sayThis);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String currentVoice() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("festival.scm"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String voice = null;
        try {
            voice = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return voice;

    }


    public static void deleteFile() {

        File file = new File("festival.scm");
        file.delete();
    }






}
