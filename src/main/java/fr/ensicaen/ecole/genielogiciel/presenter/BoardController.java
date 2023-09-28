package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Rollable;

public class BoardController {
    private final Rollable _dice;

    public BoardController(Rollable dice) {
        _dice = dice;
    }

    void play(Player player) {
        int diceRoll = _dice.roll();
        // Player modification
        // Move
    }
}
