package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import java.util.ArrayList;

public class NoTraining implements Schooling {

    @Override
    public Player createPlayer(String name) {
        return new Player(name, new ArrayList<HardSkill>(), "noTraining");
    }
}