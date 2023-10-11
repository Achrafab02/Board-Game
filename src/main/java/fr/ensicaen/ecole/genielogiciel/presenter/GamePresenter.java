package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import fr.ensicaen.ecole.genielogiciel.view.RankingView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


public final class GamePresenter {
    private GameView _view;
    private Board _board;
    private Rectangle[] _pawns;
    private static final ResourceBundle BUNDLE = LoginMain.getMessageBundle();
    private final DicePresenter _dicePresenter;
    private static final int SPACE_BETWEEN_PAWNS = 40;
    private static final Point[] FIRST_PLAYER_POSITION_IN_EACH_TILE = {new Point(365, 220), new Point(290, 370), new Point(315, 580), new Point(480, 665), new Point(680, 550), new Point(730, 390), new Point(810, 200), new Point(1040, 170), new Point(1190, 270), new Point(1170, 520), new Point(1040, 605)};
    private final Point[][] _coordinatesOfPawnsOnTiles = new Point[Board.getNumberOfTiles()][Board.getMaxNumberOfPlayers()];
    private static final Color[] PLAYERS_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};
    //NEW
    private List<Player> _players;
    private BoardControllerPresenter _boardControllerPresenter;
    private int _numberOfPlayer;
    private int _currentPlayerId = 0;

    public GamePresenter() {
        _dicePresenter = new DicePresenter();
    }

    public GamePresenter(List<Player> players) {
        _players = players;
        _numberOfPlayer = players.size();
        _dicePresenter = new DicePresenter();
        _boardControllerPresenter = new BoardControllerPresenter();
        for (Player player : players) {
            player.setBoardController(_boardControllerPresenter);
        }
    }

    //When roll dice is pressed
    public void play() {
        int diceRoll = _dicePresenter.rollDice();
        _dicePresenter.displayDiceImage(); /*In dicePresenter.rollDice() preferably*/
        _players.get(_currentPlayerId).move(diceRoll);
        //next player
        _currentPlayerId = (_currentPlayerId + 1) % _numberOfPlayer;
    }

    public void setBoard(Board board) {
        _board = board;
    }

    private void initCoordinatesOfPawnOnTiles() {
        for (int i = 0; i < Board.getNumberOfTiles(); i++) {
            _coordinatesOfPawnsOnTiles[i][0] = new Point(FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getX(), FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getY());
            _coordinatesOfPawnsOnTiles[i][1] = new Point(FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getX() + SPACE_BETWEEN_PAWNS, FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getY());
            _coordinatesOfPawnsOnTiles[i][2] = new Point(FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getX(), FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getY() + SPACE_BETWEEN_PAWNS);
            _coordinatesOfPawnsOnTiles[i][3] = new Point(FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getX() + SPACE_BETWEEN_PAWNS, FIRST_PLAYER_POSITION_IN_EACH_TILE[i].getY() + SPACE_BETWEEN_PAWNS);
        }
    }

    public void setView(GameView view) {
        _view = view;
        _dicePresenter.setView(new DiceView(view.getDiceBoard()));
    }

    public void initBoardView() {
        initCoordinatesOfPawnOnTiles();
        _pawns = new Rectangle[_board.getNumberOfPlayers()];
        for (int i = 0; i < _board.getNumberOfPlayers(); i++) {
            _pawns[i] = PawnView.create(_coordinatesOfPawnsOnTiles[0][i].getX(), _coordinatesOfPawnsOnTiles[0][i].getY(), PLAYERS_COLORS[i]);
            _view.getBoard().getChildren().add(_pawns[i]);
        }
    }

    public int rollDice() {
        int diceResult = _dicePresenter.rollDice();
        _dicePresenter.displayDiceImage();
        return diceResult;
    }

    public void movePlayer(int diceResult) {
        int newPosition = _board.getNewPositionOfCurrentPlayer(diceResult);

        _board.updateCurrentPlayerPosition(newPosition);

        changeCoordinatesOfPawnOnTile();

        if (_board.isInWinningPosition()) {
            GameView.alert(_board.getCurrentPlayerName() + " " + LoginMain.getMessageBundle().getString("winning.sentence"), LoginMain.getMessageBundle().getString("title.winner"));
            launchRanking();
        }

        _board.updateIdToNextPlayer();
    }

    private void changeCoordinatesOfPawnOnTile() {
        double[] newCoordinates = getCoordinatesOfPawnOnTile(_board.getCurrentPlayerPosition(), _board.getCurrentPlayerId());
        _pawns[_board.getCurrentPlayerId()].setX(newCoordinates[0]);
        _pawns[_board.getCurrentPlayerId()].setY(newCoordinates[1]);
    }

    private double[] getCoordinatesOfPawnOnTile(int position, int playerId) {
        return new double[]{_coordinatesOfPawnsOnTiles[position][playerId].getX(), _coordinatesOfPawnsOnTiles[position][playerId].getY()};
    }

    public void launchRanking() {
        try {
            createAndDisplayRankingView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    private void createAndDisplayRankingView() throws IOException {
        RankingView view = RankingView.createView();
        RankingPresenter rankingPresenter = new RankingPresenter(new Ranking(_board));
        view.setPresenter(rankingPresenter);
        view.initTableView();
        view.show();
    }
}

