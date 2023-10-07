package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathClass implements Tile {
    public Action getMoveInstruction(Player player) {
        Action action = new Action();
        player.addToLevelOfHardSkill(Mathematics.class, 1);
        return action;
    }
}
