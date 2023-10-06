package fr.ensicaen.ecole.genielogiciel.model;

public class Mathematics implements HardSkill {
    private int _score = 0;

    public Mathematics() {

    }

    public Mathematics(int score) {
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
