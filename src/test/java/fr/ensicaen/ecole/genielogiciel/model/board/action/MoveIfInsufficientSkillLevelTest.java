package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.AST;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.Prepa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveIfInsufficientSkillLevelTest {
    @Test
    public void test_modify_skill_with_insufficient_level() {
        Player player = new AST().createPlayer("", "");
        player.setPosition(5);
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(ComputerScience.class, 8, -2);
        moveIfInsufficientSkillLevel.performAction(player);
        assertEquals(5-2, player.getPosition());
    }

    @Test
    public void test_modify_skill_with_sufficient_level() {
        Player player = new Prepa().createPlayer("", "")
        player.setPosition(5);
        MoveIfInsufficientSkillLevel moveIfInsufficientSkillLevel = new MoveIfInsufficientSkillLevel(ComputerScience.class, 8, -2);
        moveIfInsufficientSkillLevel.performAction(player);
        assertEquals(5-2, player.getPosition());
    }
}