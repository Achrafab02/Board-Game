package fr.ensicaen.ecole.genielogiciel.model.softskills;

public class Rigorous implements SoftSkill {
    @Override
    public int modifyDiceRoll(int roll) {
        return roll;
    }
}
