package fr.ensicaen.ecole.genielogiciel.model.board.action;

public abstract class ComplexAction implements Action {
    private final Action[] _actions;

    public ComplexAction(Action... actions) {
        _actions = actions;
    }

    public Action[] getActions() {
        return _actions;
    }
}
