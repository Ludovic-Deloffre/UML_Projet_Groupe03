package projetUML;

public class Bibliotheque extends Batiment{

    public Bibliotheque()
    {
        super();
        this.rep = 'B';
        this.affectMoral = 20;
        int bookGenieLogicielFound = 0 + (int) (Math.random() * ((101 - 0) + 1));
        if (bookGenieLogicielFound < 5) {
            this.bonusDiplome = (float) 0.1;
        }


    }


}
