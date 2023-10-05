package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class DiceView { // FIXME mettre la classe en final
    public AnchorPane _diceBoard; // FIXME mettre en final

    public DiceView(AnchorPane diceBoard) {
        _diceBoard = diceBoard;
    }


    public void display(int nb) {
        _diceBoard.setBackground(new Background(new BackgroundImage(new Image("fr/ensicaen/ecole/genielogiciel/view/dice/dice-" + nb + ".png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(86, 86, false, false, false, false))));
    }
}
