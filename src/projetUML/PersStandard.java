package projetUML;

public class PersStandard extends Personnage{

    public PersStandard(String pseudo, boolean maillot, int moyenTransport){
        super(pseudo, maillot, moyenTransport);
        this.vie = 75;
        this.hydratation = 75;
        this.satiete = 75;
        this.moral = 75;
    }
}
