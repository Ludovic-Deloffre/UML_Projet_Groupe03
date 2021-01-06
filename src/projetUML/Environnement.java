package projetUML;


public class Environnement extends Case{
    Type typeEnvironnement;
    Malus malus;
    int ajoutPiege;
    int typePiege;
    public Environnement(Type a){
        super();
        switch (a){
            case Route:
                this.rep = '_';
                typeEnvironnement=Type.Route;
                ajoutPiege = (int) (Math.random() * 100);
                if(ajoutPiege  < 5){
                    typePiege= 1 + (int) (Math.random() * 3);
                    switch (typePiege){
                        case 1:
                            this.malus = new Malus(TypeM.FeuRouge);
                            break;
                        case 2:
                            this.malus = new Malus(TypeM.Police);
                            break;
                        case 3:
                            this.malus = new Malus(TypeM.NidDePoule);
                            break;
                    }
                }
                else{
                    this.malus = new Malus(TypeM.Aucun);
                }
                break;

            case Trottoir:
                this.rep = '#';
                typeEnvironnement=Type.Trottoir;
                ajoutPiege = (int) (Math.random() * 100);
                if(ajoutPiege  < 5){
                    typePiege= 1 + (int) (Math.random() * 3);
                    switch (typePiege){
                        case 1:
                            this.malus = new Malus(TypeM.PeauDeBanane);
                            break;
                        case 2:
                            this.malus = new Malus(TypeM.Poussette);
                            break;
                        case 3:
                            this.malus = new Malus(TypeM.DejectionCanine);
                            break;
                    }
                }
                else{
                    this.malus = new Malus(TypeM.Aucun);
                }
                break;

            case Eau:
                this.rep = '~';
                typeEnvironnement=Type.Eau;
                this.malus = new Malus(TypeM.Aucun);
                break;

            case Foret:
                this.rep = 'G';
                typeEnvironnement=Type.Foret;
                this.malus = new Malus(TypeM.Aucun);
                break;

            case Grise:
                this.rep = 'X';
                typeEnvironnement=Type.Grise;
                this.malus = new Malus(TypeM.Aucun);
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