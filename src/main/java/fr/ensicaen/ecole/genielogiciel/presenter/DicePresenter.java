package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;

public class DicePresenter {
    private DiceView _diceView;
    private final Rollable _dice;

    public DicePresenter(Rollable dice) {
        _dice = dice;
    }

    public int roll() {
        int nb = _dice.roll();
        _diceView.display(nb);
        return nb;
    }

    public void setView(DiceView diceView) {
        _diceView = diceView;
    }
}
