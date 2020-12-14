package projetUML;

import java.util.ArrayList;

public class Ville {
    ArrayList<ArrayList<Case> > carte = new ArrayList<ArrayList<Case>>();

    public Ville (int taille1,int taille2){
        for(int i=0 ; i<=taille1 ; i++){
            ArrayList<Case> a1 = new ArrayList<Case>(taille2);
            for(int u=0 ; u<=taille2 ; u++){
                a1.add(null);
            }
            carte.add(a1);
        }
    }
}
