package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public class Brilliant implements SoftSkill {
    private static final double BRILLIANT_MODIFIER = 2.0;

    public int modifyDiceRoll(int roll) {
        return (int)(roll * BRILLIANT_MODIFIER);
    }

    public String getName() {
        return "brilliant";
    }
}
