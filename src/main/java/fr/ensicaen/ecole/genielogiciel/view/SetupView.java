package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.NoTraining;
import fr.ensicaen.ecole.genielogiciel.model.Schooling;
import fr.ensicaen.ecole.genielogiciel.presenter.SetupPresenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

// Mockup
public class SetupView {
    private Stage _stage;
    private SetupPresenter _presenter;

    @FXML
    private TextField _nickname;
    @FXML
    private ChoiceBox _schooling;

    public static SetupView createView(Stage primaryStage, String resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(SetupView.class.getResource(resourceName), LoginMain.getMessageBundle());
        Parent root = loader.load();
        SetupView view = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        view._stage = primaryStage;
        return view;
    }


    public void setPresenter(SetupPresenter presenter) {
        _presenter = presenter;
    }

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    public void newPlayer() {
        String name = getName();
        Schooling schooling = getSchooling();
        if (name == null || schooling == null) {
            // TODO Error handling
            System.exit(-1);
        }
        _presenter.createPlayer(name, schooling);
    }

    // TODO Mockup
    private String getName() {
        return "John";
    }

    // TODO Mockup
    private Schooling getSchooling() {
        return new NoTraining();
    }

    public void lauchGame() {
        _presenter.launchGame();
    }

    // TODO  error messages
    public void displayError(String string) {

    }

}
