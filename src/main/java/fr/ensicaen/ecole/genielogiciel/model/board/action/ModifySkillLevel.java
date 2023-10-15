package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;

public class ModifySkillLevel implements Action {
    private final Class<? extends HardSkill> _hardSkill;
    private final int _levelIncrease;

    public ModifySkillLevel(Class<? extends HardSkill> hardSkill, int levelIncrease) {
        _hardSkill = hardSkill;
        _levelIncrease = levelIncrease;

    }

    @Override
    public void performAction(Player player) {
        player.addToLevelOfHardSkill(_hardSkill, _levelIncrease);
    }

    public Class<? extends HardSkill> getHardSkillClass() {
        return _hardSkill;
    }

    public int getLevelIncrease() {
        return _levelIncrease;
    }
}
