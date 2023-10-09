package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

import java.util.ArrayList;

public class Ranking {
    private Board _board;

    public Ranking(Board board) {
        _board = board;
    }

    public Player[] createRanking() {
        ArrayList<Player> players = _board.getPlayers();
        Player[] rankedPlayers = new Player[_board.getNumberOfPlayers()];
        int[] playersPosition = _board.getPayersPositions();

        for (int i = 0; i < _board.getNumberOfPlayers(); i++) {
            int maxIndex = 0;
            int maxValue = -1;
            for (int playerId = 0; playerId < _board.getNumberOfPlayers(); playerId++) {
                if (playersPosition[playerId] > maxValue) {
                    maxValue = playersPosition[playerId];
                    maxIndex = playerId;
                }
            }
            playersPosition[maxIndex] = -1;
            rankedPlayers[i] = players.get(maxIndex);
        }
        return rankedPlayers;
    }

}
