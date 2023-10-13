package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import java.util.Random;

public class RandomDice implements Rollable {
    private final Random _randomGenerator;
    private final int _lowerInterval;
    private final int _upperInterval;
    private static final int CLASSIC_DICE_MIN_VALUE = 1;
    private static final int CLASSIC_DICE_MAX_VALUE = 6;

    public RandomDice() {
        _randomGenerator = new Random();
        _lowerInterval = CLASSIC_DICE_MIN_VALUE;
        _upperInterval = CLASSIC_DICE_MAX_VALUE;
    }

    public RandomDice(long seed) {
        _randomGenerator = new Random(seed);
        _lowerInterval = CLASSIC_DICE_MIN_VALUE;
        _upperInterval = CLASSIC_DICE_MAX_VALUE;
    }

    public RandomDice(int lowerInterval, int upperInterval) {
        _randomGenerator = new Random();
        _lowerInterval = lowerInterval;
        _upperInterval = upperInterval;
    }

    public RandomDice(long seed, int lowerInterval, int upperInterval) {
        _randomGenerator = new Random(seed);
        _lowerInterval = lowerInterval;
        _upperInterval = upperInterval;
    }

    @Override
    public int roll() {
        return _lowerInterval + _randomGenerator.nextInt(_upperInterval - _lowerInterval + 1);
    }
}
