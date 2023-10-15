package fr.ensicaen.ecole.genielogiciel.model.player.schooling;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrepaTest {
    @Test
    public void test_create_player() {
        Prepa prepa = new Prepa();

        String playerName = "NomDuJoueur";
        String schoolingName = "NomDeLaFormation";
        Player player = prepa.createPlayer(playerName, schoolingName);

        assertEquals(playerName, player.getName());

        assertEquals(schoolingName, player.getSchooling());

        List<HardSkill> skills = player.getHardSkills();
        for (HardSkill skill : skills) {
            if (skill instanceof ComputerScience) {
                assertEquals(0, skill.getScore());
            }
            if (skill instanceof Mathematics) {
                assertEquals(4, skill.getScore());
            }
        }
    }
}