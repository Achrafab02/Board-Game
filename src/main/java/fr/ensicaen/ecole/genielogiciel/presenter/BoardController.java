package fr.ensicaen.ecole.genielogiciel.presenter;

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
    private GameView _gameView;
    private final boolean _end = false;
    private Rectangle[] _pawn;
    private final DicePresenter _dice;
    ArrayList<Player> _players;
    private int _playerTurn;
    private int[] _playerPos;
    
    private final int NUMBER_OF_TILE = 6;

    public BoardController(ArrayList<Player> players) {
        _players = players;
        _dice = new DicePresenter(new RandomDice(1, 2));
    }

    public void setView(GameView view) {
        _gameView = view;
        _dice.setDiceBoard(view.getDiceBoard());

        _playerPos = new int[_players.size()];
        Point[] coordinates = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawn = new Rectangle[_players.size()];
        for (int i = 0; i < _players.size(); i++) {
            _pawn[i] = PawnView.create(coordinates[i].x, coordinates[i].y, color[i]);
            _gameView.getBoard().getChildren().add(_pawn[i]);
        }
    }

    public void play() {
        int newPlayerPosition = _playerPos[_playerTurn] + _dice.roll();
        if (newPlayerPosition > NUMBER_OF_TILE) {
            newPlayerPosition = moveBackwards(newPlayerPosition);
        }
        //TODO : SHOULD BE PERFORMED IN THE RIGHT CLASS
        _pawn[_playerTurn].setX(_pawn[_playerTurn].getX() + 100 * (newPlayerPosition - _playerPos[_playerTurn]));

        if (newPlayerPosition == NUMBER_OF_TILE) {
            //TODO : This javaFX should be in the view
            Alert alert = new Alert(Alert.AlertType.NONE, "Player " + (_players.get(_playerTurn).getName()) + " win the game.", ButtonType.OK);
            alert.setTitle("Winner");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }

        _playerPos[_playerTurn] = newPlayerPosition;
        _playerTurn = (_playerTurn + 1) % _players.size();
    }

    private int moveBackwards(int newPlayerPosition) {
        return NUMBER_OF_TILE - (newPlayerPosition - NUMBER_OF_TILE);
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
