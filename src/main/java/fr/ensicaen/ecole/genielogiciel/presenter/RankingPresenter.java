package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

import java.util.List;

public class RankingPresenter {
    private final Ranking _ranking;

    public RankingPresenter(Ranking ranking) {
        _ranking = ranking;
    }

    public List<Player> getRankingList() {
        return _ranking.createRanking();
    }
}
