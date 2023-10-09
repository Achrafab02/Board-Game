package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathClass implements Tile {
    public Move fetchInstruction(Player player) {
        Move move = new Move();
        player.addToLevelOfHardSkill(Mathematics.class, 1);
        return move;
    }
}
