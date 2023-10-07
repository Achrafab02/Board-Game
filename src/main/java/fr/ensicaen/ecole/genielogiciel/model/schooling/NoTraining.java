package fr.ensicaen.ecole.genielogiciel.model.schooling;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.HardSkill;

import java.util.ArrayList;

public class NoTraining implements Schooling {

    @Override
    public Player createPlayer(String name) {
        return new Player(name, new ArrayList<HardSkill>(), "noTraining");
    }
}
