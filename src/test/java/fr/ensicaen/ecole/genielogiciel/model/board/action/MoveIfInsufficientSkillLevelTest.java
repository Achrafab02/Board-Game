package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.MoveIfInsufficientSkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.schooling.AST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveIfInsufficientSkillLevelTest {
    @Test
    public void test_modify_skill_with_insufficient_level() {
        String playerName = "ME";
        String schoolingName = "ast";
        Player player = new AST().createPlayer(playerName, schoolingName);
        System.out.println(" computerScienceLevel " + player.getComputerScienceLevel());
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(ComputerScience.class, 8, -2);
        moveIfInsufficientSkillLevel.performAction(player);
        assertEquals(-2, player.getPosition());
    }

    @Test
    public void test_modify_skill_with_sufficient_level() {
        String playerName = "ME";
        String schoolingName = "ast";
        Player player = new AST().createPlayer(playerName, schoolingName);
        System.out.println(" computerScienceLevel " + player.getComputerScienceLevel());
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(ComputerScience.class, 3, 2);
        moveIfInsufficientSkillLevel.performAction(player);
        assertEquals(0, player.getPosition());
    }
}