package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;

public class Player {
    private String _name;
    private final SoftSkill _softSkill;
    private ArrayList<HardSkill> _hardSkills;
    private String _schoolingName;

    public Player(String name, ArrayList<HardSkill> hardSkills, String schoolingName) {
        _name = name;
        _softSkill = chooseSoftSkillAtRandom();
        _hardSkills = hardSkills;
        _schoolingName = schoolingName;
    }

    Player() {
        _softSkill = chooseSoftSkillAtRandom();
    }

    Player(String name, ArrayList<HardSkill> hardSkills, SoftSkill softSkill, String schoolingName) {
        _name = name;
        _softSkill = softSkill;
        _hardSkills = hardSkills;
        _schoolingName = schoolingName;
    }

    public SoftSkill chooseSoftSkillAtRandom() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> new Dabbler();
            case 1 -> new Rigorous();
            default -> new Brilliant();
        };
    }

    public String getSchooling() {
        return _schoolingName;
    }

    public String getName() {
        return _name;
    }
}
