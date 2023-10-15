package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ModifySkillLevelTest {

    @Test
    public void test_perform_action() {
        Class<? extends HardSkill> skillClass = Mathematics.class;
        int levelIncrease = 2;
        ModifySkillLevel modifySkillLevel = new ModifySkillLevel(skillClass, levelIncrease);
        Player player = mock(Player.class);

        modifySkillLevel.performAction(player);

        verify(player).addToLevelOfHardSkill(skillClass, levelIncrease);
    }
}
