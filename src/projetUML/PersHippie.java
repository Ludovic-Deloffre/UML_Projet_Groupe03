package projetUML;

public class PersHippie extends Personnage{

    public PersHippie(String pseudo, boolean maillot){
        super(pseudo, maillot);
        this.vie = 75;
        this.hydratation = 50;
        this.satiete = 50;
        this.moral = 100;
    }

}
