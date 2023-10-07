package fr.ensicaen.ecole.genielogiciel.model.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Action;
import fr.ensicaen.ecole.genielogiciel.model.Player;

public interface Tile {
    public Action getMoveInstruction(Player player);
}