package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileNeutral implements Tile {
    public Move fetchInstruction(Player player) {
        return new Move();
    }
}
