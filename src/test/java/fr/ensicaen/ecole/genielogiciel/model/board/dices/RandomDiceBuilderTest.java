package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomDiceBuilderTest {

    @Test
    public void test_build_with_defaults() {
        RandomDiceBuilder builder = new RandomDiceBuilder();
        RandomDice dice = builder.build();

        assertNotNull(dice);
    }

    @Test
    public void test_build_with_interval() {
        int lower = 2;
        int upper = 8;
        RandomDiceBuilder builder = new RandomDiceBuilder().withInterval(lower, upper);
        RandomDice dice = builder.build();

        assertNotNull(dice);

        assertTrue(dice.roll() >= lower && dice.roll() <= upper);
    }
}
