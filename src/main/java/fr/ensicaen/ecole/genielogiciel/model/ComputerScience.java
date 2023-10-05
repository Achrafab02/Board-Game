package fr.ensicaen.ecole.genielogiciel.model;

public class ComputerScience implements HardSkill {
    private int _score = 0;

    public ComputerScience() {
    }

    // FIXME ne pas mettre de code non utilisé dans la version en production
    public ComputerScience(int score) {
        _score = score;
    }

    @Override
    public int getScore() {
        return _score;
    }

    @Override
    public void setScore(int score) {
        _score = score;
    }
}
