package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class Dabbler implements SoftSkill {

    @Override
    public int modifyDiceRoll(int roll) {
        return roll / 2;
    }
}