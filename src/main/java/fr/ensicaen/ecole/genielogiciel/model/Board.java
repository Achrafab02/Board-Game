package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.dices.Rollable;

import java.util.ArrayList;

public class Board {
    private static final int NB_TILES = 6;
    private ArrayList<Player> _players;
    private final int _numberOfPlayers;
    private final int[] _playersPositions;
    private int _currentPlayerId;
    private static Rollable _dice;
    private int _currentDiceResult = 0;

    public Board(ArrayList<Player> players, int numberOfPlayers) {
        _players = players;
        _numberOfPlayers = numberOfPlayers;
        _playersPositions = new int[numberOfPlayers];
        _currentPlayerId = 0;
        _dice = new RandomDice(1, 2);
    }

    public static Rollable getDice() {
        return _dice;
    }

    public void rollDice() {
        _currentDiceResult = _dice.roll();
    }

    public int getDiceResult() {
        return _currentDiceResult;
    }

    public int getNumberOfPlayers() {
        return _numberOfPlayers;
    }

    public void updateCurrentPlayerId() {
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

    public int getNewPositionOfCurrentPlayer() {
        int numberOfMoves = _currentDiceResult;
        int positionOfPlayer = _playersPositions[_currentPlayerId];
        int newPosition = positionOfPlayer + numberOfMoves;

        if (newPosition > NB_TILES) {
            newPosition = NB_TILES - (newPosition - NB_TILES);
        }
        return newPosition;
    }

    public void updateCurrentPlayerPosition(int newPosition) {
        _playersPositions[_currentPlayerId] = newPosition;
    }

    public boolean isWinningPosition() {
        return _playersPositions[_currentPlayerId] == NB_TILES;
    }

    public Player[] createRanking() {
        Player[] players = new Player[_numberOfPlayers];
        int[] playersPosition = _playersPositions.clone();

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
}
