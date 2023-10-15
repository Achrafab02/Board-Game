package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrilliantTest {
    @Test
    public void test_modify_dice_roll() {
        Brilliant brilliant = new Brilliant();

        int originalRoll = 6;
        int modifiedRoll = brilliant.modifyDiceRoll(originalRoll);

        int expectedModifiedRoll = (int)(originalRoll * brilliant.getModifierValue());
        assertEquals(expectedModifiedRoll, modifiedRoll);
    }

    @Test
    public void test_get_name() {
        Brilliant brilliant = new Brilliant();

        String name = brilliant.getName();
        assertEquals("brilliant", name);
    }

    @Test
    public void test_get_modifier_value() {
        Brilliant brilliant = new Brilliant();

        double modifierValue = brilliant.getModifierValue();
        assertEquals(brilliant.getModifierValue(), modifierValue);
    }
}
