package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class RankingPresenter {
    private Ranking _ranking;

    public RankingPresenter(Ranking ranking) {
        _ranking = ranking;
    }

    public Player[] getRankingList() {
        return _ranking.createRanking();
    }
}
