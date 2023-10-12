package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

import java.util.List;

public class Ranking {
    private final List<Player> _players;

    public Ranking(List<Player> players) {
        _players = players;
        sortPlayerByPosition();
    }

    public void sortPlayerByPosition() {
        _players.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
    }

    public List<Player> createRanking() {
        return _players;
    }

}
