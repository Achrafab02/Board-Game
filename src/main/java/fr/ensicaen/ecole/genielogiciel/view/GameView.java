package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.BoardController;

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
    private BoardController _boardController;
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

    public void setPresenter(BoardController boardController) {
        _boardController = boardController;
        _boardController.create_pawn(4);
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
}
