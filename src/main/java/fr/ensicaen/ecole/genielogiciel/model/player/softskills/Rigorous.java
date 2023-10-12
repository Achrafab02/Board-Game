package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public class Rigorous implements SoftSkill {
    private static final double RIGOROUS_MODIFIER = 1;

    public int modifyDiceRoll(int roll) {
        return (int)(roll * RIGOROUS_MODIFIER);
    }

    public String getName() {
        return "rigorous";
    }
}
