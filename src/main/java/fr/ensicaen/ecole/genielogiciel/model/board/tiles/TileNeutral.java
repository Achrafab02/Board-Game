package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileNeutral implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    public Action fetchInstruction(Player player) {
        return new Move();
    }
}
