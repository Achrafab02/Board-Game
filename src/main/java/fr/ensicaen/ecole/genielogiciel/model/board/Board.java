package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathClass;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathExam;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileNeutral;

import java.util.List;

public class Board {
    public static final int NB_TILES = 11;
    //private static final Tile[] HARD_CODED_BOARD = new Tile[]{new TileNeutral(), new TileNeutral(), new TileMathClass(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileMathExam(), new TileNeutral(), new TileNeutral(), new TileNeutral()};
    private final Tile[] _tiles;
    private static final int NB_MAX_PLAYERS = 4;
    private final List<Player> _players;
    private final int _numberOfPlayers;
    private final int[] _playersPositions;
    private int _currentPlayerId;

    public Board(List<Player> players, int numberOfPlayers) {
        _players = players;
        _numberOfPlayers = numberOfPlayers;
        _playersPositions = new int[numberOfPlayers];
        _currentPlayerId = 0;
        //_tiles = HARD_CODED_BOARD;
        _tiles = new Tile[] {new TileNeutral(0, new Point(0, 0))};
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

    public int[] getPayersPositions() {
        return _playersPositions.clone();
    }

    public List<Player> getPlayers() {
        return _players;
    }

    public String getCurrentPlayerName() {
        return _players.get(_currentPlayerId).getName();
    }

    public int getNewPositionOfCurrentPlayer(int diceResult) {
        int positionOfPlayer = _playersPositions[_currentPlayerId];
        Player currentPlayer = _players.get(_currentPlayerId);
        int newPosition = move(positionOfPlayer + diceResult);

        newPosition += moveDueToTileEffect(newPosition, currentPlayer);

        return newPosition;
    }

    private int move(int newPosition) {
        /*if (goalOverstepped(newPosition)) {
            return moveBackwards(newPosition);
        }
        return newPosition;
         */
        return 0;
    }

    private int moveBackwards(int position) {
        return (NB_TILES - (position - NB_TILES));
    }

    private int moveDueToTileEffect(int position, Player player) {
        Tile newTile = _tiles[position];
        Player currentPlayer = _players.get(_currentPlayerId);
        //return newTile.fetchInstruction(currentPlayer)._moveCount;
        return 0;
    }

    private boolean goalOverstepped(int position) {
        return (position >= NB_TILES);
    }

    public void updateCurrentPlayerPosition(int newPosition) {
        _playersPositions[_currentPlayerId] = newPosition;
    }

    public boolean isInWinningPosition() {
        return _playersPositions[_currentPlayerId] == (NB_TILES - 1);
    }
}
