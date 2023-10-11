package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.presenter.RankingPresenter;
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
import java.util.ResourceBundle;

public class RankingView {
    private static final ResourceBundle BUNDLE = LoginMain.getMessageBundle();
    private Stage _stage;
    private RankingPresenter _rankingPresenter;
    @FXML
    private TableView<Player> _playerRankingTableView;
    @FXML private TableColumn<Player, String> _nameColumnRanking;
    @FXML private TableColumn<Player, String> _schoolingColumnRanking;
    @FXML private TableColumn<Player, String> _mathematicsColumnRanking;
    @FXML private TableColumn<Player, String> _computerScienceColumnRanking;
    private ObservableList<Player> _playersRankingList;


    public void initTableView() {
        _playersRankingList = FXCollections.observableArrayList();
        _playerRankingTableView.setItems(_playersRankingList);
        _nameColumnRanking.setCellValueFactory(new PropertyValueFactory<>("name"));
        _schoolingColumnRanking.setCellValueFactory(new PropertyValueFactory<>("schooling"));
        _mathematicsColumnRanking.setCellValueFactory(new PropertyValueFactory<>("mathematicsLevel"));
        _computerScienceColumnRanking.setCellValueFactory(new PropertyValueFactory<>("computerScienceLevel"));
        Player[] positions = _rankingPresenter.getRankingList();
        for (Player position : positions) {
            addPlayerToTableView(position);
        }
    }

    public void setPresenter(RankingPresenter rankingPresenter) {
        _rankingPresenter = rankingPresenter;
    }

    public void addPlayerToTableView(Player player) {
        _playersRankingList.add(player);
        _playerRankingTableView.setItems(_playersRankingList);
    }

    public void show() {
        _stage.show();
    }

    public static RankingView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RankingView.class.getResource("Ranking.fxml"), BUNDLE);
        fxmlLoader.setLocation(RankingView.class.getResource("Ranking.fxml"));
        Parent root = fxmlLoader.load();
        RankingView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 588, 287.0);
        Stage stage = new Stage();
        scene.getStylesheets().add(Objects.requireNonNull(SetupView.class.getResource("styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        return view;
    }
}
