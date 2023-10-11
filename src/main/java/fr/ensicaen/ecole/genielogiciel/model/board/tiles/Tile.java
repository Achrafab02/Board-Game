package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public abstract class Tile {
     private final int _positionIndex;
     private final Point _tileCoordinates;

     public Tile(int positionIndex, Point tileCoordinates) {
          _positionIndex = positionIndex;
          _tileCoordinates = tileCoordinates;
     }

     public abstract Action fetchInstruction(Player player);

     public int getPositionIndex() {
          return _positionIndex;
     }

     public Point getCoordinates() {
          return _tileCoordinates;
     }
}