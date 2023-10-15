package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RigorousTest {
    @Test
    public void test_modify_dice_roll() {
        Rigorous rigorous = new Rigorous();

        int originalRoll = 6;
        int modifiedRoll = rigorous.modifyDiceRoll(originalRoll);

        int expectedModifiedRoll = (int)(originalRoll * rigorous.getModifierValue());
        assertEquals(expectedModifiedRoll, modifiedRoll);
    }

    @Test
    public void test_get_name() {
        Rigorous rigorous = new Rigorous();

        String name = rigorous.getName();
        assertEquals("rigorous", name);
    }

    @Test
    public void test_get_modifier_value() {
        Rigorous rigorous = new Rigorous();

        double modifierValue = rigorous.getModifierValue();
        assertEquals(rigorous.getModifierValue(), modifierValue);
    }
}