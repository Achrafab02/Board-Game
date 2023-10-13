package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.DiceModifierView;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.RankingView;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


public final class GamePresenter {
    private GameView _view;
    private static final ResourceBundle BUNDLE = LoginMain.getMessageBundle();
    private final DicePresenter _dicePresenter;
    private final DiceModifierPresenter _diceModifierPresenter;
    private final List<Player> _players;
    private BoardControllerPresenter _boardControllerPresenter;
    private final int _numberOfPlayer;
    private int _currentPlayerId = 0;

    public GamePresenter(List<Player> players) {
        _players = players;
        _numberOfPlayer = players.size();
        _dicePresenter = new DicePresenter();
        _diceModifierPresenter = new DiceModifierPresenter();
        _boardControllerPresenter = new BoardControllerPresenter();
        for (Player player : players) {
            player.setBoardController(_boardControllerPresenter);
        }
    }

    public void initGame() {
        int id = 0;
        for (Player player : _players) {
            player.initPawn(_view.getBoard(), id);
            id++;
        }
    }

    public void play() {
        Player currentPlayer = _players.get(_currentPlayerId);
        _diceModifierPresenter.display(currentPlayer.getSoftSkill().getModifierValue());
        int diceRoll = _dicePresenter.rollDice();
        currentPlayer.move(diceRoll);

        if (currentPlayer.isOnWinningTile()) {
            GameView.alert(currentPlayer.getName() + " " + BUNDLE.getString("winning.sentence"), LoginMain.getMessageBundle().getString("title.winner"));
            launchRanking();
        }

        changeIdToNextPlayer();
    }

    private void changeIdToNextPlayer() {
        _currentPlayerId = (_currentPlayerId + 1) % _numberOfPlayer;
    }

    public void setView(GameView view) {
        _view = view;
        _dicePresenter.setView(new DiceView(view.getDiceBoard()));
        _diceModifierPresenter.setView(new DiceModifierView(view.getDiceModifier()));
    }

    public void launchRanking() {
        try {
            createAndDisplayRankingView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    private void createAndDisplayRankingView() throws IOException {
        RankingView view = RankingView.createView();
        RankingPresenter rankingPresenter = new RankingPresenter(new Ranking(_players));
        view.setPresenter(rankingPresenter);
        view.initTableView();
        view.show();
    }
}

