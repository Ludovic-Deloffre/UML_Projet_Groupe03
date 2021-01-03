package projetUML;

import java.util.ArrayList;
import java.util.List;

public class Ville {
    List<ArrayList<Case> > carte = new ArrayList<ArrayList<Case>>();

    public Ville (int taille1,int taille2){
        for(int i=0 ; i<=taille1 ; i++){
            List<Case> a1 = new ArrayList<Case>(taille2);
            for(int u=0 ; u<=taille2 ; u++){
                a1.add(null);
            }
            carte.add((ArrayList<Case>) a1);
        }
    }
}