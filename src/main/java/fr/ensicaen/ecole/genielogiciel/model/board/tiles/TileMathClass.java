package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.IncreaseSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathClass implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    private final int _positionIndex;
    private final Point _tileCoordinates;

    public TileMathClass(int positionIndex, Point coordinates) {
        _positionIndex = positionIndex;
        _tileCoordinates = coordinates;
    }

    @Override
    public Action fetchInstruction(Player player) {
        return new IncreaseSkill(Mathematics.class, 1);
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
