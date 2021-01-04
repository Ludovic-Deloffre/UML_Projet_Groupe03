package projetUML;
import java.util.Scanner;

public class Game {

    Personnage perso;
    Ville city;

    public Game(){}

    public void StartGame(){
        Scanner input = new Scanner(System.in);
        int size;
        int length;
        int width;
        String pseudo;
        Personnage perso;
        boolean hasMaillot;

        System.out.println("Choisissez la taille de la ville:");
        System.out.println("1 - Petit");
        System.out.println("2 - Moyen");
        System.out.println("3 - Grand");
        size = input.nextInt();

        switch(size){
            case 1:
                length = 40;
                width = 13;
                break;
            case 2:
                length = 60;
                width = 15;
                break;
            case 3:
                length = 80;
                width = 17;
                break;
            default:
                length = 50;
                width = 13;
                break;
        }

        System.out.println("Voulez-vous un maillot ? ");
        System.out.println("1 - Oui");
        System.out.println("2 - Non");
        int maillot = input.nextInt();
        switch(maillot){
            case 2:
                hasMaillot = false;
                break;
            case 1:
                hasMaillot = true;
                break;
            default:
                hasMaillot = false;
                break;
        }

        System.out.println("Entrez votre pseudo : ");
        pseudo = input.nextLine();

        System.out.println("Choisissez votre personnage : ");
        System.out.println("1 - Standard");
        System.out.println("2 - Pressé");
        System.out.println("3 - Hippie");
        int persoChoice = input.nextInt();

        switch(persoChoice){
            case 1:
                perso = new PersStandard(pseudo, hasMaillot);
                break;
            case 2:
                perso = new PersPresse(pseudo, hasMaillot);
                break;
            case 3:
                perso = new PersHippie(pseudo, hasMaillot);
                break;
            default:
                perso = new PersStandard(pseudo, hasMaillot);
                break;
        }

        this.perso = perso;
        this.city = new Ville(length, width);

    }

    public static void main(String[] args){
        char bufferPos;
        char persoChar = '!';

        Game jeu = new Game();

        jeu.StartGame();
        jeu.city.generate();
        while(true){
            /*bufferPos = jeu.city.getCase(jeu.city.getSpawnX(), jeu.city.getSpawnY()).rep;*/
            jeu.city.affiche();
        }




    }

}
