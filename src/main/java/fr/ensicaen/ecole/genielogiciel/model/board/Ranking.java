package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

import java.util.List;

public class Ranking {
    private final List<Player> _players;

    public Ranking(List<Player> players) {
        _players = players;
    }

    public Player[] createRanking() {
        int numberOfPlayers = _players.size();
        Player[] rankedPlayers = new Player[numberOfPlayers];
        int[] playersPosition = new int[_players.size()];
        for (int i = 0; i < playersPosition.length; i++) {
            playersPosition[i] = _players.get(i).getPosition();
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            int maxIndex = 0;
            int maxValue = -1;
            for (int playerId = 0; playerId < numberOfPlayers; playerId++) {
                if (playersPosition[playerId] > maxValue) {
                    maxValue = playersPosition[playerId];
                    maxIndex = playerId;
                }
            }
            playersPosition[maxIndex] = -1;
            rankedPlayers[i] = _players.get(maxIndex);
        }

        return rankedPlayers;
    }


}
