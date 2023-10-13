package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.Prepa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileMathExamTest {
    @Test
    public void test_tile_math_class_exam_on_prepa() {
        String playerName = "ME";
        String schoolingName = "ast";
        Player player = new Prepa().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileMathExam tileMathExam = new TileMathExam(positionIndex,tilePoint);
        Action MoveInfInsufficientSkillLevel = tileMathExam.fetchInstruction(player);
        MoveInfInsufficientSkillLevel.performAction(player);
        assertEquals(0,player.getPosition());
    }
    @Test
    public void test_tile_computer_science_class_exam_on_prepa() {
        String playerName = "ME";
        String schoolingName = "prepa";
        Player player = new Prepa().createPlayer(playerName, schoolingName);
        Point tilePoint = new Point(0,0);
        int positionIndex = 0;
        TileComputerScienceExam tileComputerScienceExam = new TileComputerScienceExam(positionIndex,tilePoint);
        Action MoveInfInsufficientSkillLevel = tileComputerScienceExam.fetchInstruction(player);
        MoveInfInsufficientSkillLevel.performAction(player);
        assertEquals(-2,player.getPosition());
    }
}