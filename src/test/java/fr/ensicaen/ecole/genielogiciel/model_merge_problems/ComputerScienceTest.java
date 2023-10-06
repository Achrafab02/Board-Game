package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerScienceTest {
    @Test
    void testgetscore(){
        ComputerScience cs = new ComputerScience(45);
        assertEquals(45,cs.getScore());
    }
    @Test
    void testsetscore(){
        ComputerScience cs = new ComputerScience(45);
        cs.setScore(50);
        assertEquals(50,cs.getScore());
    }
}
