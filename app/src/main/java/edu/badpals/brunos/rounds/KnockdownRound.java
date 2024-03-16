package edu.badpals.brunos.rounds;

public class KnockdownRound implements Round{
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public KnockdownRound(String roundScore){
        this.roundScore = roundScore;
        boxerRoundScore();
    }

    @Override
    public byte getblueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public byte getredBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public void boxerRoundScore() {
        String[] puntuaciones = this.roundScore.split(" - ");
        this.redBoxerScore = (byte)Integer.parseInt(puntuaciones[0]);
        this.blueBoxerScore = (byte)Integer.parseInt(puntuaciones[1]);
    }
    @Override
    public String toString(){
        return this.roundScore;
    }
}
