package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.LanguageView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;

public class LanguagePresenter {
    private LanguageView _view;

    public void setView(LanguageView view) {
        _view = view;
    }

    public void launchSetup() {
        try {
            createAndDisplaySetupView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAndDisplaySetupView() throws IOException {
        SetupView view = SetupView.createView();
        SetupPresenter setupPresenter = new SetupPresenter();
        view.setPresenter(setupPresenter);
        setupPresenter.setView(view);
        view.show();
    }

    public void launchFrenchSetup() {
        try {
            createAndDisplaySetupView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    public void launchEnglishSetup() {
        try {
            createAndDisplaySetupView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }
}
