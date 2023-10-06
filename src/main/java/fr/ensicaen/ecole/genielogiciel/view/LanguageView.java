package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.presenter.LanguagePresenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LanguageView {
    private LanguagePresenter _presenter;
    private Stage _stage;

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    @FXML
    private void launchSetup() {
        _presenter.launchSetup();
    }

    public void initView() {
    }

    public static LanguageView createView(Stage primaryStage, String  resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(LanguageView.class.getResource(resourceName), LoginMain.getMessageBundle());
        Parent root = loader.load();
        // getController() does not return a presenter but actually a class of the View
        // if we want the presenter independent of the API JavaFX.
        LanguageView view = loader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(LanguageView.class.getResource("ButtonStyles.css").toExternalForm());
        primaryStage.setScene(scene);
        view._stage = primaryStage;
        return view;
    }

    @FXML
    private void launchFrenchSetup() {
        _presenter.launchFrenchSetup();
    }

    @FXML
    private void launchEnglishSetup() {
        _presenter.launchEnglishSetup();
    }

    public void setPresenter(LanguagePresenter presenter) {
        _presenter = presenter;
    }
}