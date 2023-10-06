package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import java.util.ArrayList;


public class AST implements Schooling {

    @Override
    public Player createPlayer(String name) {
        ArrayList<HardSkill> tab = new ArrayList<>();
        tab.add(new ComputerScience(4));
        return new Player(name, tab, "ast");
    }
}
