package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Board;
import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import fr.ensicaen.ecole.genielogiciel.view.RankingView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public final class GamePresenter {
    private GameView _view;
    private final boolean _end = false;
    private Rectangle[] _pawns;
    private final DicePresenter _dice;
    static ArrayList<Player> _players;
    private int _currentPlayerId;
    private static int[] _playersPosition;
    private static int _numberOfPlayers;

    public GamePresenter(ArrayList<Player> players) {
        _players = players;
        _dice = new DicePresenter(new RandomDice(1, 2));
    }

    public void setView( GameView view ) {
        _view = view;
        _dice.setView(new DiceView(view.getDiceBoard()));

        _numberOfPlayers = _players.size();

        _playersPosition = new int[_numberOfPlayers];

        Point[] coordinates = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawns = new Rectangle[_numberOfPlayers];
        for (int i = 0; i < _numberOfPlayers; i++) {
            _pawns[i] = PawnView.create(coordinates[i].getX(), coordinates[i].getY(), colors[i]);
            _view.getBoard().getChildren().add(_pawns[i]);
        }
    }

    public void play() {
        int newPosition = Board.getNewPosition(_playersPosition[_currentPlayerId], _dice.roll());
        _playersPosition[_currentPlayerId] = newPosition;

        double newX = _playersPosition[_currentPlayerId] * 100 + (_currentPlayerId % 2 == 0 ? 1 : 0) * 40 + (_currentPlayerId % 2 == 1 ? 1 : 0)*60;
        _pawns[_currentPlayerId].setX(newX);

        if(Board.isWinningPosition(newPosition)) {
            Alert alert = new Alert(Alert.AlertType.NONE,  (_players.get(_currentPlayerId).getName()) + " " + LoginMain.getMessageBundle().getString("winning.sentence"), ButtonType.OK);
            alert.setTitle(LoginMain.getMessageBundle().getString("title.winner"));
            alert.showAndWait().ifPresent(rs -> {});
            launchRanking();
        }

        _currentPlayerId = (_currentPlayerId + 1) % _numberOfPlayers;
    }

    public void launchRanking() {
        try {
            createAndDisplayRankingView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    public static Player[] getRanking() {
        Player[] players = new Player[_numberOfPlayers];
        int[] playersPosition = _playersPosition.clone();

        for (int i = 0; i < _numberOfPlayers; i++) {
            int indexMax = 0;
            int valeurMax = -1;
            for (int playerId = 0; playerId < _numberOfPlayers; playerId++) {
                if (playersPosition[playerId] > valeurMax) {
                    valeurMax = playersPosition[playerId];
                    indexMax = playerId;
                }
            }
            playersPosition[indexMax] = -1;
            players[i] = _players.get(indexMax);
        }
        return players;
    }

    private void createAndDisplayRankingView() throws IOException {
        RankingView view = RankingView.createView();
        RankingPresenter rankingPresenter = new RankingPresenter();
        rankingPresenter.setView(view);
        view.show();
    }
}

