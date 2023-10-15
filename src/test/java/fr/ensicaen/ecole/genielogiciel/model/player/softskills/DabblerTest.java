package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DabblerTest {
    @Test
    public void test_modify_dice_roll() {
        Dabbler dabbler = new Dabbler();

        int originalRoll = 6;
        int modifiedRoll = dabbler.modifyDiceRoll(originalRoll);

        int expectedModifiedRoll = (int)(originalRoll * dabbler.getModifierValue());
        assertEquals(expectedModifiedRoll, modifiedRoll);
    }

    @Test
    public void test_get_name() {
        Dabbler dabbler = new Dabbler();

        String name = dabbler.getName();
        assertEquals("dabbler", name);
    }

    @Test
    public void test_get_modifier_value() {
        Dabbler dabbler = new Dabbler();

        double modifierValue = dabbler.getModifierValue();
        assertEquals(dabbler.getModifierValue(), modifierValue);
    }
}