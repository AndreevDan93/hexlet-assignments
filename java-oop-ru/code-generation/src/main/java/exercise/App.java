package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        String data = car.serialize();
        Files.writeString(path, data);
    }

    public static Car extract(Path path) throws IOException {
        String data = Files.readString(path);
        return Car.unserialize(data);
    }
}
// END
