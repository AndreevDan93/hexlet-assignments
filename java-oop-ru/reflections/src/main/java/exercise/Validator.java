package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator{

    static List<String> validate(Address address) {
        List<String> list = new ArrayList<>();
        for (Field field: address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                if (notNull != null) {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        list.add(field.getName());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
// END
