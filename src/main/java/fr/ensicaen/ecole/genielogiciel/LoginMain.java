package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.presenter.*;
import fr.ensicaen.ecole.genielogiciel.view.LanguageView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ResourceBundle;

// FIXME GitLab Le readme ne sert à rien. IL ne décrit pas le projet ni les auteurs du projet ni les instructions d'utilisation du projet
// FIXME le dossier .gradle ne doit pas être inclus dans le git
public final class LoginMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static ResourceBundle getMessageBundle() {
        if (LanguagePresenter.getLanguage().equals("fr")) {
            return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
        }
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle_en_US");
    }

    @Override
    public void start( final Stage primaryStage ) throws Exception {
        LanguageView view = LanguageView.createView(primaryStage, "Language.fxml");
        LanguagePresenter presenter = new LanguagePresenter();
        view.setPresenter(presenter);
        presenter.setView(view);
        view.show();
    }
}
