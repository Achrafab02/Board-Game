package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDiceBuilder;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;

public class DicePresenter {
    private DiceView _diceView;
    private final Rollable _dice;
    private int _currentDiceResult;

    public DicePresenter() {
        _dice = new RandomDiceBuilder().withInterval(1, 6).build();
    }

    public int rollDice() {
        _currentDiceResult = _dice.roll();
        _diceView.display(_currentDiceResult);
        return _currentDiceResult;
    }

    public void setView(DiceView diceView) {
        _diceView = diceView;
    }
}
