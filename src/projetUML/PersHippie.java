package projetUML;

public class PersHippie extends Personnage{

    public PersHippie(String pseudo, boolean maillot, int moyenTransport){
        super(pseudo, maillot, moyenTransport);
        this.vie = 75;
        this.hydratation = 50;
        this.satiete = 50;
        this.moral = 100;
    }

}
