package fr.ensicaen.ecole.genielogiciel.model;

public class Mathematics implements HardSkill {
    private int _level = 0;

    public Mathematics() {

    }

    public Mathematics(int score) {
        _level = score;
    }

    @Override
    public int getLevel() {
        return _level;
    }

    @Override
    public void increaseLevel(int score) {
        _level = score;
    }


}
