package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RankingView {
    private Stage _stage;
    private GamePresenter _gamePresenter;
    @FXML
    private TableView<Player> _playerRankingTableView;
    @FXML private TableColumn<Player, String> _nameColumnRanking;
    @FXML private TableColumn<Player, String> _schoolingColumnRanking;
    private ObservableList<Player> _playersRankingList;


    public void initTableView() {
        _playersRankingList = FXCollections.observableArrayList();
        _playerRankingTableView.setItems(_playersRankingList);
        _nameColumnRanking.setCellValueFactory(new PropertyValueFactory<>("name"));
        _schoolingColumnRanking.setCellValueFactory(new PropertyValueFactory<>("schooling"));
        Player[] positions = _gamePresenter.getRankingList();
        for (Player position : positions) {
            addPlayerToTableView(position);
        }
    }

    public void addPlayerToTableView(Player player) {
        _playersRankingList.add(player);
        _playerRankingTableView.setItems(_playersRankingList);
    }

    public void setGamePresenter(GamePresenter gamePresenter) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    public void initView() {
        initTableView();
    }

    public static RankingView createView(GamePresenter gamePresenter) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RankingView.class.getResource("Ranking.fxml"), LoginMain.getMessageBundle());
        fxmlLoader.setLocation(RankingView.class.getResource("Ranking.fxml"));
        Parent root = fxmlLoader.load();
        RankingView view = fxmlLoader.getController();
        view.setGamePresenter(gamePresenter);
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 387.0, 287.0);
        Stage stage = new Stage();
        scene.getStylesheets().add(Objects.requireNonNull(SetupView.class.getResource("styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        view.initView();
        return view;
    }
}
