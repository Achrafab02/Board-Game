package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public interface Tile {
    Move fetchInstruction(Player player);
}