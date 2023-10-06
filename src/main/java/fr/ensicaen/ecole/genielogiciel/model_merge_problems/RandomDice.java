package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import java.util.Random;

public class RandomDice implements Rollable {
    private final Random _randomGenerator;
    private final int _lowerInterval;
    private final int _upperInterval;

    public RandomDice() {
        _randomGenerator = new Random();
        _lowerInterval = 1;
        _upperInterval = 6;
    }

    public RandomDice(long seed) {
        _randomGenerator = new Random(seed);
        _lowerInterval = 1;
        _upperInterval = 6;
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
        return _lowerInterval + _randomGenerator.nextInt(_upperInterval);
    }
}
