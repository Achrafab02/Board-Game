package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public interface Tile {
     Action fetchInstruction(Player player);

     int getPosition();
}