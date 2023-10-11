package fr.ensicaen.ecole.genielogiciel.model.board.Action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction implements Action {
    private final List<Action> _actions = new ArrayList<>();

    public void addAction(Action action) {
        _actions.add(action);
    }

    public void addMultipleActions(Action ... actions) {
        for (Action action : actions) {
            addAction(action);
        }
    }

    @Override
    public void performAction(Player player) {
        for (Action action : _actions) {
            action.performAction(player);
        }
    }
}
