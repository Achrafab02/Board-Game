package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public final class BoardController {
    private GameView _view;
    private final boolean _end = false;
    private Rectangle[] _pawn;
    private final DicePresenter _dice;
    ArrayList<Player> _players;
    private int _playerTurn;
    private int[] _playerPos;

    public BoardController(ArrayList<Player> players) {
        _players = players;
        _dice = new DicePresenter(new RandomDice(1, 2));
    }

    public void setView( GameView view ) {
        _view = view;
        _dice.setDiceBoard(view.getDiceBoard());

        _playerPos = new int[_players.size()];
        Point[] coordonee = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawn = new Rectangle[_players.size()];
        for (int i = 0; i < _players.size(); i++) {
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
            Alert alert = new Alert(Alert.AlertType.NONE, (_players.get(_playerTurn).getName()) + " " + LoginMain.getMessageBundle().getString("winning.sentence"), ButtonType.OK);
            alert.setTitle(LoginMain.getMessageBundle().getString("title.winner"));
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }

        _playerPos[_playerTurn] = pos;
        _playerTurn = (_playerTurn + 1) % _players.size();
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
