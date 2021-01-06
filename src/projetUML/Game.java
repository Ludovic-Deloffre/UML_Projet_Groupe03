package projetUML;
import java.util.Scanner;

public class Game {

    int coordX;
    int coordY;

    Personnage perso;
    Ville city;

    public Game(){}

    public void StartGame(){
        Scanner input = new Scanner(System.in);
        int size;
        int length;
        int width;
        int moyenTransport;
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

        if(persoChoice == 3)
        {
            moyenTransport = 2;
            System.out.println("Vous êtes un hippie, vous vous déplacerez à vélo.");
        }
        else {
            System.out.println("Choisissez votre moyen de transport : ");
            System.out.println("1 - Voiture + à pieds");
            System.out.println("2 - Vélo");
            moyenTransport = input.nextInt();
        }

        switch(persoChoice){

            case 2:
                perso = new PersPresse(pseudo, hasMaillot, moyenTransport);
                break;
            case 3:
                perso = new PersHippie(pseudo, hasMaillot, moyenTransport);
                break;
            default:
                perso = new PersStandard(pseudo, hasMaillot, moyenTransport);
                break;
        }



        this.perso = perso;
        this.city = new Ville(length, width);
        this.coordX = this.city.getSpawnX();
        this.coordY = this.city.getSpawnY();

    }

    public void updateCoord(String d){
        switch(d){
            case "z":
                if(this.coordY > 0) {
                    this.coordY -= 1;
                }
                break;
            case "q":
                if(this.coordX > 0) {
                    this.coordX -= 1;
                }
                break;
            case "s":
                if(this.coordY < city.y-1){
                    this.coordY += 1;
                }

                break;
            case "d":
                if(this.coordX < city.x-1){
                    this.coordX += 1;
                }
                break;        }
    }

    public char updateChar(char buffer, int bufferX, int bufferY){
        char newChar;
        char persoChar = '¡';
        this.city.getCase(bufferX, bufferY).rep = buffer;
        newChar = this.city.getCase(this.coordX, this.coordY).rep;
        this.city.getCase(this.coordX, this.coordY).rep = persoChar;

        return(newChar);

    }

    public int verifDeplacement(String direction)
    {
        switch(direction){
            case "z":
                if(this.coordY > 0) {
                    if (city.carte[coordY - 1][coordX] instanceof Environnement) {
                        if (((Environnement) city.carte[coordY - 1][coordX]).typeEnvironnement == Type.Eau) {
                            if (perso.maillot == false) {
                                return 0;
                            }

                        }
                    }
                    return 1;
                }
                break;

            case "q":
                if(this.coordX > 0)
                {
                    if (city.carte[coordY][coordX - 1] instanceof Environnement) {
                        if (((Environnement) city.carte[coordY][coordX - 1]).typeEnvironnement == Type.Eau) {
                            if (perso.maillot == false) {
                                return 0;
                            }
                        }
                    }
                    return 1;
                }
                break;

            case "s":
                if(this.coordY < city.y-1)
                {
                    if (city.carte[coordY + 1][coordX] instanceof Environnement)
                    {
                        if (((Environnement) city.carte[coordY + 1][coordX]).typeEnvironnement == Type.Eau)
                        {
                            if (perso.maillot == false)
                            {
                                return 0;
                            }
                        }
                    }
                    return 1;
                }
                break;

            case "d":
                if(this.coordX < city.x-1){
                    if (city.carte[coordY][coordX + 1] instanceof Environnement)
                    {
                        if (((Environnement) city.carte[coordY][coordX + 1]).typeEnvironnement == Type.Eau)
                        {
                            if (perso.maillot == false)
                            {
                                return 0;
                            }

                        }
                    }
                    return 1;
                }
                break;
        }
        return 0;
    }

    public static void main(String[] args){
        int curX;
        int curY;
        Scanner input = new Scanner(System.in);
        char bufferChar;
        char persoChar = '¡';
        int gameOver = 1;
        int verif;

        String direction;
        Case currentCase;

        Game jeu = new Game();


        jeu.StartGame();
        jeu.city.generate();

        curX = jeu.city.getSpawnX();
        curY = jeu.city.getSpawnY();
        jeu.coordX = curX;
        jeu.coordY = curY;

        currentCase = jeu.city.getCase(jeu.city.getSpawnX(), jeu.city.getSpawnY());
        bufferChar = jeu.city.getCase(jeu.city.getSpawnX(), jeu.city.getSpawnY()).rep;
        System.out.println(bufferChar + " X : "+  jeu.city.getSpawnX() + " Y :"+jeu.city.getSpawnY());
        currentCase.rep = persoChar;

        jeu.city.affiche();
        jeu.perso.afficheStats();

        while(gameOver == 1){
            System.out.println("");
            direction = input.nextLine();
            if(jeu.verifDeplacement(direction) == 1)
            {
                jeu.updateCoord(direction);
                bufferChar = jeu.updateChar(bufferChar, curX, curY);
                currentCase = jeu.city.getCase(jeu.coordX, jeu.coordY);
                curX = jeu.coordX;
                curY = jeu.coordY;

                gameOver = jeu.perso.getPersonnage(currentCase);

            }

            if(jeu.perso.verifyStats() == 0){
                gameOver = 0;
            }
            jeu.city.affiche();
            jeu.perso.afficheStats();
        }
        System.out.print(
                "             uu$$$$$$$$$$$uu\n" +
                "          uu$$$$$$$$$$$$$$$$$uu\n" +
                "         u$$$$$$$$$$$$$$$$$$$$$u\n" +
                "        u$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$\"   \"$$$\"   \"$$$$$$u\n" +
                "       \"$$$$\"      u$u       $$$$\"\n" +
                "        $$$u       u$u       u$$$\n" +
                "        $$$u      u$$$u      u$$$\n" +
                "         \"$$$$uu$$$   $$$uu$$$$\"\n" +
                "          \"$$$$$$$\"   \"$$$$$$$\"\n" +
                "            u$$$$$$$u$$$$$$$u\n" +
                "             u$\"$\"$\"$\"$\"$\"$u\n" +
                "  uuu        $$u$ $ $ $ $u$$       uuu\n" +
                " u$$$$        $$$$$u$u$u$$$       u$$$$\n" +
                "  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\n" +
                "u$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\n" +
                "$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\n" +
                " \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\n" +
                "           uuuu \"\"$$$$$$$$$$uuu\n" +
                "  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\n" +
                "  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\n" +
                "   \"$$$$$\"                      \"\"$$$$\"\"\n");
        System.out.print("         88                               88           \n" +
                "         88                         ,d    88           \n" +
                "         88                         88    88           \n" +
                " ,adPPYb,88  ,adPPYba, ,adPPYYba, MM88MMM 88,dPPYba,   \n" +
                "a8\"    `Y88 a8P_____88 \"\"     `Y8   88    88P'    \"8a  \n" +
                "8b       88 8PP\"\"\"\"\"\"\" ,adPPPPP88   88    88       88  \n" +
                "\"8a,   ,d88 \"8b,   ,aa 88,    ,88   88,   88       88  \n" +
                " `\"8bbdP\"Y8  `\"Ybbd8\"' `\"8bbdP\"Y8   \"Y888 88       88  ");



    }

}
