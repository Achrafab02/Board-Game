package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class GamePresenter {
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private Rectangle _pawn;

    public GamePresenter( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
    }

    public void setView( GameView view ) {
        _view = view;
    }

    public void setPawn( AnchorPane board ) {
        _pawn = PawnPresenter.create();
        board.getChildren().add(_pawn);
    }

    public void movePawn( int nbTile) {
        _pawn.setX(_pawn.getX() + 100 * nbTile);
    }

    public void runGameLoop() {
        System.out.println("Et c'est parti...");
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}