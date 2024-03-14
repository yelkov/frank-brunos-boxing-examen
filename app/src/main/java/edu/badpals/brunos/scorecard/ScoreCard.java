package edu.badpals.brunos.scorecard;

import edu.badpals.brunos.rounds.RegularRound;
import edu.badpals.brunos.rounds.Round;

public class ScoreCard {

    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    private Round[] rounds;

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

    @Override
    public String toString(){
        return "\t\t\t   "+getColor()+"\t\t\n"
                +"\t\t"+getBcorner()+"\t"+getRcorner()+"\t\t\n"
                +"\t\t\t0 rounds\t\t\n" //implementar getNumRounds
                +"\tRound\tScore\tRound\tScore\tRound\n"
                +"\tScore\tTotal\t     \tTotal\tScore\n"
                ;
    }

}
