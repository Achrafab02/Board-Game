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


public final class GamePresenter {
    private GameView _view;
    private Board _board;
    private final boolean _end = false;
    private Rectangle[] _pawns;
    private final DicePresenter _dice;

    public GamePresenter() {
        _dice = new DicePresenter(Board.getDice());
    }

    public void setBoard(Board board) {
        _board = board;
    }

    public void setView(GameView view) {
        _view = view;
        _dice.setView(new DiceView(view.getDiceBoard()));

        Point[] coordinates = {new Point(40, 40), new Point(60, 40), new Point(40, 60), new Point(60, 60)};
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

        _pawns = new Rectangle[_board.getNumberOfPlayers()];
        for (int i = 0; i < _board.getNumberOfPlayers(); i++) {
            _pawns[i] = PawnView.create(coordinates[i].getX(), coordinates[i].getY(), colors[i]);
            _view.getBoard().getChildren().add(_pawns[i]);
        }
    }

    public void play() {
        int newPosition = _board.getNewPositionOfCurrentPlayer();

        _board.updateCurrentPlayerId();
        _board.updateCurrentPlayerPosition(newPosition);

        double newX = _board.getCurrentPlayerPosition() * 100 + (_board.getCurrentPlayerId() % 2 == 0 ? 1 : 0) * 40 + (_board.getCurrentPlayerId() % 2 == 1 ? 1 : 0)*60;
        _pawns[_board.getCurrentPlayerId()].setX(newX);

        if(_board.isWinningPosition()) {
            Alert alert = new Alert(Alert.AlertType.NONE,  (_board.getCurrentPlayerName()) + " " + LoginMain.getMessageBundle().getString("winning.sentence"), ButtonType.OK);
            alert.setTitle(LoginMain.getMessageBundle().getString("title.winner"));
            alert.showAndWait().ifPresent(rs -> {});
            launchRanking();
        }

    }

    public void launchRanking() {
        try {
            createAndDisplayRankingView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    public Player[] getRanking() {
        return _board.createRanking();
    }

    private void createAndDisplayRankingView() throws IOException {
        RankingView view = RankingView.createView(this);
        RankingPresenter rankingPresenter = new RankingPresenter();
        rankingPresenter.setView(view);
        view.show();
    }
}

