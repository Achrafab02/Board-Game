package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PawnView {

    private final Rectangle _rectangle;
    private final double _offsetX = 0;
    private final double _offsetY = 0;

    public void initPawn(AnchorPane board) {
        board.getChildren().add(_rectangle);
    }

    public PawnView() {
        _rectangle = new Rectangle();
        _rectangle.setX(_offsetX);
        _rectangle.setY(_offsetY);
        _rectangle.setWidth(20.0f);
        _rectangle.setHeight(20.0f);
        _rectangle.setFill(Color.RED);
    }

    public void updatePosition(double x, double y) {
        _rectangle.setX(x);
        _rectangle.setY(y);
    }

    public static Rectangle create(double x, double y, Color color) {
        Rectangle pawn = new Rectangle();
        pawn.setX(x);
        pawn.setY(y);
        pawn.setWidth(20.0f);
        pawn.setHeight(20.0f);
        pawn.setFill(color);
        return pawn;
    }
}
