package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class ComputerScience implements HardSkill {
    private int _score = 0;

    public ComputerScience() {
    }

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

    @Override
    public void addToScore(int scoreToAdd) {
        _score = Math.max(_score + scoreToAdd, 0);
    }
}