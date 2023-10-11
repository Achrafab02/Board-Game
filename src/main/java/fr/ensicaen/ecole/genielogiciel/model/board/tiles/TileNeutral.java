package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileNeutral implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    private final int _positionIndex;
    private final Point _tileCoordinates;

    public TileNeutral(int positionIndex, Point tileCoordinates) {
        _positionIndex = positionIndex;
        _tileCoordinates = tileCoordinates;
    }

    public Action fetchInstruction(Player player) {
        return new Move();
    }

    @Override
    public int getPositionIndex() {
        return _positionIndex;
    }

    @Override
    public Point getCoordinates() {
        return _tileCoordinates;
    }
}
