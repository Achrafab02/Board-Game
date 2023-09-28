package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Rollable;

public class BoardController {
    private final DicePresenter _dice;

    public BoardController(DicePresenter dice) {
        _dice = dice;
    }

    void play(Player player) {
        int diceRoll = _dice.roll();
        // Player modification
        // Move
    }
}
