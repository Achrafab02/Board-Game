package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PawnView {

    private final Rectangle _rectangle;
    private double _offsetX = 0;
    private double _offsetY = 0;

    private static final Color[] PLAYERS_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};

    private static final double SPACE_BETWEEN_PAWNS = 40;

    private static float RECTANGLE_SIZE = 20f;

    public void initPawn(AnchorPane board, int id) {
        board.getChildren().add(_rectangle);
        _rectangle.setFill(PLAYERS_COLORS[id]);
        initOffset(id);
    }

    private void initOffset(int id) {
        switch (id) {
            case 1 -> _offsetX = SPACE_BETWEEN_PAWNS;
            case 2 -> _offsetY = SPACE_BETWEEN_PAWNS;
            case 3 -> {
                _offsetX = SPACE_BETWEEN_PAWNS;
                _offsetY = SPACE_BETWEEN_PAWNS;
            }
            default -> {}
        }
    }

    public PawnView() {
        _rectangle = new Rectangle();
        _rectangle.setX(_offsetX);
        _rectangle.setY(_offsetY);
        _rectangle.setWidth(RECTANGLE_SIZE);
        _rectangle.setHeight(RECTANGLE_SIZE);
        _rectangle.setFill(Color.RED);
    }

    public void updatePosition(double x, double y) {
        _rectangle.setX(x + _offsetX);
        _rectangle.setY(y + _offsetY);
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
