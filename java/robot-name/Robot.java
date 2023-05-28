import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Robot Name
 * https://exercism.org/tracks/java/exercises/robot-name
 */
public class Robot {

    private static final int N = 'Z' - 'A' + 1;
    private static final Random RANDOM = new Random();
    private static final Set<String> USED_NAMES = new HashSet<>();

    private static String generateName(String previousName) {
        while (true) {
            String name = ""
                + (char) ('A' + RANDOM.nextInt(N))
                + (char) ('A' + RANDOM.nextInt(N))
                + RANDOM.nextInt(1000);

            if (!USED_NAMES.add(name)) {
                continue;
            }
            USED_NAMES.remove(previousName);

            return name;
        }
    }

    private String name;

    public Robot() {
        name = generateName(null);
    }

    public String getName() {
        return name;
    }

    public void reset() {
        name = generateName(name);
    }
}
