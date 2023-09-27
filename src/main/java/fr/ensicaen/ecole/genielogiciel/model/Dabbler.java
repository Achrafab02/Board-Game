package fr.ensicaen.ecole.genielogiciel.model;

class Dabbler extends SoftSkill {

    @Override
    int modifyDiceRoll(int roll) {
        return roll / 2;
    }
}
