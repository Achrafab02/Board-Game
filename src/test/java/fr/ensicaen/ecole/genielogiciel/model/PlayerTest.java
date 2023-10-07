package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.hardskills.Mathematics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PlayerTest {

    @Test
    void test_constructor_hardkills() {
        int level = 3;
        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new ComputerScience(level));
        hardSkillsList.add(new Mathematics(level));
    }



}