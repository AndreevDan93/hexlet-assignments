package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    String attribute;
    Object value;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<" + attribute);
        if (value instanceof String) {
            builder.append("=\"" + this.value + "\"");
        }
        if (value instanceof Map<?, ?>) {
            for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
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
