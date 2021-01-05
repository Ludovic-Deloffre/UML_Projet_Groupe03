package projetUML;

public class Bar extends Batiment{

    public Bar()
    {
        super();
        this.rep = 'P';
        this.affectMoral = 10;
        this.affectVie = -3;
        this.affectHydratation = 25;
        int sujetExamenFound = 0 + (int) (Math.random() * ((101 - 0) + 1));
        if (sujetExamenFound < 5) {
            this.bonusDiplome = (float) 0.05;
        }

    }


}
