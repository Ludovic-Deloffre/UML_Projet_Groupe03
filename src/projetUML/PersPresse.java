package projetUML;

public class PersPresse extends Personnage{

    public PersPresse(String pseudo, boolean maillot){
        super(pseudo, maillot);
        this.vie = 100;
        this.hydratation = 75;
        this.satiete = 75;
        this.moral = 50;
    }

}
