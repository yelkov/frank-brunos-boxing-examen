package edu.badpals.brunos.combat;

public class Combat {
    private ScoreCard whiteScoreCard;
    private ScoreCard blueScoreCard;
    private ScoreCard pinkScoreCard;
    private String redCorner;
    private String blueCorner;


    public Combat(ScoreCard whiteScoreCard, ScoreCard blueScoreCard, ScoreCard pinkScoreCard) {
        this.whiteScoreCard = whiteScoreCard;
        this.blueScoreCard = blueScoreCard;
        this.pinkScoreCard = pinkScoreCard;
        setRedCorner();
        setBlueCorner();

    }
    private void setRedCorner(){
        if (whiteScoreCard.getRcorner().equals(blueScoreCard.getRcorner()) && blueScoreCard.getRcorner().equals(pinkScoreCard.getRcorner())){
            this.redCorner = whiteScoreCard.getRcorner();
        }else{
            System.out.println("Los boxeadores de las tarjetas no coinciden");
        }
    }
    private void setBlueCorner(){
        if (whiteScoreCard.getBcorner().equals(blueScoreCard.getBcorner()) && blueScoreCard.getBcorner().equals(pinkScoreCard.getBcorner())){
            this.blueCorner = whiteScoreCard.getBcorner();
        }else {
            System.out.println("Los boxeadores de las tarjetas no coinciden");
        }
    }

    private int getPlayerWins(String player){
        int playerWins = 0;
        if(player.equals(whiteScoreCard.getCardWinner())){playerWins++;}
        if(player.equals(blueScoreCard.getCardWinner())){playerWins++;}
        if(player.equals(pinkScoreCard.getCardWinner())){playerWins++;}
        return playerWins;
    }

    public String getWinner(){
        int redWins = this.getPlayerWins(redCorner);
        int blueWins = this.getPlayerWins(blueCorner);

        return redWins >= 2? redCorner : blueWins >= 2? blueCorner : "Tie";
    }
    public String getResult(){
        int redWins = this.getPlayerWins(redCorner);
        int blueWins = this.getPlayerWins(blueCorner);
        int ties = 3 - redWins - blueWins;
        int biggerWins = redWins > blueWins ? redWins : blueWins;

        if (biggerWins == 3){
            return "Decision Unanime";
        } else{
            if(biggerWins == 2){
                if(ties == 0){
                    return "Decision Dividida";
                } else{
                    return "Decision de la Mayoria";
                }
            } else{
                if(ties == 2){
                    return "Empate Mayoritario";
                } else{
                    return "Empate";
                }
            }
        }

    }

}