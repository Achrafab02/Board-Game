package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Dabbler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DabblerTest {
    private static final int NUMBER_OF_TEST = 10;
    @Test
    void test_modify_dice_roll() {
        Dabbler dabbler = new Dabbler();
        RandomDice randomDice = new RandomDice();
        for(int i = 0; i < NUMBER_OF_TEST; i++){
            int randomValue = randomDice.roll();
            assertEquals(randomValue / 2,dabbler.modifyDiceRoll(randomValue));
        }
    }
}
