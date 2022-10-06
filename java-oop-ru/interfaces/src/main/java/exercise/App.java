package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List buildAppartmentsList(List<Home> list, int n) {
        return list.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(n)
                .map(Home::toString)
                .collect(Collectors.toList());
    }

}
// END
