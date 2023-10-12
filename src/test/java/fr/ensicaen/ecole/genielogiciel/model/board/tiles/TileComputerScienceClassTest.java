package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.schooling.Prepa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileComputerScienceClassTest {
    @Test
    public void test_tile_computer_science_class_level_on_a_prepa_player() {
        String playerName = "ME";
        String schoolingName = "prepa";
        int initialComputerScienceLevel = 0;
        int initialMathLevel = 4;
        Player player = new Prepa().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileComputerScienceClass tileMathClass = new TileComputerScienceClass(positionIndex, tilePoint);
        Action modifySkillLevel = tileMathClass.fetchInstruction(player);
        modifySkillLevel.performAction(player);
        assertEquals(initialComputerScienceLevel + 1 ,player.getHardSkillLevel(ComputerScience.class));
        assertEquals(initialMathLevel,player.getHardSkillLevel(Mathematics.class));
    }
}