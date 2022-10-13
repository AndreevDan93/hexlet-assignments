package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private final String content;
    List<Tag> children;
    public PairedTag(String name, Map<String,String> attribute, String content, List<Tag> children) {
        this.attribute = attribute;
        this.name = name;
        this.content = content;
        this.children = children;
    }

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
        builder.append(content);
        if (!children.isEmpty()) {
            for (Tag tag: children) {
                builder.append(tag.toString());
            }
        }
        builder.append("</").append(name).append(">");
        return builder.toString();
    }
}
// END
//Tag div = new PairedTag(
//        "div",
//        Map.of("class", "y-5"),
//        "",
//        List.of(
//                new SingleTag("br", Map.of("id", "s")),
//                new SingleTag("hr", Map.of("class", "a-5"))
//        )
//)
//
//div.toString(); // "<div class="y5"><br id="s"><hr class="a5"></div>"
