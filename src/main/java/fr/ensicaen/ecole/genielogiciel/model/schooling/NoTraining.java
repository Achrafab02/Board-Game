package fr.ensicaen.ecole.genielogiciel.model.schooling;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;

import java.util.ArrayList;

public class NoTraining implements Schooling {

    @Override
    public Player createPlayer(String name) {
        return new Player(name, new ArrayList<HardSkill>(), "noTraining");
    }
}
