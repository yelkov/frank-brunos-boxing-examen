package edu.badpals.brunos.scorecard;

import edu.badpals.brunos.rounds.KnockdownRound;
import edu.badpals.brunos.rounds.PointsDeducted;
import edu.badpals.brunos.rounds.RegularRound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreCardTest {
       private ScoreCard whiteScoreCard = null;
       private ScoreCard blueScoreCard = null;
       private ScoreCard pinkScoreCard = null;
       private ScoreCard twelveScoreCard = null;

        @Before
        public void setup(){
        String[][] data = {

            //  White ScoreCard
            {"9 - 10",
                    "9 - 10",
                    "9 - 10",
                    "9 - 10",
                    "10 - 9",
                    "10 - 9",
                    "10 - 9",
                    "9 - 10",
                    "10 - 9",
                    "9 - 10"},

            // Blue ScoreCard
            {"9 - 10",
                    "9 - 10",
                    "9 - 10",
                    "8 - 10", // knockdown
                    "10 - 8", // knockdown
                    "10 - 8",
                    "10 - 9",
                    "9 - 10",
                    "10 - 9",
                    "10 - 9"},

            // Pink ScoreCard
            {"9 - 10",
                    "9 - 10",
                    "9 - 10",
                    "1, 8 - 10", // referee point deduction
                    "10 - 8",    // knockdown
                    "10 - 8 ,1", // referee point deduction
                    "10 - 9",
                    "9 - 10",
                    "10 - 9",
                    "10 - 8" // knockdown
                },

                //12 rounds testing - PINK
                {"9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "1, 8 - 10", // referee point deduction
                        "10 - 8",    // knockdown
                        "10 - 8 ,1", // referee point deduction
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "10 - 8", // knockdown
                        "9 - 10",
                        "9 - 10"
                }
            };
        this.whiteScoreCard = new ScoreCard("WHITE");
        whiteScoreCard.loadJudgeScoreCard(data[0]);
        whiteScoreCard.setRCorner("Rocky Balboa");
        whiteScoreCard.setBCorner("Apollo Creed");

        this.blueScoreCard = new ScoreCard("BLUE");
        blueScoreCard.loadJudgeScoreCard(data[1]);
        blueScoreCard.setRCorner("Rocky Balboa");
        blueScoreCard.setBCorner("Apollo Creed");


        this.pinkScoreCard = new ScoreCard("PINK");
        pinkScoreCard.loadJudgeScoreCard(data[2]);
        pinkScoreCard.setRCorner("Rocky Balboa");
        pinkScoreCard.setBCorner("Apollo Creed");

        this.twelveScoreCard = new ScoreCard("PINK");
        twelveScoreCard.loadJudgeScoreCard(data[3]);
        twelveScoreCard.setRCorner("Rocky Balboa");
        twelveScoreCard.setBCorner("Apollo Creed");
        }

    @Test
    public void roundsLenght(){
            assertEquals(10,whiteScoreCard.getNumRounds());
            assertEquals(10,blueScoreCard.getNumRounds());
            assertEquals(10,pinkScoreCard.getNumRounds());
            assertEquals(12,twelveScoreCard.getNumRounds());
    }
    @Test
    public void firstRegularRoundScore(){
            assertTrue(whiteScoreCard.getRound(0) instanceof RegularRound);
            assertEquals(9,whiteScoreCard.getRound(0).getRedBoxerScore());
            assertEquals(10,whiteScoreCard.getRound(0).getBlueBoxerScore());
    }
    @Test
    public void KnockdownRoundScore(){
            assertTrue(blueScoreCard.getRound(3) instanceof KnockdownRound);
            assertEquals(8,blueScoreCard.getRound(3).getRedBoxerScore());
            assertEquals(10,blueScoreCard.getRound(3).getBlueBoxerScore());
    }
    @Test
    public void pointsDeductedScore(){
        assertTrue(pinkScoreCard.getRound(3) instanceof PointsDeducted);
        assertEquals(8,blueScoreCard.getRound(3).getRedBoxerScore());
        assertEquals(10,blueScoreCard.getRound(3).getBlueBoxerScore());
    }
    @Test
    public void totalScore(){
            assertEquals(94,whiteScoreCard.getRedBoxerFinalScore());
            assertEquals(96,whiteScoreCard.getBlueBoxerFinalScore());
            assertEquals(94,blueScoreCard.getRedBoxerFinalScore());
            assertEquals(93,blueScoreCard.getBlueBoxerFinalScore());
            assertEquals(94,pinkScoreCard.getRedBoxerFinalScore());
            assertEquals(92,pinkScoreCard.getBlueBoxerFinalScore());
            assertEquals(112,twelveScoreCard.getRedBoxerFinalScore());
            assertEquals(112,twelveScoreCard.getBlueBoxerFinalScore());
    }
    @Test
    public void winner(){
            assertEquals("Apollo Creed",whiteScoreCard.getWinner());
            assertEquals("Rocky Balboa",blueScoreCard.getWinner());
            assertEquals("Rocky Balboa",pinkScoreCard.getWinner());
            assertEquals("Tie",twelveScoreCard.getWinner());
    }

}