package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model_merge_problems.DeterministicDice;
import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import javafx.scene.layout.AnchorPane;

public class DicePresenter {
    private DiceView _view;
    private final Rollable _model;

    public DicePresenter() {
        //_view = view;
        _model = new DeterministicDice();
    }

    public DicePresenter(Rollable dice) {
        //_view = view;
        _model = dice;
    }

    public void setDiceBoard(AnchorPane diceBoard) {
        _view = new DiceView(diceBoard);
    }

    public int roll() {
        int nb = _model.roll();
        _view.display(nb);
        return nb;
    }
    public int getmModelRoll(){
        return _model.roll();
    }
}
