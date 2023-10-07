package fr.ensicaen.ecole.genielogiciel.model.hardskills;

public interface HardSkill {
    int getScore();

    void setScore(int score);

    void addToScore(int scoreToAdd);
}
