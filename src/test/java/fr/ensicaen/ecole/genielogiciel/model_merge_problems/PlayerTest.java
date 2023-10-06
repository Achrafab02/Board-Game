package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

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