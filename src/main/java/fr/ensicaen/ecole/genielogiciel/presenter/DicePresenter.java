package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.DeterministicDice;
import fr.ensicaen.ecole.genielogiciel.model.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import javafx.scene.layout.AnchorPane;

public class DicePresenter {
    private DiceView _diceView;
    private final Rollable _dice;

    //TODO : THIS SHOULDN'T BE CALLED, USE DicePresenter(Rollable dice, DiceView view) INSTEAD
    public DicePresenter(Rollable dice) {
        _dice = dice;
    }

    public DicePresenter(Rollable dice, DiceView view) {
        _diceView = view;
        _dice = dice;
    }

    //TODO : MUST BE MOVED INTO THE VIEW -> javaFX => View
    public void setDiceBoard(AnchorPane diceBoard) {
        _diceView = new DiceView(diceBoard);
    }

    public int roll() {
        int nb = _dice.roll();
        _diceView.display(nb);
        return nb;
    }
}
