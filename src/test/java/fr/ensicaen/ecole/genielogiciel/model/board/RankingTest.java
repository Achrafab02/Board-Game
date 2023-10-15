package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RankingTest {
    @Test
    public void test_sort_player_by_position() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("", "");
        player1.setPosition(3);
        Player player2 = new Player("", "");
        player2.setPosition(1);
        Player player3 = new Player("", "");
        player3.setPosition(2);
        players.add(player1);
        players.add(player2);
        players.add(player3);

        Ranking ranking = new Ranking(players);

        ranking.sortPlayerByPosition();

        List<Player> sortedPlayers = ranking.createRanking();
        assertEquals(3, sortedPlayers.size());
        assertTrue(sortedPlayers.get(0).getPosition() >= sortedPlayers.get(1).getPosition());
        assertTrue(sortedPlayers.get(1).getPosition() >= sortedPlayers.get(2).getPosition());
    }
}
