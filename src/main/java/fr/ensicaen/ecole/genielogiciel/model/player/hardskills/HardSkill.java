package fr.ensicaen.ecole.genielogiciel.model.player.hardskills;

public interface HardSkill {
    int getScore();

    void setScore(int score);

    void addToScore(int scoreToAdd);
}
