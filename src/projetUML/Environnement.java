package projetUML;


public class Environnement extends Case{
    Type typeEnvironnement;

    public Environnement(Type a){
        super();
        switch (a){
            case Route:
                this.rep = '_';
                typeEnvironnement=Type.Route;
                break;

            case Trottoir:
                this.rep = '#';
                typeEnvironnement=Type.Trottoir;
                break;

            case Eau:
                this.rep = '~';
                typeEnvironnement=Type.Eau;
                break;

            case Foret:
                this.rep = '△';
                typeEnvironnement=Type.Foret;
                break;

            case Grise:
                this.rep = 'X';
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