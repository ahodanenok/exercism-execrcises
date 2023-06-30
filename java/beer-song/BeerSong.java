/**
 * Beer Song
 * https://exercism.org/tracks/java/exercises/beer-song
 */
public class BeerSong {

    private String DEFAULT_LINE =
        "%s of beer on the wall, %s of beer."
        + "\nTake %s down and pass it around, %s of beer on the wall.";

    private String ZERO_BOTTLES_LINE =
        "No more bottles of beer on the wall, no more bottles of beer."
        + "\nGo to the store and buy some more, 99 bottles of beer on the wall.";

    public String sing(int bottles, int verses) {
        StringBuilder sb = new StringBuilder();
        int bottlesLeft = bottles;
        int versesLeft = verses;
        while (versesLeft > 0 && bottlesLeft > 0) {
            sb.append(String.format(DEFAULT_LINE,
                formatBottles(bottlesLeft),
                formatBottles(bottlesLeft),
                bottlesLeft == 1 ? "it" : "one",
                formatBottles(bottlesLeft - 1)));
            sb.append("\n\n");
            bottlesLeft--;
            versesLeft--;
        }

        if (versesLeft > 0 && bottlesLeft == 0) {
            sb.append(ZERO_BOTTLES_LINE).append("\n\n");
        }

        return sb.toString();
    }

    public String singSong() {
        return sing(99, 100);
    }

    private String formatBottles(int count) {
        if (count > 1) {
            return count + " bottles";
        } else if (count == 1) {
            return "1 bottle";
        } else if (count == 0) {
            return "no more bottles";
        } else {
            throw new IllegalArgumentException("Negative bottles count: " + count);
        }
    }
}
