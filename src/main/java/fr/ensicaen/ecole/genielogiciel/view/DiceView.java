package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class DiceView {
    private final AnchorPane _diceBoard;
    private final String IMAGE_LOCATION = "fr/ensicaen/ecole/genielogiciel/view/dice/dice-";
    private final String IMAGE_TYPE = ".png";

    public DiceView(AnchorPane diceBoard) {
        _diceBoard = diceBoard;
    }

    public void display(int nb) {
        Image image = new Image(IMAGE_LOCATION + nb + IMAGE_TYPE);
        BackgroundSize backgroundSize = new BackgroundSize(86, 86, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        _diceBoard.setBackground(background);
    }
}
