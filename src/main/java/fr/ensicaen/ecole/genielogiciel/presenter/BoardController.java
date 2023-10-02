package fr.ensicaen.ecole.genielogiciel.presenter;
import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.RandomDice;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class BoardController {
    private final DicePresenter _dice;

    public BoardController(DicePresenter dice) {
        _dice = dice;
    }

    void play(Player player) {
        int diceRoll = _dice.roll();
        // Player modification
        // Move
    }
}
