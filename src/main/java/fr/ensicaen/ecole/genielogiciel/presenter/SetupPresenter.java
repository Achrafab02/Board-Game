package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Player;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Schooling;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.SchoolingBuilder;
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
        if (_players.size() >= 4) {
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
        if (_players.size() == 0) {
            _setupView.popUpAlert("error.title.zero.player");
        } else {
            try {
                createAndDisplayGameView(_players);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            _setupView.close();
        }
    }

    private void createAndDisplayGameView(ArrayList<Player> players) throws IOException {
        GameView view = GameView.createView();
        BoardController boardController = new BoardController(players);
        boardController.setView(view);
        view.setPresenter(boardController);
        view.show();
    }
}
