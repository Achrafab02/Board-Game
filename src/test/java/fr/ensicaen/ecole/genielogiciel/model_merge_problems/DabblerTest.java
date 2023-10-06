package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DabblerTest {
    private final int number_of_test = 10;
    @Test
    void test_modify_dice_roll() {
        Dabbler dabbler = new Dabbler();
        RandomDice randomDice = new RandomDice();
        for(int i = 0; i < number_of_test; i++){
            int randomValue = randomDice.roll();
            assertEquals(randomValue / 2,dabbler.modifyDiceRoll(randomValue));
        }
    }
}
