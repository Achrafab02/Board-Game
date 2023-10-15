package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveIfInsufficientSkillLevelTest {

    @Test
    public void test_perform_action_with_sufficient_skill_level() {
        Class<? extends HardSkill> skillClass = Mathematics.class;
        int skillCap = 5;
        int moveCount = 2;
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(skillClass, skillCap, moveCount);
        Player player = mock(Player.class);

        when(player.getHardSkillLevel(skillClass)).thenReturn(skillCap);

        moveIfInsufficientSkillLevel.performAction(player);

        verify(player, never()).moveWithoutTileEffect(moveCount);
    }

    @Test
    public void test_perform_action_with_insufficient_skill_level() {
        Class<? extends HardSkill> skillClass = ComputerScience.class;
        int skillCap = 5;
        int moveCount = 2;
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(skillClass, skillCap, moveCount);
        Player player = mock(Player.class);

        when(player.getHardSkillLevel(skillClass)).thenReturn(skillCap - 1);

        moveIfInsufficientSkillLevel.performAction(player);

        verify(player).moveWithoutTileEffect(moveCount);
    }
}
