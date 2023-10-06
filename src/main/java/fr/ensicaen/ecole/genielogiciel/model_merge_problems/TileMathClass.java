package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class TileMathClass implements Tile {
    public Action getMoveInstruction(Player player) {
        Action action = new Action();
        player.addToLevelOfHardSkill(Mathematics.class, 1);
        return action;
    }
}
