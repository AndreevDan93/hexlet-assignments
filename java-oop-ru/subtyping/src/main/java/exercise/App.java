package exercise;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage obKVS) {
        Map<String,String> inputMap = obKVS.toMap();
        for (Entry<String,String> entry: obKVS.toMap().entrySet()) {
            obKVS.unset(entry.getKey());
        }
        for (Entry<String,String> entry : inputMap.entrySet()) {
            obKVS.set(entry.getValue(),entry.getKey());
        }
    }
}
// END
