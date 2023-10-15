package fr.ensicaen.ecole.genielogiciel.presenter;

import static org.junit.jupiter.api.Assertions.*;
import fr.ensicaen.ecole.genielogiciel.view.DiceModifierView;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class DiceModifierPresenterTest {

    @Test
    public void test_display() {
        DiceModifierPresenter presenter = new DiceModifierPresenter();

        DiceModifierView view = mock(DiceModifierView.class);

        presenter.setView(view);

        double diceModifier = 1.5;
        presenter.display(diceModifier);

        verify(view).display(diceModifier);
    }

    @Test
    public void test_set_view() {
        DiceModifierPresenter presenter = new DiceModifierPresenter();

        DiceModifierView view = mock(DiceModifierView.class);

        presenter.setView(view);

        assertEquals(view, presenter.getView());
    }
}
