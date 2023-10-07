package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileNeutral implements Tile {
    public Action getMoveInstruction(Player player) {
        return new Action();
    }
}
