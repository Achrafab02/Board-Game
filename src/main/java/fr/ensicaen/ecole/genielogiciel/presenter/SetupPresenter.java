package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.Schooling;
import fr.ensicaen.ecole.genielogiciel.model.SchoolingBuilder;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;
import java.util.ArrayList;

public class SetupPresenter {
    private SetupView _view;
    private final ArrayList<Player> _players = new ArrayList<>();

    public void setView(SetupView view) {
        _view = view;
    }

    public void createPlayer(String name, String schoolingName) {
        Schooling schooling = SchoolingBuilder.createSchooling(schoolingName); // TODO : catch exception
        Player newPlayer = schooling.createPlayer(name);
        _players.add(newPlayer);
        _view.addPlayerToTableView(newPlayer);
    }

    public void launchGame() {
        try {
            createAndDisplayGameView(_players);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAndDisplayGameView(ArrayList<Player> players) throws IOException {
        GameView view = GameView.createView();
        GamePresenter gamePresenter = new GamePresenter(players);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        _view.close();
        view.show();
    }
}
