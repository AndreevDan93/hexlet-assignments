package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag{

    public SingleTag(String name, Map<String, String> attribute) {
        this.attribute = attribute;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
// END
