package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.schooling.AST;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModifySkillLevelTest {
    @Test
     public void test_modify_skill() {
        String playerName = "ME";
        String schoolingName = "ast";
        Player player = new AST().createPlayer(playerName, schoolingName);
        System.out.println(" computerScienceLevel " + player.getComputerScienceLevel());
        ModifySkillLevel modifySkillLevel = new ModifySkillLevel(ComputerScience.class, 6);
        modifySkillLevel.performAction(player);
        assertEquals("10", player.getComputerScienceLevel());

     }

}