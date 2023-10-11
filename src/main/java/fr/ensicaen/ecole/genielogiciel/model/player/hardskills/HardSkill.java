package fr.ensicaen.ecole.genielogiciel.model.player.hardskills;

public interface HardSkill { // TODO : INTERFACE -> ABSTRACT
    int getScore();

    void setScore(int score);

    void addToScore(int scoreToAdd);
}
