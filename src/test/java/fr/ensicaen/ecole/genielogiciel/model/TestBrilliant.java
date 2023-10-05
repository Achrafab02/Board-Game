package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestBrilliant {
    @Test
    public void test_brilliant(){
        int value = 5;
        Brilliant  b = new Brilliant();
        assertEquals(10,b.modifyDiceRoll(value));
    }

}
