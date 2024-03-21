package edu.badpals.brunos.combat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatTest {
    ScoreCard whiteScoreCard;
    ScoreCard blueScoreCard;
    ScoreCard pinkScoreCard;
        /*

        this.empateMayoritario = new Combat("Tie","Tie","Rocky Balboa");
        */
    @Before
    public void setScoreCards(){
        this.whiteScoreCard = new ScoreCard("WHITE");
        setBoxers(whiteScoreCard);
        this.blueScoreCard = new ScoreCard("BLUE");
        setBoxers(blueScoreCard);
        this.pinkScoreCard = new ScoreCard("PINK");
        setBoxers(pinkScoreCard);

    }
    private static void setBoxers(ScoreCard scoreCard) {
            scoreCard.setRCorner("Rocky Balboa");
            scoreCard.setBCorner("Apollo Creed");
        }

    @Test
    public void unanime(){
        String[][] dataUnanime = {

                //  White ScoreCard - gana Apollo
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

                // Blue ScoreCard - gana Apollo
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

                // Pink ScoreCard - gana Apollo
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
        whiteScoreCard.loadJudgeScoreCard(dataUnanime[0]);
        blueScoreCard.loadJudgeScoreCard(dataUnanime[1]);
        pinkScoreCard.loadJudgeScoreCard(dataUnanime[2]);
        Combat unanime = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = unanime.getWinner();
        String result = unanime.getResult();
        assertEquals("Apollo Creed",winner);
        assertEquals("Decision Unanime",result);
    }

    @Test
    public void decisionDividida(){
        String[][] dataDecisionDividida = {

                //  White ScoreCard - gana Apollo
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

                // Blue ScoreCard - gana Apollo
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

                // Pink ScoreCard - gana Rocky
                {"9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "8 - 10",
                        "10 - 8",
                        "10 - 8",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "10 - 9"
                },
        };
        whiteScoreCard.loadJudgeScoreCard(dataDecisionDividida[0]);
        blueScoreCard.loadJudgeScoreCard(dataDecisionDividida[1]);
        pinkScoreCard.loadJudgeScoreCard(dataDecisionDividida[2]);
        Combat decisionDividida = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = decisionDividida.getWinner();
        String result = decisionDividida.getResult();
        assertEquals("Apollo Creed",winner);
        assertEquals("Decision Dividida",result);
    }

    @Test
    public void decisionMayoría(){
        String[][] dataDecisionMayoria = {

                //  White ScoreCard - apollo gana
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

                // Blue ScoreCard - apollo gana
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

                // Pink ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },
        };
        whiteScoreCard.loadJudgeScoreCard(dataDecisionMayoria[0]);
        blueScoreCard.loadJudgeScoreCard(dataDecisionMayoria[1]);
        pinkScoreCard.loadJudgeScoreCard(dataDecisionMayoria[2]);
        Combat decisionMayoria = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = decisionMayoria.getWinner();
        String result = decisionMayoria.getResult();
        assertEquals("Apollo Creed",winner);
        assertEquals("Decision de la Mayoria",result);
    }

    @Test
    public void empate(){
        String[][] dataEmpate = {

                //  White ScoreCard - gana Apollo
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

                // Blue ScoreCard - gana Rocky
                {"9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "8 - 10",
                        "10 - 8",
                        "10 - 8",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "10 - 9"
                },

                // Pink ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },
        };
        whiteScoreCard.loadJudgeScoreCard(dataEmpate[0]);
        blueScoreCard.loadJudgeScoreCard(dataEmpate[1]);
        pinkScoreCard.loadJudgeScoreCard(dataEmpate[2]);
        Combat empate = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = empate.getWinner();
        String result = empate.getResult();
        assertEquals("Tie",winner);
        assertEquals("Empate",result);
    }

    @Test
    public void empateUnanime(){
        String[][] dataEmpateUnanime = {

                //  White ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },

                // Blue ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },

                // Pink ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },

        };
        whiteScoreCard.loadJudgeScoreCard(dataEmpateUnanime[0]);
        blueScoreCard.loadJudgeScoreCard(dataEmpateUnanime[1]);
        pinkScoreCard.loadJudgeScoreCard(dataEmpateUnanime[2]);
        Combat empateUnanime = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = empateUnanime.getWinner();
        String result = empateUnanime.getResult();
        assertEquals("Tie",winner);
        assertEquals("Empate",result);
    }

    @Test
    public void empateMayoritario(){
        String[][] dataEmpateMayoritario = {

                //  White ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },

                // Blue ScoreCard - empate
                {"9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9"
                },

                // Pink ScoreCard - gana Rocky
                {"9 - 10",
                        "9 - 10",
                        "9 - 10",
                        "8 - 10",
                        "10 - 8",
                        "10 - 8",
                        "10 - 9",
                        "9 - 10",
                        "10 - 9",
                        "10 - 9"
                },

        };
        whiteScoreCard.loadJudgeScoreCard(dataEmpateMayoritario[0]);
        blueScoreCard.loadJudgeScoreCard(dataEmpateMayoritario[1]);
        pinkScoreCard.loadJudgeScoreCard(dataEmpateMayoritario[2]);
        Combat empateMayoritario = new Combat(whiteScoreCard,blueScoreCard,pinkScoreCard);
        String winner = empateMayoritario.getWinner();
        String result = empateMayoritario.getResult();
        assertEquals("Tie",winner);
        assertEquals("Empate Mayoritario",result);
    }


}