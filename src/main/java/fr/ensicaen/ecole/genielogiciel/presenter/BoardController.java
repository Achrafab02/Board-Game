package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.shape.Rectangle;


public final class BoardController {
    private final Model _model;
    private GameView _view;
    private final boolean _end = false;
    private Rectangle _pawn;
    private final DicePresenter _dice;

    public BoardController( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
        _dice = new DicePresenter(new RandomDice(1, 2));
    }

    public void setView( GameView view ) {
        _view = view;
        _dice.setDiceBoard(view.getDiceBoard());
    }

    public void create_pawn() {
        _pawn = PawnView.create();
        _view.getBoard().getChildren().add(_pawn);
    }

    public void play() {        // public void play(Player player)
        int nb = _dice.roll();
        _pawn.setX(_pawn.getX() + 100 * nb);
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}

