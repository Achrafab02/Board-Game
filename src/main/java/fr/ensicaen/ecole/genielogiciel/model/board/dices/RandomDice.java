package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.Random;
import java.util.ResourceBundle;

public class RandomDice implements Rollable {
    private static final ResourceBundle BUNDLE = LoginMain.getMessageBundle();
    private final Random _randomGenerator;
    private final int _lowerInterval;
    private final int _upperInterval;

    RandomDice(Random randomGenerator, int lower, int upper) {
        if (upper < lower) {
            String errorMessage = BUNDLE.getString("error.empty.interval.1")
                    + " [" + lower + ", " + upper + "] "
                    + BUNDLE.getString("error.empty.interval.2");
            throw new IllegalArgumentException(errorMessage);
        }
        _randomGenerator = randomGenerator;
        _lowerInterval = lower;
        _upperInterval = upper;
    }

    @Override
    public int roll() {
        return _lowerInterval + _randomGenerator.nextInt(_upperInterval - _lowerInterval + 1);
    }
}
