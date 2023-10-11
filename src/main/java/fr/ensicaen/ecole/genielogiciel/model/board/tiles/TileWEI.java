package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.CompositeAction;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;

public class TileWEI extends Tile {
    public TileWEI(int positionIndex, Point tileCoordinates) {
        super(positionIndex, tileCoordinates);
    }

    @Override
    public Action fetchInstruction(Player player) {
        CompositeAction compositeAction = new CompositeAction();
        compositeAction.addMultipleActions(
                new Move(-5),
                new ModifySkillLevel(Mathematics.class, -1),
                new ModifySkillLevel(ComputerScience.class, -1)
        );
        return compositeAction;
    }
}
