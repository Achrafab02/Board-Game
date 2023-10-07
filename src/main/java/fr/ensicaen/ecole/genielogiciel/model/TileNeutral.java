package fr.ensicaen.ecole.genielogiciel.model;

public class TileNeutral implements Tile {
    public Action getMoveInstruction(Player player) {
        return new Action();
    }
}
