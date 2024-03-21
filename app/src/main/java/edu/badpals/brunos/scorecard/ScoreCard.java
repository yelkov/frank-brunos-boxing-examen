package edu.badpals.brunos.scorecard;

import edu.badpals.brunos.rounds.RegularRound;
import edu.badpals.brunos.rounds.Round;
import edu.badpals.brunos.rounds.RoundFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard = {};
    private List<Round> rounds = new ArrayList<>();

    public ScoreCard(String color) {
        this.color = color;
    }

    private String getColor() {
        return this.color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = boxerName;
    }

    private String getRcorner() {
        return this.redCorner;
    }

    private String getBcorner() {
        return this.blueCorner;
    }

    public byte getNumRounds() {
        return (byte) rounds.size();
    }

    private void setJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
    }

    private String[] getJudgeScoreCard() {
        return this.judgeScoreCard;
    }

    @Override
    public String toString() {
        String string = "\t\t\t   " + getColor() + "\t\t\n" +
                "\t\t" + getBcorner() + "\t" + getRcorner() + "\t\t\n" +
                "\t\t\t" + getNumRounds() + " rounds\t\t\n" +
                "\tRound\tScore\tRound\tScore\tRound\n" +
                "\tScore\tTotal\t     \tTotal\tScore\n";

        Integer blueScore = 0;
        Integer redScore = 0;
        for (Round round : rounds) {
            blueScore += round.getblueBoxerScore();
            redScore += round.getredBoxerScore();
            string += ("\t" + round.getredBoxerScore() + "\t" + redScore + "\t" + (rounds.indexOf(round) + 1) + "\t" + blueScore + "\t" + round.getblueBoxerScore() + "\n");
        }
        ;

        return string.toString();
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        setJudgeScoreCard(judgeScoreCard);
        loadRounds(getJudgeScoreCard());
    }

    private void loadRounds(String[] judgeScoreCard) {
        for (int i = 0; i < judgeScoreCard.length; i++) {
            this.rounds.add(RoundFactory.getRound(this.judgeScoreCard[i]));
        }
    }

    public int getRedBoxerFinalScore() {
        return computeFinalScore("red");
    }
    public int getBlueBoxerFinalScore() {
        return computeFinalScore("blue");
    }

    private int computeFinalScore(String boxerColor) {
        int totalScore = 0;
        if (boxerColor == "red") {
            for (Round round : rounds) {
                totalScore += round.getredBoxerScore();
            }
            return totalScore;
        } else if (boxerColor == "blue") {
            for (Round round : rounds) {
                totalScore += round.getblueBoxerScore();
            }
            return totalScore;

        }
        return totalScore;
    }

}

