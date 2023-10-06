package fr.ensicaen.ecole.genielogiciel.model;

public class Brilliant implements SoftSkill {
    private final double DICE_MODIFIER_FACTOR = 2;
    @Override
    public int modifyDiceRoll(int roll) {
        return (int) (roll * DICE_MODIFIER_FACTOR);
    }
}