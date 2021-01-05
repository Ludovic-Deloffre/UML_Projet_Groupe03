package projetUML;

public class Malus {
    TypeM typeMalus;
    public Malus(TypeM a){

        switch (a){
            case FeuRouge:
                typeMalus=TypeM.FeuRouge;
                break;

            case Police:
                typeMalus=TypeM.Police;
                break;

            case NidDePoule:
                typeMalus=TypeM.NidDePoule;
                break;

            case PeauDeBanane:
                typeMalus=TypeM.PeauDeBanane;
                break;

            case Poussette:
                typeMalus=TypeM.Poussette;
                break;

            case DejectionCanine:
                typeMalus=TypeM.DejectionCanine;
                break;

            case Aucun:
            typeMalus=TypeM.Aucun;
            break;
        }
    }

}

enum TypeM{
    FeuRouge,
    Police,
    NidDePoule,
    PeauDeBanane,
    Poussette,
    Aucun,
    DejectionCanine;

    }