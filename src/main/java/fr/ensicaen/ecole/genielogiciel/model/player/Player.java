package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Brilliant;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Dabbler;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.Rigorous;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.SoftSkill;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Player {
    private final String _name;
    private final SoftSkill _softSkill;
    private ArrayList<HardSkill> _hardSkills;
    private final String _schoolingName;

    public Player(String name, String schoolingName) {
        _name = name;
        _softSkill = chooseSoftSkillAtRandom();
        _hardSkills = new ArrayList<>();
        _schoolingName = schoolingName;
    }

    public Player(String name, ArrayList<HardSkill> hardSkills, String schoolingName) {
        _name = name;
        _softSkill = chooseSoftSkillAtRandom();
        _hardSkills = hardSkills;
        _schoolingName = schoolingName;
    }

    private SoftSkill chooseSoftSkillAtRandom() {
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

    public int getHardSkillLevel(Class<? extends HardSkill> subject) {
        for (HardSkill skill: _hardSkills) {
            if (skill.getClass() == subject) {
                return skill.getScore();
            }
        }
        return 0;
    }

    public void setHardSkillLevel(Class<? extends HardSkill> subject, int score) {
        for (HardSkill skill: _hardSkills) {
            if (skill.getClass() == subject) {
                skill.setScore(score);
                return;
            }
        }
        try {
            HardSkill skill = subject.getConstructor().newInstance();
            skill.setScore(score);
            _hardSkills.add(skill);

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToLevelOfHardSkill(Class<? extends HardSkill> subject, int scoreToAdd) {
        for (HardSkill skill: _hardSkills) {
            if (skill.getClass() == subject) {
                skill.addToScore(scoreToAdd);
                return;
            }
        }
        setHardSkillLevel(subject, scoreToAdd);
    }
}
