package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomDiceTest {

    @Test
    public void test_roll_within_interval() {
        int lower = 1;
        int upper = 6;
        Random randomGenerator = new Random(123);
        RandomDice dice = new RandomDice(randomGenerator, lower, upper);

        int result = dice.roll();

        assertTrue(result >= lower && result <= upper);
    }

    @Test
    public void test_constructor_with_invalid_interval() {
        int lower = 6;
        int upper = 1;
        assertThrows(IllegalArgumentException.class, () -> new RandomDice(new Random(), lower, upper));
    }
}
