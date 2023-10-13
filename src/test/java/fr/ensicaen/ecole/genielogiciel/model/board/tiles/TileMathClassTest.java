package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.AST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileMathClassTest {
    @Test
    public void test_tile_math_class_level_on_a_ast_player() {
        String playerName = "ME";
        String schoolingName = "ast";
        int initialMathematicsLevel = 0;
        int initialComputerScienceLevel = 4;
        Player player = new AST().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileMathClass tileMathClass = new TileMathClass(positionIndex, tilePoint);
        Action modifySkillLevel = tileMathClass.fetchInstruction(player);
        modifySkillLevel.performAction(player);
        assertEquals(initialMathematicsLevel + 1 ,player.getHardSkillLevel(Mathematics.class));
        assertEquals(initialComputerScienceLevel ,player.getHardSkillLevel(ComputerScience.class));
    }

}