package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Player;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
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
    private final DicePresenter _dicePresenter;
    ArrayList<Player> _players;
    private int _playerTurn;
    private int[] _playerPos;

    public BoardController(ArrayList<Player> players) {
        _players = players;
        Rollable dice = new RandomDice(1, 2);
        _dicePresenter = new DicePresenter(dice);


    }

    public void setView(GameView view) {
        _view = view;

        DiceView diceView = new DiceView(view.getDiceBoard());
        _dicePresenter.setView(diceView);

        _playerPos = new int[_players.size()];
        Point[] coordinates = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawn = new Rectangle[_players.size()];
        for (int i = 0; i < _players.size(); i++) {
            _pawn[i] = PawnView.create(coordinates[i].x, coordinates[i].y, color[i]);
            _view.getBoard().getChildren().add(_pawn[i]);
        }
    }

    public void play() {        // public void play(Player player)
        int pos = _playerPos[_playerTurn] + _dicePresenter.roll();
        double newX = _pawn[_playerTurn].getX() + 100 * pos;
        if (pos > 6) {
            pos = 6 - (pos - 6);
        }
        _pawn[_playerTurn].setX(_pawn[_playerTurn].getX() + 100 * (pos - _playerPos[_playerTurn]));

        if (pos == 6) {
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
