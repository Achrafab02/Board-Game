package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.board.Ranking;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.schooling.Schooling;
import fr.ensicaen.ecole.genielogiciel.model.schooling.SchoolingBuilder;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetupPresenter {
    private SetupView _setupView;
    private final List<Player> _players = new ArrayList<>();

    public void setView(SetupView view) {
        _setupView = view;
    }

    public void createPlayer(String name, String schoolingName) {
        if (_players.size() >= Board.getMaxNumberOfPlayers()) {
            _setupView.popUpAlert("error.title.maxPlayer");
        } else if (name.isEmpty()) {
            _setupView.popUpAlert("error.title.empty.player");
        } else if (schoolingName == null) {
            _setupView.popUpAlert("error.title.empty.training");
        } else {
            Schooling schooling = SchoolingBuilder.createSchooling(schoolingName); // TODO : catch exception
            Player newPlayer = schooling.createPlayer(name);
            _players.add(newPlayer);
            _setupView.addPlayerToTableView(newPlayer);
        }
    }

    public void launchGame() {
        if (_players.isEmpty()) {
            _setupView.popUpAlert("error.title.zero.player");
        } else {
            try {
                createAndDisplayGameView();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            _setupView.close();
        }
    }

    private void createAndDisplayGameView() throws IOException {
        GameView view = GameView.createView();
        GamePresenter gamePresenter = new GamePresenter(_players);
        Board board = new Board(_players, _players.size());
        gamePresenter.setView(view);
        gamePresenter.initGame();

        gamePresenter.setBoard(board);
        gamePresenter.initBoardView();
        view.setPresenter(gamePresenter);
        view.show();
    }
}
