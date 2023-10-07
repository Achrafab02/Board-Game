package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Player;
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

public class RankingView {
    private RankingPresenter _presenter;
    private Stage _stage;
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
    }

    private void printList() {
        for (Player player : _playersRankingList) {
            System.out.println("Player name : " + player.getName());
            System.out.println("Player schooling : " + player.getSchooling());
        }
        System.out.println("---");
    }

    public void addPlayerToTableView(Player player) {
        _playersRankingList.add(player);
        _playerRankingTableView.setItems(_playersRankingList);
    }

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    public void initView() {
        initTableView();
    }

    public void setPresenter(RankingPresenter presenter) {
        _presenter = presenter;
    }

    public static RankingView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RankingView.class.getResource("Ranking.fxml"), LoginMain.getMessageBundle());
        fxmlLoader.setLocation(RankingView.class.getResource("Ranking.fxml"));
        Parent root = fxmlLoader.load();
        final RankingView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 387.0, 287.0);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        view.initView();
        return view;
    }
}
