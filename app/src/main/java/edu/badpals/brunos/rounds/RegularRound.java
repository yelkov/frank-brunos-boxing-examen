package edu.badpals.brunos.rounds;

public class RegularRound implements Round{
    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public RegularRound(String roundScore){
        this.roundScore = roundScore;
        boxerRoundScore();
    }
    @Override
    public void boxerRoundScore(){
        String[] puntuaciones = this.roundScore.split(" - ");
        this.redBoxerScore = (byte)Integer.parseInt(puntuaciones[0]);
        this.blueBoxerScore = (byte)Integer.parseInt(puntuaciones[1]);
    }

    @Override
    public byte getredBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getblueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public String toString(){
        return this.roundScore;
    }
}
