package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.DiceModifierView;

public class DiceModifierPresenter {
    private DiceModifierView _diceModifierView;

    public void display(double diceModifier) {
        _diceModifierView.display(diceModifier);
    }

    public void setView(DiceModifierView diceModifierView) {
        _diceModifierView = diceModifierView;
    }

    public DiceModifierView getView() {
        return _diceModifierView;
    }
}
