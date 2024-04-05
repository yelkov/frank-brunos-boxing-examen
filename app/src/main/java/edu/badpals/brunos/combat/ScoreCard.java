package edu.badpals.brunos.combat;

import edu.badpals.brunos.rounds.Round;
import edu.badpals.brunos.rounds.RoundFactory;

import java.util.ArrayList;
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

    String getRcorner() {
        return this.redCorner;
    }

    String getBcorner() {
        return this.blueCorner;
    }

    public byte getNumRounds() {
        return (byte) rounds.size();
    }
    Round getRound(Integer position) {
        return rounds.get(position);
    }

    private void setJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
    }

    private String[] getJudgeScoreCard() {
        return this.judgeScoreCard;
    }


    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        setJudgeScoreCard(judgeScoreCard);
        loadRounds(getJudgeScoreCard());
    }

    private void loadRounds(String[] judgeScoreCard) {
        for (int i = 0; i < judgeScoreCard.length; i++) {
            this.rounds.add(RoundFactory.getRound(getJudgeScoreCard()[i]));
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
        for (Round round : rounds) {
            if (boxerColor == "red"){
                totalScore += round.getRedBoxerScore();
            }else if (boxerColor == "blue") {
                totalScore += round.getBlueBoxerScore();
            }
        }
        return totalScore;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
               sb.append("\t\t\t   ").append(getColor().toString()).append("\t\t\n")
                       .append("\t\t").append(getRcorner().toString()).append("\t").append(getBcorner()).append("\t\t\n")
                       .append("\t\t\t").append(Byte.toString(getNumRounds())).append(" rounds\t\t\n")
                       .append("\tRound\tScore\tRound\tScore\tRound\n")
                       .append("\tScore\tTotal\t     \tTotal\tScore\n");
               sb.append(printRounds());

        return sb.toString();
    }

    private String printRounds() {
        StringBuilder sb = new StringBuilder();
        Integer blueScore = 0;
        Integer redScore = 0;
        for (Round round : rounds) {
            blueScore += round.getBlueBoxerScore();
            redScore += round.getRedBoxerScore();
            sb.append("\t").append(Byte.toString(round.getRedBoxerScore()))
                    .append("\t").append(redScore.toString())
                    .append("\t").append((rounds.indexOf(round) + 1))
                    .append("\t").append(blueScore.toString())
                    .append("\t").append(Byte.toString(round.getBlueBoxerScore())).append("\n");
        }
        return sb.toString();
    }
    public String getCardWinner(){
        return this.getBlueBoxerFinalScore() > this.getRedBoxerFinalScore()? getBcorner()
                : this.getBlueBoxerFinalScore() < this.getRedBoxerFinalScore()? getRcorner() : "Tie";
    }


}

