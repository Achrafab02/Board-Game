package fr.ensicaen.ecole.genielogiciel.model;

public class Brilliant implements SoftSkill {
    private final float FACTOR = 2;
    @Override
    public int modifyDiceRoll(int roll) {
        return (int) (roll * FACTOR);
    }
}