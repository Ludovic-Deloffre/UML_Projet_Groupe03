package projetUML;

public class Case {
    int n;
    int m;

    public Case(int a, int b){
        this.n=a;
        this.m=b;
    }

    public void addtoVille(Ville ville)
    {

        ville.carte.get(m).add(n, this);

    }
}
