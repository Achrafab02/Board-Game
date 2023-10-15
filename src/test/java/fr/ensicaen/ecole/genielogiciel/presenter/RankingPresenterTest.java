package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;

public class RankingPresenterTest {

    @Test
    public void test_get_ranking_list() {
        Ranking ranking = mock(Ranking.class);

        List<Player> expectedRanking = createSampleRanking();

        when(ranking.createRanking()).thenReturn(expectedRanking);

        RankingPresenter presenter = new RankingPresenter(ranking);

        List<Player> actualRanking = presenter.getRankingList();

        assertEquals(expectedRanking, actualRanking);
    }

    private List<Player> createSampleRanking() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Player player3 = mock(Player.class);
        return List.of(player1, player2, player3);
    }
}
