package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;

public class Player {
    private String _name;
    private final SoftSkill _softSkill;
    private ArrayList<HardSkill> _hardSkills;

    Player(String name, ArrayList<HardSkill> hardSkills) {
        _name = name;
        _softSkill = chooseSoftSkillAtRandom();
        _hardSkills = hardSkills;
    }

    Player(String name, ArrayList<HardSkill> hardSkills, SoftSkill softSkill) {
        _name = name;
        _softSkill = softSkill;
        _hardSkills = hardSkills;
    }

    private SoftSkill chooseSoftSkillAtRandom() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> new Dabbler();
            case 1 -> new Rigorous();
            default -> new Brilliant();
        };
    }
}
