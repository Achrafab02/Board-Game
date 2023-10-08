package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathematicsTest {
    @Test
    void testMathematics(){
        Mathematics math = new Mathematics(3);
        int score = math.getScore();
        assertEquals(3,score);
    }
}
