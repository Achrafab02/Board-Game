package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class TileNeutral implements Tile {
    public Action getMoveInstruction(Player player) {
        return new Action();
    }
}
