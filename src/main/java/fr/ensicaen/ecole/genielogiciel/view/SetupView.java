package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.presenter.SetupPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupView {
    private SetupPresenter _presenter;
    private Stage _stage;
    @FXML private TableView<Player> _playerListPresenter;
    @FXML private TableColumn<Player, String> _nameColumn;
    @FXML private TableColumn<Player, String> _schoolingColumn;
    private ObservableList<Player> _playersList;

    @FXML private TextField _playerName;
    @FXML private ChoiceBox<String> _schoolingChoiceBox;

    public void initTableView() {
        _playersList = FXCollections.observableArrayList();
        _playerListPresenter.setItems(_playersList);
        _nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        _schoolingColumn.setCellValueFactory(new PropertyValueFactory<>("schooling"));
    }

    private void printList() {
        for (Player player : _playersList) {
            System.out.println("Player name : " + player.getName());
            System.out.println("Player schooling : " + player.getSchooling());
        }
        System.out.println("---");
    }

    public void displayError( String message ) {
        _playerName.setText(message);
    }

    public String getName() {
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

    public void addPlayerToTableView(Player player) {
        _playersList.add(player);
        _playerListPresenter.setItems(_playersList);
        printList();
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
        _presenter.launchGame();
    }

    public void initView() {
        initTableView();
        setSchoolingChoiceBox();
    }

    public void getPlayerParameters() {
        _presenter.createPlayer(getName(), getSchooling());
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
