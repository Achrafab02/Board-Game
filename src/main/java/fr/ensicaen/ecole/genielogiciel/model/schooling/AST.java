package fr.ensicaen.ecole.genielogiciel.model.schooling;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.HardSkill;

import java.util.ArrayList;


public class AST implements Schooling {

    @Override
    public Player createPlayer(String name) {
        ArrayList<HardSkill> tab = new ArrayList<>();
        tab.add(new ComputerScience(4));
        return new Player(name, tab, "ast");
    }
}
