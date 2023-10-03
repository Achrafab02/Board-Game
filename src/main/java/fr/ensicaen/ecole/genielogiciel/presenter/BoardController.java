package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class BoardController {
    private final Model _model;
    private GameView _view;
    private final boolean _end = false;
    private Rectangle[] _pawn;
    private final DicePresenter _dice;
    private int _nbPlayers;
    private int _playerTurn;
    private int[] _playerPos;

    public BoardController( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
        _dice = new DicePresenter(new RandomDice(1, 2));
    }

    public void setView( GameView view ) {
        _view = view;
        _dice.setDiceBoard(view.getDiceBoard());
    }

    public void create_pawn(int nbPlayers) {
        _nbPlayers = nbPlayers;
        _playerPos = new int[nbPlayers];

        Point[] coordonee = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawn = new Rectangle[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            _pawn[i] = PawnView.create(coordonee[i].x, coordonee[i].y, color[i]);
            _view.getBoard().getChildren().add(_pawn[i]);
        }
    }

    public void play() {        // public void play(Player player)
        int pos = _playerPos[_playerTurn] + _dice.roll();
        double newX = _pawn[_playerTurn].getX() + 100 * pos;
        if(pos > 6) {
            pos = 6 - (pos - 6);
        }
        _pawn[_playerTurn].setX(_pawn[_playerTurn].getX() + 100 * (pos - _playerPos[_playerTurn]));

        if(pos == 6) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Player " + (_playerTurn+1) + " win the game.", ButtonType.OK);
            alert.setTitle("Winner");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }

        _playerPos[_playerTurn] = pos;
        _playerTurn = (_playerTurn + 1) % _nbPlayers;
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
