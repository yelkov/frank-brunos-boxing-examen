package edu.badpals.brunos.rounds;

public class RoundFactory {
    public static Round getRound(String roundScore){
        Round round = null;
        if (roundScore == "10 - 9" || roundScore == "9 - 10"){
            round = new RegularRound(roundScore);
        }
        if (roundScore == "10 - 8" || roundScore == "8 - 10") {
            round = new KnockdownRound(roundScore);
        }
        if (roundScore.contains("1, ") || roundScore.contains(" ,1")){
            round = new PointsDeducted(roundScore);
        }
        return round;
    }

}
