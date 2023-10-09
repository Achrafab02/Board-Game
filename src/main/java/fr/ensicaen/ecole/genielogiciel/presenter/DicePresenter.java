package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDice;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;

public class DicePresenter {
    private DiceView _diceView;
    private final Rollable _dice;
    private int _currentDiceResult;

    public DicePresenter() {
        _dice = new RandomDice(1, 6);
    }

    public int rollDice() {
        _currentDiceResult = _dice.roll();
        return _currentDiceResult;
    }

    public void displayDiceImage() {
        _diceView.display(_currentDiceResult);
    }

    public void setView(DiceView diceView) {
        _diceView = diceView;
    }
}
