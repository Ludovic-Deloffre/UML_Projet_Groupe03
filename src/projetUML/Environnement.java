package projetUML;


public class Environnement extends Case{
    Type typeEnvironnement;

    public Environnement(Type a, int cor1, int cor2){
        super(cor1, cor2);
        switch (typeEnvironnement){
            case Route:
                typeEnvironnement=Type.Route;
                break;

            case Trottoir:
                typeEnvironnement=Type.Trottoir;
                break;

            case Eau:
                typeEnvironnement=Type.Eau;
                break;

            case Foret:
                typeEnvironnement=Type.Foret;
                break;

            case Grise:
                typeEnvironnement=Type.Grise;
                break;
        }
    }
}


enum Type{
    Route,
    Trottoir,
    Eau,
    Foret,
    Grise;

}