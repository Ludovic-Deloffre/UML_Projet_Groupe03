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

    public void generate(){

        for(int i = 0; i < y; i++)
        {

            for(int j = 0; j < x; j++)
            {
                carte[i][j] = new Environnement(Type.Route);
            }

        }
        int coordY = 0;
        int coordX = x/7;
        Integer[] arr = {0, 1, 2, 3, 4 , 5, 6};
        Collections.shuffle(Arrays.asList(arr));
        for(int i = 0; i < 7; i++){
            Case test = new Case();
            coordY = 2 + (int) (Math.random() * ((y-2)-2));
            int h = arr[i];
            switch(h){
                case 0:
                    test = new Maison();
                    break;
                case 1:
                    test = new Bar();
                    break;
                case 2:
                    test = new Universite();
                    break;
                case 3:
                    test = new FastFood();
                    break;
                case 4:
                    test = new Bibliotheque();
                    break;
                case 5:
                    test = new Environnement(Type.Foret);
                    break;
                case 6:
                    test = new Environnement(Type.Eau);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
            carte[coordY][(5 + coordX*i)] = test;
            carte[coordY][(5 + coordX*i) + 1] = new Environnement(Type.Trottoir);
            carte[coordY][(5 + coordX*i) - 1] = new Environnement(Type.Trottoir);

            for(int j = -1; j < 2; j++){
                carte[coordY+1][(5 + coordX*i) + j] = new Environnement(Type.Trottoir);
                carte[coordY-1][(5 + coordX*i) + j] = new Environnement(Type.Trottoir);
            }

        }

    }

    public void affiche(){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.print(carte[i][j].rep);
            }
            System.out.print('\n');
        }
    }
}