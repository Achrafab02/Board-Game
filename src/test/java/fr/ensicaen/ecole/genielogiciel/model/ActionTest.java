package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void idle() {
        Action action = new Action();
        assertEquals(0, action.getMoveCount());
    }

    @Test
    void forward() {
        Action action = new Action(3);
        assertEquals(3, action.getMoveCount());
    }

    @Test
    void backward() {
        Action action = new Action(-2);
        assertEquals(-2, action.getMoveCount());
    }
    @Test
    void testSetMethod(){
        Action action = new Action(-2);
        action.setMoveCount(5);
        assertEquals(5,action.getMoveCount());
    }
}