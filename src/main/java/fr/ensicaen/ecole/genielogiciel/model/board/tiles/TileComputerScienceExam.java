package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.MoveIfInsufficientSkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;

public class TileComputerScienceExam extends Tile {
    public TileComputerScienceExam(int positionIndex, Point tileCoordinates) {
        super(positionIndex, tileCoordinates);
    }

    @Override
    public Action fetchInstruction(Player player) {
        return new MoveIfInsufficientSkillLevel(ComputerScience.class, 4, -2);
    }
}