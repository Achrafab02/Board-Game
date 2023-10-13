package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.*;

public class BoardPresenter {
    private static final Tile[] HARD_CODED_BOARD = new Tile[]{
            new TileNeutral(0, new Point(365, 220)),
            new TileNeutral(1, new Point(290, 370)),
            new TileMathClass(2, new Point(315, 580)),
            new TileComputerScienceClass(3, new Point(480, 665)),
            new TileNeutral(4, new Point(680, 550)),
            new TileWEI(5, new Point(730, 390)),
            new TileComputerScienceExam(6, new Point(810, 200)),
            new TileMathExam(7, new Point(1040, 170)),
            new TileNeutral(8, new Point(1190, 270)),
            new TileRetakeExam(9, new Point(1170, 520)),
            new TileNeutral(10, new Point(1040, 605))
    };
    private static final Tile[] _tiles = HARD_CODED_BOARD;
    private static final int LAST_TILES = 10;

    public Tile getTile(int tileIndex) {
        return _tiles[tileIndex];
    }

    public static int getLastTileIndex() {
        return LAST_TILES;
    }

}
