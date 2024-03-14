package edu.badpals.brunos.rounds;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegularRoundTest {

    @Test
    public void testBoxerRoundScore(){
        RegularRound round = new RegularRound("10 - 9");
        round.boxerRoundScore();
        assertEquals("10",round.getRedBoxerScore());
        assertEquals("9",round.getBlueBoxerScore());

    }

}