package fr.ensicaen.ecole.genielogiciel.model.board.Action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;

public class MoveIfInsufficientSkillLevel implements Action {
    private final Class<? extends HardSkill> _hardSkill;
    private final int _skillCap;
    private final int _moveCount;

    public MoveIfInsufficientSkillLevel(Class<? extends HardSkill> hardSkill, int skillCap, int moveCount) {
        _hardSkill = hardSkill;
        _skillCap = skillCap;
        _moveCount = moveCount;
    }

    @Override
    public void performAction(Player player) {
        if (player.getHardSkillLevel(_hardSkill) < _skillCap) {
            player.moveWithoutTileEffect(_moveCount);
        }
    }
}
