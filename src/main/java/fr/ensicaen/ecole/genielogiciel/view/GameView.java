package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.BoardController;

import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.SetupPresenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView {
    public AnchorPane _board;
    public AnchorPane _diceBoard;
    private GamePresenter _gamePresenter;
    private Stage _stage;

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(GameView.class.getResource("Board.fxml"));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 844, 110);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        return view;
    }

    public void setPresenter(GamePresenter gamePresenter) {
        _gamePresenter = gamePresenter;
        _gamePresenter.setPawn(_board);
    }

    public void show() {
        _stage.show();
    }

    @FXML
    private void rollDice() {
        _gamePresenter.movePawn(1);
    }

    public AnchorPane getBoard() {
        return _board;
    }

    public AnchorPane getDiceBoard() {
        return _diceBoard;
    }
}
