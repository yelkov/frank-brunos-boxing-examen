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
    public byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public void boxerRoundScore() {
        String[] puntuaciones = this.roundScore.split(" - ");
        this.redBoxerScore = Byte.parseByte(puntuaciones[0]);
        this.blueBoxerScore = Byte.parseByte(puntuaciones[1]);
    }
    @Override
    public String toString(){
        return this.roundScore;
    }
}
