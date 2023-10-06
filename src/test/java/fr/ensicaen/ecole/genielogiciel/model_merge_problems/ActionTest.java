package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void idle() {
        Action action = new Action();
        assertEquals(0, action._moveCount);
    }

    @Test
    void forward() {
        Action action = new Action(3);
        assertEquals(3, action._moveCount);
    }

    @Test
    void backward() {
        Action action = new Action(-2);
        assertEquals(-2, action._moveCount);
    }
    @Test
    void testSetMethod(){
        Action action = new Action(-2);
        action._moveCount = 5;
        assertEquals(5,action._moveCount);
    }
}