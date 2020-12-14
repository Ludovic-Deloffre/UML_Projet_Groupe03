package projetUML;

public class Ville {
    Case[][] carte;

    public Ville (int taille1,int taille2){
        this.carte = new Case[taille1][taille2];
        for(int i=0 ; i<=taille1 ; i++){
            for(int u=0 ; u<=taille2 ; u++){
                carte[i][u]=null;
            }
        }

    }
}
