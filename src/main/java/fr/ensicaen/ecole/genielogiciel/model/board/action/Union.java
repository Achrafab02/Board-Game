package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Union extends ComplexAction { // FIXME on aurait bien vu un décorateur ici
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
