package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.LanguageView;

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
        LanguageView view = LanguageView.createView();
        LanguagePresenter languagePresenter = new LanguagePresenter();
        view.setPresenter(languagePresenter);
        languagePresenter.setView(view);
        _view.close();
        view.show();
    }
}
