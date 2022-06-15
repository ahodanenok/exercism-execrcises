import java.util.ArrayList;
import java.util.List;

/**
 * Karl's Languages
 * https://exercism.org/tracks/java/exercises/karls-languages
 */
public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return count() == 0;
    }

    public void addLanguage(String language) {
        if (!containsLanguage(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public String firstLanguage() {
        if (isEmpty()) {
            return null;
        }

        return languages.get(0);
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.indexOf(language) >= 0;
    }

    public boolean isExciting() {
        return containsLanguage("Java") || containsLanguage("Kotlin");
    }
}
