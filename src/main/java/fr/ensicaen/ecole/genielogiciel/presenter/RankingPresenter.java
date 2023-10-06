package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model_merge_problems.Point;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.PawnView;
import fr.ensicaen.ecole.genielogiciel.view.RankingView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RankingPresenter {
    private RankingView _view;

    public void setView(RankingView view) {
        _view = view;
    }
}
