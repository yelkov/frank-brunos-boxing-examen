package edu.badpals.brunos.scorecard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatTest {
        /*
        this.decisionDividida = new Combat("Rocky Balboa","Rocky Balboa","Apollo Creed");
        this.decisionMayoria = new Combat("Rocky Balboa","Rocky Balboa","Tie");
        this.empate = new Combat("Rocky Balboa","Apollo Creed","Tie");
        this.empateUnanime = new Combat("Tie","Tie","Tie");
        this.empateMayoritario = new Combat("Tie","Tie","Rocky Balboa");
        */
    @Test
    public void unanime(){
        String[][] dataUnanime = {

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
                        "9 - 10",
                        "10 - 9",
                        "10 - 9",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10"},

                // Pink ScoreCard
                {"9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "10 - 9",
                        "10 - 9",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10"
                },

        };
        ScoreCard whiteScoreCard = new ScoreCard("WHITE");
        whiteScoreCard.loadJudgeScoreCard(dataUnanime[0]);
        whiteScoreCard.setRCorner("Rocky Balboa");
        whiteScoreCard.setBCorner("Apollo Creed");

        ScoreCard blueScoreCard = new ScoreCard("BLUE");
        blueScoreCard.loadJudgeScoreCard(dataUnanime[1]);
        blueScoreCard.setRCorner("Rocky Balboa");
        blueScoreCard.setBCorner("Apollo Creed");

        ScoreCard pinkScoreCard = new ScoreCard("PINK");
        pinkScoreCard.loadJudgeScoreCard(dataUnanime[2]);
        pinkScoreCard.setRCorner("Rocky Balboa");
        pinkScoreCard.setBCorner("Apollo Creed");
        Combat unanime = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = unanime.getWinner();
        assertEquals("Apollo Creed",winner);

    }

}