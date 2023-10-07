package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public final class GameView {
    private GamePresenter _presenter;
    public AnchorPane _board;
    public AnchorPane _diceBoard;
    private GamePresenter _boardController;
    private Stage _stage;

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("Board.fxml"), LoginMain.getMessageBundle());
        fxmlLoader.setLocation(GameView.class.getResource("Board.fxml"));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 844, 110);
        Stage stage = new Stage();
        scene.getStylesheets().add(Objects.requireNonNull(SetupView.class.getResource("styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        view._stage = stage;
        return view;
    }

    public void setPresenter(GamePresenter boardController) {
        _boardController = boardController;
    }

    public void show() {
        _stage.show();
    }

    @FXML
    private void rollDice() {
        _boardController.play();
    }

    public AnchorPane getBoard() {
        return _board;
    }

    public AnchorPane getDiceBoard() {
        return _diceBoard;
    }

    public void close() {
        _stage.close();
    }
}
