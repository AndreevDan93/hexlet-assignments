package exercise;


import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    private static final String ENVIRONMENT_COMMAND = "environment=";
    private static final String SEARCH_PREFIX = "X_FORWARDED_";
    private static final String DELIMITER = ",";
    private static final String EMPTY_SPACE = "";

    public static String getForwardedVariables(String confText) {
        return Arrays.stream(confText.split("\n"))
                .filter(element -> element.startsWith(ENVIRONMENT_COMMAND))
                .map(element -> element.replace(ENVIRONMENT_COMMAND, EMPTY_SPACE)
                        .replace("\"", EMPTY_SPACE)
                        .trim())
                .flatMap(element -> Arrays.stream(element.split(DELIMITER))
                        .filter(item -> item.startsWith(SEARCH_PREFIX))
                        .map(item -> item.replace(SEARCH_PREFIX, EMPTY_SPACE)))
                .collect(Collectors.joining(DELIMITER));
    }

}
//END
