package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class SetupView {
    private static final ResourceBundle BUNDLE = LoginMain.getMessageBundle();
    private SetupPresenter _presenter;
    private Stage _stage;
    @FXML private TableView<Player> _playerSetupTableView;
    @FXML private TableColumn<Player, String> _nameColumnSetup;
    @FXML private TableColumn<Player, String> _schoolingColumnSetup;
    private ObservableList<Player> _playersList;

    @FXML private TextField _playerName;
    @FXML private ChoiceBox<String> _schoolingChoiceBox;

    public void initTableView() {
        _playersList = FXCollections.observableArrayList();
        _playerSetupTableView.setItems(_playersList);
        _nameColumnSetup.setCellValueFactory(new PropertyValueFactory<>("name"));
        _schoolingColumnSetup.setCellValueFactory(new PropertyValueFactory<>("schooling"));
        addPlayerToTableView(new Player("")); // TO HIDE TEMPORARILY "empty table message"
    }

    public void popUpAlert(String key) {
        Alert alert = new Alert(Alert.AlertType.NONE, BUNDLE.getString(key), ButtonType.OK);
        alert.setTitle(BUNDLE.getString(key));
        alert.showAndWait().ifPresent(rs -> {});
    }

    public String getName() {
        return _playerName.getText();
    }

    public String getSchooling() {
        return _schoolingChoiceBox.getValue();
    }

    public void setSchoolingChoiceBox() {
        String noTraining = "noTraining";
        String prepa = "prepa";
        String ast = "ast";
        ObservableList<String> choiceList = FXCollections.observableArrayList(noTraining, prepa, ast);
        _schoolingChoiceBox.setItems(choiceList);
    }

    public void addPlayerToTableView(Player player) {
        _playersList.add(player);
        _playerSetupTableView.setItems(_playersList);
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
        // REMOVE PLAYER PREVENTING FROM "empty table message"
        if (_playersList.size() == 1 && _playersList.get(0).getName().isEmpty()) {
            _playersList.remove(0);
        }
        _presenter.createPlayer(getName(), getSchooling());
    }

    public void setPresenter(SetupPresenter presenter) {
        _presenter = presenter;
    }

    public static SetupView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SetupView.class.getResource("Setup.fxml"), BUNDLE);
        fxmlLoader.setLocation(SetupView.class.getResource("Setup.fxml"));
        Parent root = fxmlLoader.load();
        final SetupView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(Objects.requireNonNull(SetupView.class.getResource("styles.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        view.initView();
        return view;
    }
}
