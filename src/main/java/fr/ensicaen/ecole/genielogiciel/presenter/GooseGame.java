package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.model.Schooling;

import java.util.ArrayList;

public class GooseGame {     // FIXME ne pas mettre de code non utilisé dans la version en production

    public GooseGame(ArrayList<Schooling> schoolings) { // FIXME préferer une abstraction à une implémentation
        for (int i = 0; i < schoolings.size(); i++) {
            Schooling schooling = schoolings.get(i);
            Player player = schooling.createPlayer();
        }
    }

    public void init() {
        //WINDOW INITIALIZATION
    }

    public void start() {
        //NEED HARDSKILL??
        //NEED SCHOOLING
        //GET PLAYER(S)
        //CREATE PAWNS

    }
}
