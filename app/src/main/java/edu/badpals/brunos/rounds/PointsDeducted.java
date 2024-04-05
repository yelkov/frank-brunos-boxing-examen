package edu.badpals.brunos.rounds;

public class PointsDeducted implements Round{
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;
    public PointsDeducted(String roundScore){
        this.roundScore = roundScore;
        boxerRoundScore();
    }
    @Override
    public byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public void boxerRoundScore() {
        String[] puntuaciones = this.roundScore.split(" - ");
        this.redBoxerScore = parseComaRed(puntuaciones[0]);
        this.blueBoxerScore = parseComaBlue(puntuaciones[1]);
        this.roundScore = Integer.toString(redBoxerScore) +" - "+Integer.toString(blueBoxerScore);
    }

    private byte parseComaBlue(String score){
        String parsedScore;
        if (score.contains(" ,1")){
            parsedScore = score.replace(" ,1","");
            return Byte.parseByte(parsedScore);
        }
        return Byte.parseByte(score);
    }
    private byte parseComaRed(String score){
        String parsedScore;
        if (score.contains("1, ")){
            parsedScore = score.replace("1, ","");
            return Byte.parseByte(parsedScore);
        }
        return Byte.parseByte(score);
    }
    @Override
    public String toString(){
        return this.roundScore;
    }
}
