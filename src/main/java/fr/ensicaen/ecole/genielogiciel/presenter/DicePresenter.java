package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.DeterministicDice;
import fr.ensicaen.ecole.genielogiciel.model.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import javafx.scene.layout.AnchorPane;

public class DicePresenter {
    private DiceView _view;
    private final Rollable _model; // FIXME pas très bien nommé : _model preférer dice ?

    public DicePresenter() {     // FIXME ne pas mettre de code non utilisé dans la version en production
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
}
