package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.Schooling;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.util.ArrayList;

public class SetupPresenter {
    private SetupView _view;
    private final ArrayList<Player> _players = new ArrayList<>();

    public void setView(SetupView view) {
        _view = view;
    }

    public void createPlayer(String name, Schooling schooling) {
        Player newPlayer = schooling.createPlayer(name);
        _players.add(newPlayer);
    }

    public void launchGame() {
        if (_players.isEmpty()) {
            _view.displayError("Not enough players to launch game !");
            return;
        }
        GooseGame gooseGame = new GooseGame(_players);
        _view.close();
        gooseGame.start();
    }
}
