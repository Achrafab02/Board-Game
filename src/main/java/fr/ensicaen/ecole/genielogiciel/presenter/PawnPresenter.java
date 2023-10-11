package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.layout.AnchorPane;

public class PawnPresenter {
    private PawnView _pawnView;

    public PawnPresenter() {
        _pawnView = new PawnView();
    }

    public void setView(PawnView view) {
        _pawnView = view;
    }

    public void draw(Tile finalTile) {
        Point point = finalTile.getCoordinates();
        _pawnView.updatePosition(point.x, point.y);
    }

    public void initPawn(AnchorPane board) {
        _pawnView.initPawn(board);
    }
}
