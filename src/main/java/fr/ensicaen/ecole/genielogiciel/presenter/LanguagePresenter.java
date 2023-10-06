package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LanguageView;
import fr.ensicaen.ecole.genielogiciel.view.SetupView;

import java.io.IOException;
import java.util.ArrayList;

public class LanguagePresenter {
    private LanguageView _view;

    private static String _language = "en";

    public void setLanguage(String language) {
        _language = language;
    }

    public static String getLanguage() {
        return _language ;
    }

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
            setLanguage("fr");
            createAndDisplaySetupView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }

    public void launchEnglishSetup() {
        try {
            setLanguage("en");
            createAndDisplaySetupView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        _view.close();
    }
}
