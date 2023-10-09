package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class TileMathExam implements Tile {
    public Action fetchInstruction(Player player) {
        Action action = new Action();
        if(player.getHardSkillLevel(Mathematics.class) < 4) {
            action._moveCount = -2;
        }
        return action;
    }
}
