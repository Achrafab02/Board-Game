package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;

public class SetupPresenter {

    private SetupView _view;

    public void setView( SetupView view ) {
        _view = view;
    }

    public void launchGame( String nickName ) {
        try {
            createAndDisplayGameView(nickName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAndDisplayGameView( String nickName ) throws IOException {
        GameView view = GameView.createView();
        GamePresenter gamePresenter = new GamePresenter(nickName);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        _view.close();
        view.show();
    }

}
