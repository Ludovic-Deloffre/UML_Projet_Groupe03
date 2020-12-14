package projetUML;

public class Batiment extends Case{

    int affectVie;
    int affectMoral;
    int affectSatiete;
    int affectHydratation;
    float bonusDiplome;

    public Batiment(int a, int b)
    {
        super(a, b);
        this.affectVie = 0;
        this.affectMoral = 0;
        this.affectSatiete = 0;
        this.affectHydratation = 0;
        this.bonusDiplome = 0;

    }
}
