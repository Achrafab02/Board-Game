package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Player;
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
        _presenter.launchGame();
    }

    public void initView() {
        initTableView();
        setSchoolingChoiceBox();
    }

    public void getPlayerParameters() {
        _presenter.createPlayer(getName(), getSchooling());
    }

    public void setPresenter(SetupPresenter presenter) {
        _presenter = presenter;
    }

    public static SetupView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(SetupView.class.getResource("Setup.fxml"));
        Parent root = fxmlLoader.load();
        final SetupView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(SetupView.class.getResource("ButtonStyles.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        view.initView();
        return view;
    }
}
