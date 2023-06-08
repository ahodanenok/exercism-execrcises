/**
 * Reverse String
 * https://exercism.org/tracks/java/exercises/reverse-string
 */
class ReverseString {

    String reverse(String str) {
        char[] chars = new char[str.length()];
        for (int lo = 0, hi = str.length() - 1; lo <= hi; lo++, hi--) {
            chars[lo] = str.charAt(hi);
            chars[hi] = str.charAt(lo);
        }

        return new String(chars);
    }
}
