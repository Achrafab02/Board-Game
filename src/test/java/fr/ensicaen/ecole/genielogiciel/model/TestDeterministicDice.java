package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDeterministicDice {
    @Test
    void test_deterministic_dice() {
        DeterministicDice d = new DeterministicDice();
        assertEquals(2, d.roll());
        assertNotEquals(3, d.roll());
    }

    @Test
    void test_initiated_deterministic_dice() {
        int init_value = 12;
        DeterministicDice dice = new DeterministicDice(init_value);
        assertEquals(init_value, dice.roll());
        assertNotEquals(init_value + 1, dice.roll());
    }
}
