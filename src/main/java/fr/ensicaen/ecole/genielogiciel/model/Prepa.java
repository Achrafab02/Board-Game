package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;

public class Prepa implements Schooling {
    @Override
    public Player createPlayer(String name) {
        ArrayList<HardSkill> tab = new ArrayList<>();
        tab.add(new Mathematics(4));
        return new Player(name, tab, "prepa");
    }
}
