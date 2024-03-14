package edu.badpals.brunos.scorecard;

import edu.badpals.brunos.rounds.RegularRound;
import edu.badpals.brunos.rounds.Round;

import java.util.Arrays;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    private Round[] rounds = new Round[10];

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
        return (byte)rounds.length;
    }

    private void setJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
    }

    @Override
    public String toString(){
        return "\t\t\t   "+getColor()+"\t\t\n"
                +"\t\t"+getBcorner()+"\t"+getRcorner()+"\t\t\n"
                +"\t\t\t"+getNumRounds()+" rounds\t\t\n"
                +"\tRound\tScore\tRound\tScore\tRound\n"
                +"\tScore\tTotal\t     \tTotal\tScore\n"
                +"\t" //aqui van las puntuaciones pero no consigo inicializar rounds -> rounds[0].getredBoxerScore() me devuelve null
                ;
    }

    public void loadJudgeScoreCard(String[] puntuaciones) {
        setJudgeScoreCard(puntuaciones);
        for (int i=0;i< rounds.length;i++) {
            this.rounds[i] = new RegularRound(judgeScoreCard[i]);
            this.rounds[i].boxerRoundScore();
                }
            }
}


