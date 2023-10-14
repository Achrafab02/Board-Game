package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.AST;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.Prepa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileMathExamTest {
    @Test
    public void test_tile_math_exam_effect_on_insufficient_hardskill_level_player() {
        Player player = new Prepa().createPlayer("", "");
        player.setPosition(5);
        Point tilePoint = new Point(0, 0);
        int positionIndex = 0;
        TileMathExam tileMathExam = new TileMathExam(positionIndex, tilePoint);
        Action MoveInfInsufficientSkillLevel = tileMathExam.fetchInstruction(player);
        MoveInfInsufficientSkillLevel.performAction(player);
        assertEquals(5 - 2, player.getPosition());
    }

    @Test
    public void test_tile_math_exam_effect_on_sufficient_hardskill_level_player() {
        Player player = new Prepa().createPlayer("", "");
        player.setPosition(5);
        Point tilePoint = new Point(0, 0);
        int positionIndex = 0;
        TileMathExam tileMathExam = new TileMathExam(positionIndex, tilePoint);
        Action MoveInfInsufficientSkillLevel = tileMathExam.fetchInstruction(player);
        MoveInfInsufficientSkillLevel.performAction(player);
        assertEquals(5, player.getPosition());
    }
}