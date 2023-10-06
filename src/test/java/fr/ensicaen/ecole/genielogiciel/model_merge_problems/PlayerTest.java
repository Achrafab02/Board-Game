package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void TestChooseSoftSkillsAtRandom() {
        Player player = new Player();
        SoftSkill skill = player.chooseSoftSkillAtRandom();
        //System.out.println();
        assertTrue(skill instanceof SoftSkill);

    }

    @Test
    void test_constructor_hardskills() {
        int level = 3;
        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new ComputerScience(level));
        hardSkillsList.add(new Mathematics(level));
    }



}