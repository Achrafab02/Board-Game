package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.dices.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DicePresenterTest {

    @Test
    public void test_roll_dice() {
        DicePresenter presenter = new DicePresenter();

        DiceView view = mock(DiceView.class);

        presenter.setView(view);

        Rollable dice = mock(Rollable.class);
        when(dice.roll()).thenReturn(4);

        presenter.setDice(dice);

        int result = presenter.rollDice();

        verify(view).display(4);

        assertEquals(4, result);
    }
}
