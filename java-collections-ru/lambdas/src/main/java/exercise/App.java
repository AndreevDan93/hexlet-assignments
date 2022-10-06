package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(array -> Arrays.stream(array)
                        .flatMap(element -> Stream.of(element, element))
                        .toArray(String[]::new))
                .flatMap(newArray -> Stream.of(newArray, newArray))
                .toArray(String[][]::new);
    }

}
// END
