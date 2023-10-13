package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDiceBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomDiceTest {
    @Test
    void test_random_dice() {
        long seed = 0;
        RandomDice d1 = new RandomDiceBuilder().withSeed(seed).build();
        RandomDice d2 = new RandomDiceBuilder().withSeed(seed).build();
        for (int i = 0; i < 100; i++) {
            assertEquals(d1.roll(), d2.roll());
        }
    }

    @Test
    void test_random_dice_seed_min_max_interval() {
        int lowerInterval = 4;
        int upperInterval = 10;
        int seed = 15;
        RandomDice randomDice = new RandomDiceBuilder()
                .withSeed(seed)
                .withInterval(lowerInterval, upperInterval)
                .build();
        for (int i = 0; i < 20; i++) {
            assertDiceRollIsInInterval(lowerInterval, upperInterval, randomDice.roll());
        }
    }

    @Test
    void test_random_dice_min_max_interval() {
        int lowerInterval = 4;
        int upperInterval = 10;
        RandomDice randomDice = new RandomDiceBuilder()
                .withInterval(lowerInterval, upperInterval)
                .build();        for (int i = 0; i < 20; i++) {
            assertDiceRollIsInInterval(lowerInterval, upperInterval, randomDice.roll());
        }
    }

    private static void assertDiceRollIsInInterval(int lowerInterval, int upperInterval, int roll) {
        assertTrue(lowerInterval <= roll && roll <= upperInterval);
    }

    @Test
    void test_cannot_create_dice_with_empty_interval() {
        assertThrows(IllegalArgumentException.class, () -> new RandomDiceBuilder().withInterval(9, 2).build());
    }
}
