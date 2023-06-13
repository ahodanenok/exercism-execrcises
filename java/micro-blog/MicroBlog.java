import java.util.Arrays;

/**
 * Micro Blog
 * https://exercism.org/tracks/java/exercises/micro-blog
 */
class MicroBlog {

    private static final int MAXLEN = 5;

    public String truncate(String input) {
        int[] buf = new int[MAXLEN];
        int readCount = 0;

        for (int i = 0; i < input.length() && readCount < MAXLEN; ) {
            int cp = input.codePointAt(i);
            buf[readCount++] = cp;
            if (Character.isBmpCodePoint(cp)) {
                i++;
            } else {
                i += 2;
            }
        }

        return new String(buf, 0, readCount);
    }
}
