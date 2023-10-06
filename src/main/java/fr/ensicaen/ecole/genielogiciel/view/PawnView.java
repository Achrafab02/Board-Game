package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PawnView {
    public static Rectangle create() {

        Rectangle pawn = new Rectangle();
        pawn.setX(50.0f);
        pawn.setY(50.0f);
        pawn.setWidth(10.0f);
        pawn.setHeight(10.0f);
        pawn.setFill(Color.RED);
        return pawn;
    }
}
