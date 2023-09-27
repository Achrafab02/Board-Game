package fr.ensicaen.ecole.genielogiciel.presenter;

public class BoardController {
    private final Rollable _dice;

    public BoardController(Rollable dice) {
        _dice = dice;
    }

    void play(Player player) {
        int diceRoll = _dice.roll();
        //Move
    }
}
