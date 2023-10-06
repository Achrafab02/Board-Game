package fr.ensicaen.ecole.genielogiciel.model;

public class Dabbler implements SoftSkill {
    private final double DICE_MODIFIER_FACTOR = 0.5;

    @Override
    public int modifyDiceRoll(int roll) {
        return ((int) (roll * DICE_MODIFIER_FACTOR));
    }
}
