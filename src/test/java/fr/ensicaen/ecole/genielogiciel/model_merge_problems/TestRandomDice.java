package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestRandomDice {
    @Test
    void test_random_dice() {
        long fixedSeed = 0;
        RandomDice d1 = new RandomDice(fixedSeed);
        RandomDice d2 = new RandomDice(fixedSeed);
        for (int i = 0; i < 100; i++) {
            assertEquals(d1.roll(), d2.roll());
        }
    }
}
