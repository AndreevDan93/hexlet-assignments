package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> symbolsList = getListFromText(symbols);
        List<String> wordList = getListFromText(word);

        for (String s : wordList) {
            if (symbolsList.contains(s)) {
                symbolsList.remove(s);
            } else {
                return false;
            }
        }

        return true;
    }

    private static ArrayList<String> getListFromText(String text) {
        return new ArrayList<>(Arrays.asList(text.toLowerCase().split("")));
    }
}
//END
