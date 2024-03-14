package edu.badpals.brunos.rounds;

public class RegularRound implements Round{
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public RegularRound(String roundScore){
        this.roundScore = roundScore;
    }
    public void boxerRoundScore(){
        String[] puntuaciones = this.roundScore.split(" - ");
        this.redBoxerScore = (byte)Integer.parseInt(puntuaciones[0]);
        this.blueBoxerScore = (byte)Integer.parseInt(puntuaciones[1]);

    }

    public String getRedBoxerScore() {
        return String.valueOf(this.redBoxerScore);
    }

    public String getBlueBoxerScore() {
        return String.valueOf(this.blueBoxerScore);
    }

    @Override
    public byte getredBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getblueBoxerScore() {
        return this.blueBoxerScore;
    }
}
