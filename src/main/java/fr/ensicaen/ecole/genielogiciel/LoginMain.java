package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.presenter.*;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public final class LoginMain extends Application {
    private static final Object NUMBER_OF_PLAYERS = 1;

    public static void main(String[] args) {
        launch(args);
    }

    public static ResourceBundle getMessageBundle() {
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        SetupView view = SetupView.createView(primaryStage, "menu_setup_v0.fxml");
        SetupPresenter presenter = new SetupPresenter();
        view.setPresenter(presenter);
        presenter.setView(view);
        view.show();

        /*DicePresenter dicePresenter = new DicePresenter();
        new BoardController(dicePresenter);

        Schooling playerSchooling = new NoTraining();
        ArrayList<Schooling> schoolings = new ArrayList<>();
        schoolings.add(playerSchooling);
        GooseGame gooseGame = new GooseGame(schoolings);
        gooseGame.start();*/
    }
}
