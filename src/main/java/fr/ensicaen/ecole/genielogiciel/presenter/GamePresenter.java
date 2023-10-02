package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;


public final class GamePresenter {
    private final Model _model;
    private GameView _view;
    private final boolean _end = false;
    private Rectangle _pawn;
    private final DicePresenter _dicePresenter;

    public GamePresenter( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
        _dicePresenter = new DicePresenter(new RandomDice());
    }

    public void setView( GameView view ) {
        _view = view;
    }

    public void setPawn( AnchorPane board ) {
        _pawn = PawnView.create();
        board.getChildren().add(_pawn);
    }

    public void setDiceBoard(AnchorPane diceBoard) {
        _dicePresenter.setDiceBoard(diceBoard);
    }

    public void movePawn() {
        int nb = _dicePresenter.roll();
        _pawn.setX(_pawn.getX() + 100 * nb);
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