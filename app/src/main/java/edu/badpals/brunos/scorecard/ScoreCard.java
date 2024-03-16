package edu.badpals.brunos.scorecard;

import edu.badpals.brunos.rounds.RegularRound;
import edu.badpals.brunos.rounds.Round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard = new String[10];
    private List<Round> rounds = new ArrayList<>();

    public ScoreCard(String color){
        this.color = color;
    }
    private String getColor(){
        return this.color;
    }
    public void setRCorner(String boxerName){
          this.redCorner = boxerName;
    }
    public void setBCorner(String boxerName){
        this.blueCorner = boxerName;
    }
    private String getRcorner(){
        return this.redCorner;
    }
    private String getBcorner(){
        return this.blueCorner;
    }
    public byte getNumRounds(){
        return (byte)rounds.size();
    }

    private void setJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
    }

    @Override
    public String toString(){
         String string = "\t\t\t   "+getColor()+"\t\t\n"+
                    "\t\t"+getBcorner()+"\t"+getRcorner()+"\t\t\n"+
                    "\t\t\t"+getNumRounds()+" rounds\t\t\n"+
                    "\tRound\tScore\tRound\tScore\tRound\n"+
                    "\tScore\tTotal\t     \tTotal\tScore\n";

        Integer blueTotal = 0;
        Integer redTotal = 0;
        for (Round round : rounds) {
            blueTotal += round.getblueBoxerScore();
            redTotal += round.getredBoxerScore();
            string += ("\t"+round.getredBoxerScore()+"\t"+redTotal+"\t"+(rounds.indexOf(round)+1)+"\t"+blueTotal+"\t"+round.getblueBoxerScore()+"\n");
                 }
        string += "\tFINAL SCORE: "+redTotal+" - "+blueTotal+" FINAL SCORE\n";

        return string.toString();
    }

    public void loadJudgeScoreCard(String[] puntuaciones) {
        setJudgeScoreCard(puntuaciones);
        for (int i=0;i< judgeScoreCard.length;i++) {
            this.rounds.add(new RegularRound(this.judgeScoreCard[i]));
                }
            }
}


