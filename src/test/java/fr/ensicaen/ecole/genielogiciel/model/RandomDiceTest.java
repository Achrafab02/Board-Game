package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomDiceTest {
    @Test
    void test_random_dice() {
        long fixedSeed = 0;
        RandomDice d1 = new RandomDice(fixedSeed);
        RandomDice d2 = new RandomDice(fixedSeed);
        for (int i = 0; i < 100; i++) {
            assertEquals(d1.roll(), d2.roll());
        }
    }

    @Test
    void test_random_dice_seed_min_max_interval() {
        int lowerInterval = 4;
        int upperInterval = 10;
        int seed = 15;
        RandomDice randomDice = new RandomDice(seed, lowerInterval, upperInterval);
        for (int i = 0; i < 20; i++) {
            assertDiceRollIsInInterval(lowerInterval, upperInterval, randomDice.roll());
        }
    }

    @Test
    void test_random_dice_min_max_interval() {
        int lowerInterval = 4;
        int upperInterval = 10;
        RandomDice randomDice = new RandomDice(lowerInterval, upperInterval);
        for (int i = 0; i < 20; i++) {
            assertDiceRollIsInInterval(lowerInterval, upperInterval, randomDice.roll());
        }
    }

    private static void assertDiceRollIsInInterval(int lowerInterval, int upperInterval, int roll) {
        assertTrue(lowerInterval <= roll && roll <= upperInterval);
    }
}
