package fr.ensicaen.ecole.genielogiciel.model;

public class Brilliant extends SoftSkill {
    @Override
    int modifyDiceRoll(int roll) {
        return roll * 2;
    }
}
