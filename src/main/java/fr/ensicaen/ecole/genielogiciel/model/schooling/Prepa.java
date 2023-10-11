package fr.ensicaen.ecole.genielogiciel.model.schooling;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;

import java.util.ArrayList;

public class Prepa implements Schooling {
    @Override
    public Player createPlayer(String name, String schoolingName) {
        ArrayList<HardSkill> tab = new ArrayList<>();
        tab.add(new Mathematics(4));
        return new Player(name, tab, "prepa");
    }
}
