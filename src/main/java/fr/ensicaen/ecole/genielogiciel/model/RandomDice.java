package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Random;

public class RandomDice implements Rollable {
    private final Random _randomGenerator;

    public RandomDice(int value, long seed) {
        _randomGenerator = new Random(seed);
    }

    @Override
    public int roll() {
        return _randomGenerator.nextInt(1, 6);
    }
}
