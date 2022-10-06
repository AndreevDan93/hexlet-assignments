package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final String filePath;

    public FileKV(String filePath, Map<String, String> inputMap) {
        this.filePath = filePath;
        String inputString = Utils.serialize(inputMap);
        Utils.writeFile(this.filePath, inputString);
    }


    @Override
    public void set(String key, String value) {
        Map<String,String> map = convertJSonToMap();
        map.put(key,value);
        String fileData = Utils.serialize(map);
        Utils.writeFile(this.filePath,fileData);
    }

    @Override
    public void unset(String key) {
        Map<String,String> map = convertJSonToMap();
        map.remove(key);
        String fileData = Utils.serialize(map);
        Utils.writeFile(this.filePath,fileData);
    }


    @Override
    public String get(String key, String defaultValue) {
        Map<String,String> map = convertJSonToMap();
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(convertJSonToMap());
    }

    private Map<String,String> convertJSonToMap (){
        String content = Utils.readFile(this.filePath);
        return new HashMap<>(Utils.unserialize(content));
    }
}
// END
