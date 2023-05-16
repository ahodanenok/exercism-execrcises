import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Gigasecond
 * https://exercism.org/tracks/java/exercises/gigasecond
 */
public class Gigasecond {

    private static final long GIGASECOND = 1_000_000_000;

    private final LocalDateTime value;

    public Gigasecond(LocalDate moment) {
        this(moment.atTime(0, 0));
    }

    public Gigasecond(LocalDateTime moment) {
        value = moment.plusSeconds(GIGASECOND);
    }

    public LocalDateTime getDateTime() {
        return value;
    }
}
