package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public class Brilliant implements SoftSkill {
    @Override
    public int modifyDiceRoll(int roll) {
        return roll * 2;
    }

    @Override
    public String getName() {
        return "brilliant";
    }
}
