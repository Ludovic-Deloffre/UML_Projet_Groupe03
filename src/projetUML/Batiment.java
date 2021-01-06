package projetUML;

public class Batiment extends Case{

    public int affectVie;
    public int affectMoral;
    public int affectSatiete;
    public int affectHydratation;
    public int bonusDiplome;

    public Batiment()
    {
        super();
        this.affectVie = 0;
        this.affectMoral = 0;
        this.affectSatiete = 0;
        this.affectHydratation = 0;
        this.bonusDiplome = 0;

    }
}
