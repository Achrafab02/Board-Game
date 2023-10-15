package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomDiceTest {

    @Test
    public void test_roll_within_interval() {
        int lower = 10;
        int upper = 15;
        Random randomGenerator = new Random(123);
        RandomDice dice = new RandomDice(randomGenerator, lower, upper);

        for (int i = 0; i < 10; i++) {
            int result = dice.roll();
            assertTrue(lower <= result && result <= upper);
        }
    }

    @Test
    public void test_constructor_with_invalid_interval() {
        int lower = 6;
        int upper = 1;
        assertThrows(IllegalArgumentException.class, () -> new RandomDice(new Random(), lower, upper));
    }
}
