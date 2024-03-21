package edu.badpals.brunos.rounds;

public class RoundFactory {
    public static Round getRound(String roundScore){
        Round round = null;
        if (roundScore == "10 - 9" || roundScore == "9 - 10"){
            round = new RegularRound(roundScore);
        }
        else if (roundScore.contains(",")){
            round = new PointsDeducted(roundScore);
        }
        else {
            round = new KnockdownRound(roundScore);
        }
        return round;
    }

}
