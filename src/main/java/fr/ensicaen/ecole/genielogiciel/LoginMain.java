package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.model.DeterministicDice;
import fr.ensicaen.ecole.genielogiciel.presenter.BoardController;
import fr.ensicaen.ecole.genielogiciel.presenter.DicePresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.PawnPresenter;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public final class LoginMain extends Application {
    private static final Object NUMBER_OF_PLAYERS = 1;

    public static void main(String[] args ) {
        launch(args);
    }

    public static ResourceBundle getMessageBundle() {
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
    }

    @Override
    public void start( final Stage primaryStage ) throws Exception {
        LoginView view = LoginView.createView(primaryStage, "LoginDialog.fxml");
        LoginPresenter presenter = new LoginPresenter();
        view.setPresenter(presenter);
        presenter.setView(view);

        //INITIALISATION
        DicePresenter dicePresenter = new DicePresenter();
        new BoardController(dicePresenter);
        //Schooling
        /*
        new GooseGame();
        GooseGame.init();

        //LANCEMENT PARTIE
        GooseGame.start(NUMBER_OF_PLAYERS);
        */

    }
}
