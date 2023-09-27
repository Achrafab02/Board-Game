package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;

public class NoTraining implements Schooling{

    @Override
    public Player createPlayer() {
        return new Player(new ArrayList<>());
    }
}
