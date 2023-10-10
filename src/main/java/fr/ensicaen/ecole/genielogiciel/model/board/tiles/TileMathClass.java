package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.IncreaseSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathClass implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    public Action fetchInstruction(Player player) {
        return new IncreaseSkill(Mathematics.class, 1);
    }
}
