package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathExam implements Tile {
    public Move fetchInstruction(Player player) {
        Move move = new Move();
        if(player.getHardSkillLevel(Mathematics.class) < 4) {
            move._moveCount = -2;
        }
        return move;
    }
}
