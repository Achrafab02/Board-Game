package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public class SoftSkillRandomFactory extends SoftSkillFactory {
    private static final int NUMBER_OF_SOFTSKILL = 3;

    @Override
    protected SoftSkill getSoftSkill() {
        int randomNumber = (int) (Math.random() * NUMBER_OF_SOFTSKILL);
        return switch (randomNumber) {
            case 0 -> new Dabbler();
            case 1 -> new Rigorous();
            default -> new Brilliant();
        };
    }
}
