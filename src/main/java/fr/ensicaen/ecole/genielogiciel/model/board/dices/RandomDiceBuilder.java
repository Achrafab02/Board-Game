package fr.ensicaen.ecole.genielogiciel.model.board.dices;

import java.util.Optional;
import java.util.Random;

public class RandomDiceBuilder {
    private final static int CLASSIC_DICE_MIN_VALUE = 1;
    private final static int CLASSIC_DICE_MAX_VALUE = 6;

    private Optional<Long> _optionalSeed = Optional.empty();
    private int _lower = CLASSIC_DICE_MIN_VALUE;
    private int _upper = CLASSIC_DICE_MAX_VALUE;

    public RandomDiceBuilder withSeed(long seed) {
        _optionalSeed = Optional.of(seed);
        return this;
    }

    public RandomDiceBuilder withInterval(int lower, int upper) {
        _lower = lower;
        _upper = upper;
        return this;
    }

    public RandomDice build() {
        Random randomGenerator = _optionalSeed.map(Random::new).orElseGet(Random::new);
        return new RandomDice(randomGenerator, _lower, _upper);
    }
}
