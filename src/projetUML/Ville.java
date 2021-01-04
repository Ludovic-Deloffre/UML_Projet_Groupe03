package projetUML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Ville {
    Case[][] carte;
    int x;
    int y;
    public Ville (int taille1,int taille2){
        this.x = taille1;
        this.y = taille2;
        this.carte = new Case[taille2][taille1];
        for(int i=0 ; i<taille2 ; i++){
            Case[] a1 = new Case[taille1];
            for(int u=0 ; u<taille1 ; u++){
                a1[u] = null;
            }
            carte[i]=a1;
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

            if((test instanceof Environnement) != true)
            {
                carte[coordY][(5 + coordX*i) + 1] = new Environnement(Type.Trottoir);
                carte[coordY][(5 + coordX*i) - 1] = new Environnement(Type.Trottoir);

                for(int j = -1; j < 2; j++){
                    carte[coordY+1][(5 + coordX*i) + j] = new Environnement(Type.Trottoir);
                    carte[coordY-1][(5 + coordX*i) + j] = new Environnement(Type.Trottoir);
                }
            }

            else
            {
                if(h == 5){
                    carte[coordY][(5 + coordX*i) + 1] = new Environnement(Type.Foret);
                    carte[coordY][(5 + coordX*i) - 1] = new Environnement(Type.Foret);

                    for(int j = -1; j < 2; j++){
                        carte[coordY+1][(5 + coordX*i) + j] = new Environnement(Type.Foret);
                        carte[coordY-1][(5 + coordX*i) + j] = new Environnement(Type.Foret);
                    }
                }
                else
                {
                    carte[coordY][(5 + coordX*i) + 1] = new Environnement(Type.Eau);
                    carte[coordY][(5 + coordX*i) - 1] = new Environnement(Type.Eau);

                    for(int j = -1; j < 2; j++){
                        carte[coordY+1][(5 + coordX*i) + j] = new Environnement(Type.Eau);
                        carte[coordY-1][(5 + coordX*i) + j] = new Environnement(Type.Eau);
                    }
                }
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