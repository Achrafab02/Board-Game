package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class DeterministicDice implements Rollable {
    private final int _fixedValue;

    public DeterministicDice() {
        _fixedValue = 2;
    }

    public DeterministicDice(int value) {
        _fixedValue = value;
    }

    @Override
    public int roll() {
        return _fixedValue;
    }
}
