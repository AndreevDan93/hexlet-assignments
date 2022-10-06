package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String,String>> resultList= new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean isContain = true;
            for (String key : where.keySet()) {
                if (!where.get(key).equals(book.get(key))) {
                    isContain = false;
                    break;
                }
            }
            if (isContain) resultList.add(book);
        }
        return resultList;
    }
}
//END
