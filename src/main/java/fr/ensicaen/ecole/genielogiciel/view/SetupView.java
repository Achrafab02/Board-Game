package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.presenter.SetupPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupView {

    private SetupPresenter _presenter;
    private Stage _stage;
    @FXML
    private TextField _playerName;
    private TableView _playerListPresenter;
    private TableColumn<Player, String> _column1;
    private TableColumn<Player, String> _column2;
    final ObservableList<Player> _playersList = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> _schoolingChoiceBox;

    public void initTableView() {
        _playerListPresenter = new TableView();
        _column1 = new TableColumn<>("Nom");
        _column2 = new TableColumn<>("Schooling");
        _playerListPresenter.getColumns().add(_column1);
        _playerListPresenter.getColumns().add(_column2);
    }

    public void displayError( String message ) {
        _playerName.setText(message);
    }

    public String getPlayerName() {
        return _playerName.getText();
    }

    public String getSchooling() {
        return _schoolingChoiceBox.getValue();
    }

    public void setSchoolingChoiceBox() {
        String noTraining = "noTraining";
        ObservableList<String> choiceList = FXCollections.observableArrayList(noTraining);
        _schoolingChoiceBox.setItems(choiceList);
    }

    public void addPlayerToTableView(Player p) {
        _playersList.add(p);
    }

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    @FXML
    private void launchGame() {
        displayError("CLICK DETECTED");
        _presenter.launchGame(_playerName.getText());
    }

    public void initView() {
        initTableView();
        setSchoolingChoiceBox();
    }

    public void getPlayerParameters() {
        _presenter.createPlayer();
    }



    public static SetupView createView( Stage primaryStage, String  resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(SetupView.class.getResource(resourceName), LoginMain.getMessageBundle());
        Parent root = loader.load();
        // getController() does not return a presenter but actually a class of the View
        // if we want the presenter independent of the API JavaFX.
        SetupView view = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        view._stage = primaryStage;
        return view;
    }



    public void setPresenter(SetupPresenter presenter) {
        _presenter = presenter;
    }
}
