package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class Brilliant implements SoftSkill {
    @Override
    public int modifyDiceRoll(int roll) {
        return roll * 2;
    }
}
