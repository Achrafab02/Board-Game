package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicDiceTest {

    @Test
    public void test_roll_with_default_value() {
        DeterministicDice dice = new DeterministicDice();
        int result = dice.roll();

        assertEquals(2, result);
    }

    @Test
    public void test_roll_with_custom_value() {
        int customValue = 5;
        DeterministicDice dice = new DeterministicDice(customValue);
        int result = dice.roll();

        assertEquals(customValue, result);
    }
}
