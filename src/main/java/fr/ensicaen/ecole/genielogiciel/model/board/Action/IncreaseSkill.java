package fr.ensicaen.ecole.genielogiciel.model.board.Action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;

public class IncreaseSkill implements Action {
    private final HardSkill _hardSkill;
    private final int _levelIncrease;

    public IncreaseSkill(HardSkill hardSkill, int levelIncrease) {
        _hardSkill = hardSkill;
        _levelIncrease = levelIncrease;

    }

    @Override
    public void performAction(Player player) {
        //player.addToLevelOfHardSkill(_hardSkill, _levelIncrease);
    }
}
