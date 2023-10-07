package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;

public class DicePresenter {
    private DiceView _diceView;

    public void displayDiceImage(int diceResult) {
        _diceView.display(diceResult);
    }

    public void setView(DiceView diceView) {
        _diceView = diceView;
    }
}
