import java.util.ArrayList;
import java.util.List;

/**
 * Diamond
 * https://exercism.org/tracks/java/exercises/diamond
 */
class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> lines = new ArrayList<>();

        int offset = a - 'A';
        char[] buf = new char[offset * 2 + 1];
        for (int i = offset; i >= 0; i--) {
            lines.add(printLine(a, i, buf));
        }
        for (int i = offset - 1; i >= 0; i--) {
            lines.add(lines.get(i));
        }

        return lines;
    }

    private String printLine(char ch, int offset, char[] buf) {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = ' ';
        }

        buf[offset] = (char) (ch - offset);
        buf[buf.length - offset - 1] = (char) (ch - offset);

        return new String(buf);
    }
}
