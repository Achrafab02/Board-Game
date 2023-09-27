package fr.ensicaen.ecole.genielogiciel.presenter;

public class Pawn {
    private static final int MOVE_Y = 0;
    private static final int MOVE_X = 110;
    private final Player _player;
    private int _x = 0;

    public Pawn(Player player) {
        _player = player;
    }
    
    public Pawn(Player player, int x, int y) {
        _player = player;
        _x = x;
    }

    public void move(int numberOfTile) {
        _x += numberOfTile * MOVE_X;
        //_y += numberOfTile * MOVE_Y;
    }

    public int get_x() {
        return _x;
    }
}
