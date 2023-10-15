package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.Point;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PawnPresenterTest {

    @Test
    public void test_draw() {
        PawnPresenter presenter = new PawnPresenter();

        PawnView view = mock(PawnView.class);

        presenter.setView(view);

        Tile finalTile = mock(Tile.class);

        Point point = new Point(2, 3);
        when(finalTile.getCoordinates()).thenReturn(point);

        presenter.draw(finalTile);

        verify(view).updatePosition(point.getX(), point.getY());
    }

    @Test
    public void test_init_pawn() {
        PawnPresenter presenter = new PawnPresenter();

        PawnView view = mock(PawnView.class);

        presenter.setView(view);

        AnchorPane board = mock(AnchorPane.class);

        int id = 1;
        presenter.initPawn(board, id);

        verify(view).initPawn(board, id);
    }
}
