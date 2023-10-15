package fr.ensicaen.ecole.genielogiciel.model.board.tiles;


import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileTest {

    @Test
    public void test_get_position_index() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        ConcreteTile tile = new ConcreteTile(positionIndex, coordinates);

        assertEquals(positionIndex, tile.getPositionIndex());
    }

    @Test
    public void test_get_coordinates() {
        int positionIndex = 7;
        Point coordinates = new Point(4, 1);
        ConcreteTile tile = new ConcreteTile(positionIndex, coordinates);

        assertEquals(coordinates, tile.getCoordinates());
    }
}

class ConcreteTile extends Tile {

    public ConcreteTile(int positionIndex, Point tileCoordinates) {
        super(positionIndex, tileCoordinates);
    }

    @Override
    public Action fetchInstruction(Player player) {
        return new FakeAction();
    }
}

class FakeAction implements Action {

    @Override
    public void performAction(Player player) {
    }
}
