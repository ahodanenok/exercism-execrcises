import java.util.ArrayList;
import java.util.List;

/**
 * Flatten Array
 * https://exercism.org/tracks/java/exercises/flatten-array
 */
public class Flattener {

    public List<?> flatten(List<?> list) {
        List<Object> result = new ArrayList<>();
        flatten(list, result);

        return result;
    }

    private void flatten(List<?> source, List<Object> target) {
        for (Object obj : source) {
            if (obj == null) {
                continue;
            } else if (obj instanceof List) {
                flatten((List<?>) obj, target);
            } else {
                target.add(obj);
            }
        }
    }
}
