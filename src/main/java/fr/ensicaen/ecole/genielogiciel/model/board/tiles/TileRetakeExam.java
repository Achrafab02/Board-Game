package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.MoveToIndex;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileRetakeExam extends Tile {
    private static final int START_INDEX = 0;

    public TileRetakeExam(int positionIndex, Point tileCoordinates) {
        super(positionIndex, tileCoordinates);
    }

    @Override
    public Action fetchInstruction(Player player) {
        return new MoveToIndex(START_INDEX);
    }
}
