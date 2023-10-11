package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.IncreaseSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathClass extends Tile {
    public TileMathClass(int positionIndex, Point tileCoordinates) {
        super(positionIndex, tileCoordinates);
    }

    @Override
    public Action fetchInstruction(Player player) {
        return new IncreaseSkill(Mathematics.class, 1);
    }
}
