package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    String name;
    Map<String, String> attribute;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(name);
        if (attribute != null) {
            for (Map.Entry<?, ?> entry : ((Map<?, ?>) attribute).entrySet()) {
                builder.append(" ")
                        .append(entry.getKey())
                        .append("=\"")
                        .append(entry.getValue())
                        .append("\"");
            }
            builder.append(">");

        }
        return builder.toString();
    }
}

// END
