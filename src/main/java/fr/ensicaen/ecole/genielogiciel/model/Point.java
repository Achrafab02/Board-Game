package fr.ensicaen.ecole.genielogiciel.model;

public class Point { // FIXME dans le rapport, il est écrit qu'il s'agit d'un Messager ... mais en fait non (décalage entre docuentation et code !)
    private final int _x;
    private final int _y;

    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX(){
        return _x;
    }

    public int getY(){
        return _y;
    }
}
