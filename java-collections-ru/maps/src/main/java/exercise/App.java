package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    private static final String DELIMITER = " ";

    public static Map<String, Integer> getWordCount(String text) {
        if (text.isEmpty()) return new HashMap<>();

        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] arrText = text.split(DELIMITER);
        for (String s : arrText) {
            if (wordCountMap.containsKey(s)) {
                wordCountMap.put(s, wordCountMap.get(s) + 1);
            } else {
                wordCountMap.put(s, 1);
            }
        }

        return wordCountMap;
    }

    public static String toString(Map<String, Integer> hashmap) {
        if (hashmap.isEmpty()) return "{}";

        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> map : hashmap.entrySet()) {
            result.append("  ").append(map.getKey()).append(": ").append(map.getValue()).append("\n");
        }
        result.append("}");

        return result.toString();
    }

}
//END
