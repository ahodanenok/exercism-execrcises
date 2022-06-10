/**
 * Log Levels
 * https://exercism.org/tracks/java/exercises/log-levels
 */
public class LogLevels {

    private static final String LOG_MESSAGE_SEPARATOR = "]:";

    public static String message(String logLine) {
        int logMessageSeparatorIdx = logLine.indexOf(LOG_MESSAGE_SEPARATOR);
        String logMessage = logLine.substring(
            logMessageSeparatorIdx + LOG_MESSAGE_SEPARATOR.length());

        return logMessage.trim();
    }

    public static String logLevel(String logLine) {
        int logMessageSeparatorIdx = logLine.indexOf(LOG_MESSAGE_SEPARATOR);
        // skip initial "["
        String logLevel = logLine.substring(1, logMessageSeparatorIdx);

        return logLevel.toLowerCase();
    }

    public static String reformat(String logLine) {
        String logLevel = logLevel(logLine);
        String logMessage = message(logLine);

        return String.format("%s (%s)", logMessage, logLevel);
    }
}
