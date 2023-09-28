package fr.ensicaen.ecole.genielogiciel.presenter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PawnPresenter extends javafx.scene.Node {
    public static Rectangle create() {
        Rectangle pawn = new Rectangle();
        pawn.setX(50.0f);
        pawn.setY(50.0F);
        pawn.setWidth(10.0f);
        pawn.setHeight(10.0f);
        pawn.setFill(Color.RED);
        return pawn;
    }
}
