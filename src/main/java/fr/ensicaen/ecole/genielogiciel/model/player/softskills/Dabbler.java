package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public class Dabbler implements SoftSkill {
    private static final double DABBLER_MODIFIER = 0.5;

    public int modifyDiceRoll(int roll) {
        return (int)(roll * DABBLER_MODIFIER);
    }

    public String getName() {
        return "dabbler";
    }

    public double getModifierValue() {
        return DABBLER_MODIFIER;
    }
}
