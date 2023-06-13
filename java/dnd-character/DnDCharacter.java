import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * D&D Character
 * https://exercism.org/tracks/java/exercises/dnd-character
 */
class DnDCharacter {

    private final Random DICE_1 = new Random();
    private final Random DICE_2 = new Random();
    private final Random DICE_3 = new Random();
    private final Random DICE_4 = new Random();

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
    }

    int ability(List<Integer> scores) {
        return scores.stream().reduce(0, Integer::sum) - Collections.min(scores);
    }

    List<Integer> rollDice() {
        return List.of(roll(DICE_1), roll(DICE_2), roll(DICE_3), roll(DICE_4));
    }

    private int roll(Random dice) {
        return 1 + dice.nextInt(6);
    }

    int modifier(int input) {
        return Math.floorDiv((input - 10), 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return modifier(constitution) + 10;
    }
}
