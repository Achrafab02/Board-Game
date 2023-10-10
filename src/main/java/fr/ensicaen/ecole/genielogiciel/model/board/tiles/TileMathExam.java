package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.MoveIfInsufficientSkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathExam implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    public Action fetchInstruction(Player player) {
        return new MoveIfInsufficientSkillLevel(Mathematics.class, 4, -2);
    }
}
