package fr.ensicaen.ecole.genielogiciel.model.player.hardskills;

public abstract class HardSkill {
    private int _score;

    public HardSkill(int score) {
        _score = score;
    }

    public int getScore() {
        return _score;
    }

    public void setScore(int score) {
        _score = score;
    }

    public void addToScore(int scoreToAdd) {
        _score = Math.max(_score + scoreToAdd, 0);
    }
}
