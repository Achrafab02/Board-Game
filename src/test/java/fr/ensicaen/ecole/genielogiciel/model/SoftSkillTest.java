package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDiceBuilder;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Brilliant;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Dabbler;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Rigorous;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoftSkillTest {
    private static final int NUMBER_OF_TESTS = 10;

    @Test
    void test_dabbler() {
        Dabbler dabbler = new Dabbler();
        RandomDice randomDice = new RandomDiceBuilder().build();
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            int randomValue = randomDice.roll();
            assertEquals(randomValue / 2, dabbler.modifyDiceRoll(randomValue));
        }
    }

    @Test
    void test_rigorous() {
        Rigorous rigorous = new Rigorous();
        RandomDice randomDice = new RandomDiceBuilder().build();
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            int randomValue = randomDice.roll();
            assertEquals(randomValue, rigorous.modifyDiceRoll(randomValue));
        }
    }

    @Test
    void test_brilliant() {
        Brilliant brilliant = new Brilliant();
        RandomDice randomDice = new RandomDiceBuilder().build();
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            int randomValue = randomDice.roll();
            assertEquals(randomValue * 2, brilliant.modifyDiceRoll(randomValue));
        }
    }
}
