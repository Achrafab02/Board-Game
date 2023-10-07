package fr.ensicaen.ecole.genielogiciel.model.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Action;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.Player;

public class TileMathClass implements Tile {
    public Action getMoveInstruction(Player player) {
        Action action = new Action();
        player.addToLevelOfHardSkill(Mathematics.class, 1);
        return action;
    }
}
