package fr.ensicaen.ecole.genielogiciel.model;

public class TileMathExam implements Tile {
    public Action getMoveInstruction(Player player) {
        Action action = new Action();
        if(player.getHardSkillLevel(Mathematics.class) < 4) {
            action._moveCount = -2;
        }
        return action;
    }
}
