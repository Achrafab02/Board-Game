package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Player;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Schooling;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.SchoolingBuilder;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.ArrayList;

public class SetupPresenter {
    private SetupView _view;
    private final ArrayList<Player> _players = new ArrayList<>();

    public void setView(SetupView view) {
        _view = view;
    }

    public void createPlayer(String name, String schoolingName) {
        if(_players.size() >= 4) {
            Alert alert = new Alert(Alert.AlertType.NONE, "[ERROR] Max number players reach", ButtonType.OK);
            alert.setTitle("Players number");
            alert.showAndWait().ifPresent(rs -> {});
        } else if(name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.NONE, "[ERROR] Enter name", ButtonType.OK);
            alert.setTitle("Players name");
            alert.showAndWait().ifPresent(rs -> {});
        } else if (schoolingName == null) {
            Alert alert = new Alert(Alert.AlertType.NONE, "[ERROR] Enter formation", ButtonType.OK);
            alert.setTitle("Players formation");
            alert.showAndWait().ifPresent(rs -> {});
        } else {
            Schooling schooling = SchoolingBuilder.createSchooling(schoolingName); // TODO : catch exception
            Player newPlayer = schooling.createPlayer(name);
            _players.add(newPlayer);
            _view.addPlayerToTableView(newPlayer);
        }
    }

    public void launchGame() {
        if(_players.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.NONE, "[ERROR] Cant start the game with 0 players.", ButtonType.OK);
            alert.setTitle("Players number");
            alert.showAndWait().ifPresent(rs -> {});
        } else {
            try {
                createAndDisplayGameView(_players);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            _view.close();
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
