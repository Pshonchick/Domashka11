import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private final static String path = "C://GoIT//FileZadanie.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, String> word = new HashMap<>();
        word.put("line", "NoChanges");
        word.put("Line", "NewLine");
    System.out.println(replacer(word));
      fileContentMerger(word);
  //      System.out.println(checkWord("Line"));
    }


    private static String replacer(Map<String, String> map) {
        String stringFile = "";
        String stroka = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((stringFile = bufferedReader.readLine()) != null) {
                stroka += stringFile + "\n";
            }
            for (String s : map.keySet()) {
                String key = s;
                stroka = stroka.replaceAll(key, map.get(key));
            }

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(stroka);
            fileWriter.flush();

            bufferedReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stroka;
    }

    private static File fileContentMerger(Map<String, String> map) throws IOException {

        String stringFile = "";
        String stroka = "";
        String stringOld = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((stringFile = bufferedReader.readLine()) != null) {
                stringOld += stringFile + "\n";
                stroka += stringFile + "\n";
            }
            for (String s : map.keySet()) {
                String key = s;
                stroka = stroka.replaceAll(key, map.get(key));
            }

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(stringOld);
            fileWriter.write(stroka);
            fileWriter.flush();

            bufferedReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    private static int checkWord(String word) {
        String stringFile = "";
        String stroka = "";
        int count = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((stringFile = bufferedReader.readLine()) != null) {

                for (String s : stringFile.split(" ")) {
                    if (s.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
