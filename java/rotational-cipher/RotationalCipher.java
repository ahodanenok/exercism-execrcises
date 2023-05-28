/**
 * Rotational Cipher
 * https://exercism.org/tracks/java/exercises/rotational-cipher
 */
class RotationalCipher {

    private static final int N = 'z' - 'a' + 1;

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder sb = new StringBuilder(data.length());
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(rotate(ch, 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append(rotate(ch, 'A'));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private char rotate(char ch, char base) {
        return (char) (base + (ch - base + shiftKey) % N);
    }
}
