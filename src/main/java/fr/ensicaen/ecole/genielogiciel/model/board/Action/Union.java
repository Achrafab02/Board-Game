package fr.ensicaen.ecole.genielogiciel.model.board.Action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Union extends ComplexAction {
    public Union(Action... actions) {
        super(actions);
    }

    @Override
    public void performAction(Player player) {
        for (Action action : getActions()) {
            action.performAction(player);
        }
    }
}
