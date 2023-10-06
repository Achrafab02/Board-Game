package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class Mathematics implements HardSkill {
    private int _score = 0;

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


}
