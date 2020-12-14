package projetUML;

public class FastFood extends Batiment{

    public FastFood(int a, int b)
    {
        super(a,b);
        this.affectMoral = 10;
        this.affectSatiete = 25;
        this.affectHydratation = 10;
        this.affectVie = -5;

    }

}
