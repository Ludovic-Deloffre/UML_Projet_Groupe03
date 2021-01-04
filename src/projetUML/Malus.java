package projetUML;

public class Malus {
    public Malus(TypeM a){
        TypeM typeMalus;
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

            case DéjectionCanine:
                typeMalus=TypeM.DéjectionCanine;
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
    DéjectionCanine;

    }