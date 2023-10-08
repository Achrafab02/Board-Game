package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathClass;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathExam;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileNeutral;
import fr.ensicaen.ecole.genielogiciel.presenter.DicePresenter;

import java.util.ArrayList;

public class Board {
    public static final int NB_TILES = 11;
    private static final Tile[] HARD_CODED_BOARD = new Tile[]{new TileNeutral(), new TileNeutral(), new TileMathClass(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileMathExam(), new TileNeutral(), new TileNeutral(), new TileNeutral()};
    private final Tile[] _tiles;
    private static final int NB_MAX_PLAYERS = 4;
    private final ArrayList<Player> _players;
    private final int _numberOfPlayers;
    private final int[] _playersPositions;
    private int _currentPlayerId;

    public Board(ArrayList<Player> players, int numberOfPlayers) {
        _players = players;
        _numberOfPlayers = numberOfPlayers;
        _playersPositions = new int[numberOfPlayers];
        _currentPlayerId = 0;
        _tiles = HARD_CODED_BOARD;
    }

    public static int getNumberOfTiles() {
        return NB_TILES;
    }

    public static int getMaxNumberOfPlayers() {
        return NB_MAX_PLAYERS;
    }

    public int getNumberOfPlayers() {
        return _numberOfPlayers;
    }

    public void updateIdToNextPlayer() {
        _currentPlayerId = (_currentPlayerId + 1) % _numberOfPlayers;
    }

    public int getCurrentPlayerPosition() {
        return _playersPositions[_currentPlayerId];
    }

    public int getCurrentPlayerId() {
        return _currentPlayerId;
    }

    public String getCurrentPlayerName() {
        return _players.get(_currentPlayerId).getName();
    }

    public int getNewPositionOfCurrentPlayer(int diceResult) {
        int positionOfPlayer = _playersPositions[_currentPlayerId];
        Player currentPlayer = _players.get(_currentPlayerId);
        int newPosition;

        newPosition = backwardMovementIfPlayerOversteppedGoal(positionOfPlayer + diceResult);

        newPosition += moveDueToTileEffect(newPosition, currentPlayer);

        return newPosition;
    }

    private int moveDueToTileEffect(int position, Player player) {
        Tile newTile = _tiles[position];
        Player currentPlayer = _players.get(_currentPlayerId);
        return newTile.getMoveInstruction(currentPlayer)._moveCount;
    }

    private int backwardMovementIfPlayerOversteppedGoal(int position) {
        if (position > NB_TILES) {
            return NB_TILES - (position - NB_TILES);
        }
        return position;
    }

    public void updateCurrentPlayerPosition(int newPosition) {
        _playersPositions[_currentPlayerId] = newPosition;
    }

    public boolean isInWinningPosition() {
        return _playersPositions[_currentPlayerId] == (NB_TILES - 1);
    }

    public Player[] createRanking() {
        Player[] players = new Player[_numberOfPlayers];
        int[] playersPosition = _playersPositions.clone();

        for (int i = 0; i < _numberOfPlayers; i++) {
            int maxIndex = 0;
            int maxValue = -1;
            for (int playerId = 0; playerId < _numberOfPlayers; playerId++) {
                if (playersPosition[playerId] > maxValue) {
                    maxValue = playersPosition[playerId];
                    maxIndex = playerId;
                }
            }
            playersPosition[maxIndex] = -1;
            players[i] = _players.get(maxIndex);
        }
        return players;
    }
}
