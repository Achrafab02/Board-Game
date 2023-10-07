package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PawnView {
    public static Rectangle create(double x, double y, Color color) {
        Rectangle pawn = new Rectangle();
        pawn.setX(x);
        pawn.setY(y);
        pawn.setWidth(10.0f);
        pawn.setHeight(10.0f);
        pawn.setFill(color);
        return pawn;
    }
}
