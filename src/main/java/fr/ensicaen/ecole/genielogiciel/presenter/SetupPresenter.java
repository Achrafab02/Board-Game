package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.schooling.Schooling;
import fr.ensicaen.ecole.genielogiciel.model.schooling.SchoolingBuilder;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;
import java.util.ArrayList;

public class SetupPresenter {
    private SetupView _setupView;
    private final ArrayList<Player> _players = new ArrayList<>();

    public void setView(SetupView view) {
        _setupView = view;
    }

    public void createPlayer(String name, String schoolingName) {
        if (_players.size() >= Board.getNumberMaxOfPlayers()) {
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
        GamePresenter gamePresenter = new GamePresenter();
        Board board = new Board(_players, _players.size());

        gamePresenter.setBoard(board);
        gamePresenter.setView(view);
        view.setPresenter(gamePresenter);
        view.show();
    }
}
