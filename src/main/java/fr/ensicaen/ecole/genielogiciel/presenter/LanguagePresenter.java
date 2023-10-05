package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.LanguageView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;

public class LanguagePresenter {
    private LanguageView _view;

    public void setView(LanguageView view) {
        _view = view;
    }

    public void launchGame() {
        try {
            createAndDisplayGameView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAndDisplayGameView() throws IOException {
        SetupView view = SetupView.createView();
        SetupPresenter setupPresenter = new SetupPresenter();
        view.setPresenter(setupPresenter);
        setupPresenter.setView(view);
        _view.close();
        view.show();
    }
}
