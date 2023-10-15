package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.RandomDiceBuilder;
import fr.ensicaen.ecole.genielogiciel.model.board.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;

public class DicePresenter {
    private DiceView _diceView;
    private Rollable _dice;

    public DicePresenter() {
        _dice = new RandomDiceBuilder().withInterval(1, 6).build();
    }

    public int rollDice() {
        int currentDiceResult = _dice.roll();
        _diceView.display(currentDiceResult);
        return currentDiceResult;
    }

    public void setView(DiceView diceView) {
        _diceView = diceView;
    }

    public void setDice(Rollable dice) {
        _dice = dice;
    }
}
