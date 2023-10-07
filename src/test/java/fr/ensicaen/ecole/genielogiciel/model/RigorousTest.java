package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.softskills.Rigorous;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RigorousTest {
    @Test
    void test_rigorous(){
        int value = 5;
        Rigorous b = new Rigorous();
        assertEquals(5,b.modifyDiceRoll(value));
    }
}
