package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.schooling.AST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileMathClassTest {
    @Test
    public void test_tile_math_class_level_on_a_ast_player() {
        String playerName = "ME";
        String schoolingName = "ast";
        int intialMathematicsLevel = 0;
        Player player = new AST().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileMathClass tileComputerScienceClass = new TileMathClass(positionIndex, tilePoint);
        Action modifySkillLevel = tileComputerScienceClass.fetchInstruction(player);
        modifySkillLevel.performAction(player);
        assertEquals(intialMathematicsLevel + 1 ,player.getHardSkillLevel(Mathematics.class));
    }
    /*@Test
    public void test_tile_computer_science_class_level_on_a_prepa_player() {
        String playerName = "ME";
        String schoolingName = "prepa";
        int intialMathematicsLevel = 0;
        Player player = new AST().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileMathClass tileComputerScienceClass = new TileMathClass(positionIndex, tilePoint);
        Action modifySkillLevel = tileComputerScienceClass.fetchInstruction(player);
        modifySkillLevel.performAction(player);
        assertEquals(intialMathematicsLevel + 1 ,player.getHardSkillLevel(Mathematics.class));
    }*/
}