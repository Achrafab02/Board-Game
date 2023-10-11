package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;

public class PawnPresenter {
    private PawnView _pawnView;

    public void setView(PawnView view) {
        _pawnView = view;
    }

    public void draw(Tile finalTile) {
        //TODO : tile.getCoordinates() + draw
    }
}
