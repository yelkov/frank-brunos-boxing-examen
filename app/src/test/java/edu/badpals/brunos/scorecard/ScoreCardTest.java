package edu.badpals.brunos.scorecard;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreCardTest {

    @Test
    public void loadJudgeScoreCard(){
        String[] headers = {"Round 1", "Round 2", "Round 3", "Round 4", "Round 5",
                "Round 6", "Round 7", "Round 8", "Round 9", "Round 10"};

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
                }

        };
        ScoreCard whiteScoreCard = new ScoreCard("WHITE");
        whiteScoreCard.loadJudgeScoreCard(data[0]);

        assertEquals(10,whiteScoreCard.getNumRounds());


    }

}