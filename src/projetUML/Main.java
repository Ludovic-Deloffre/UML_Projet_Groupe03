package projetUML;

public class Main {

    public static void main(String[] args){

        Ville test = new Ville(32,32);
        Maison maison = new Maison(5,5);

        maison.addtoVille(test);

        System.out.println((test.carte.get(5).get(5)).n);

    }

}
