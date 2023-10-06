package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Rollable;
import fr.ensicaen.ecole.genielogiciel.view.DiceView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DicePresenterTest {
    @Test
    void rollTest(){
        Rollable rollD = new Rollable() {
            @Override
            public int roll() {
                return 0;
            }
        };
        rollD.roll();

        DicePresenter dice = new DicePresenter(rollD);
        assertEquals(dice.getmModelRoll(),rollD.roll());
    }
}
