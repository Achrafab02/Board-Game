package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.control.Label;

public class DiceModifierView {
    private final Label _diceModifier;

    public DiceModifierView(Label diceModifier) {
        _diceModifier = diceModifier;
    }

    public void display(double Modifier) {
        _diceModifier.setText("×" + Modifier);
    }
}
