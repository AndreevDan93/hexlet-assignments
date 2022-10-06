package exercise;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

// BEGIN
class App {
    private static final String KEY_IN_ALL_VALUES_IDENTICAL = "unchanged";
    private static final String KEY_IN_ALL_VALUES_DIFFERENT = "changed";
    private static final String KEY_IN_1ST_ONLY = "deleted";
    private static final String KEY_IN_2ST_ONLY = "added";


    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keysSet = new TreeSet<>();
        LinkedHashMap<String, String> resultLinkMap = new LinkedHashMap<>();
        keysSet.addAll(map1.keySet());
        keysSet.addAll(map2.keySet());
        for (String key : keysSet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                resultLinkMap.put(key, KEY_IN_1ST_ONLY);
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                resultLinkMap.put(key, KEY_IN_2ST_ONLY);
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    resultLinkMap.put(key, KEY_IN_ALL_VALUES_IDENTICAL);
                } else {
                    resultLinkMap.put(key, KEY_IN_ALL_VALUES_DIFFERENT);
                }
            }
        }
        return resultLinkMap;

    }
}
