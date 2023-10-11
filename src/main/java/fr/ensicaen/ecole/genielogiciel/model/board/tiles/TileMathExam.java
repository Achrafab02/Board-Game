package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.MoveIfInsufficientSkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathExam implements fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile {
    private final int _positionIndex;
    private final Point _tileCoordinates;

    public TileMathExam(int positionIndex, Point tileCoordinates) {
        _positionIndex = positionIndex;
        _tileCoordinates = tileCoordinates;
    }
    @Override
    public Action fetchInstruction(Player player) {
        return new MoveIfInsufficientSkillLevel(Mathematics.class, 4, -2);
    }

    @Override
    public int getPositionIndex() {
        return _positionIndex;
    }
}
