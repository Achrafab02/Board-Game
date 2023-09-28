package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.DeterministicDice;
import fr.ensicaen.ecole.genielogiciel.model.Rollable;

public class DicePresenter {
    //private final DiceView _view;
    private final Rollable _model;

    public DicePresenter() {
        //_view = view;
        _model = new DeterministicDice();
    }

    public DicePresenter(Rollable dice) {
        //_view = view;
        _model = dice;
    }

    public void roll() {
        _model.roll();
        //_view.display(_model.getValue());
    }
}
