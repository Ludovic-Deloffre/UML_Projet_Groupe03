package projetUML;

public abstract class Personnage {

    String pseudo;
    int vie;
    int hydratation;
    int satiete;
    int moral;
    int diplome;
    float bonusDiplome;
    int deathChance;
    int arrestation;
    boolean maillot;
    int moyenTransport;
    // 1 = normal (a pied sur les trottoirs + en voiture sur les routes)
    // 2 = velo (sur toutes les cases)

    public Personnage(String pseudo, boolean maillot, int moyenTransport){
        this.pseudo = pseudo;
        this.maillot = maillot;
        this.diplome = 0;
        this.bonusDiplome = 0;
        this.moyenTransport = moyenTransport;
    }

    public int getPersonnage(Case b){
        int a = verifyStats();
        if(a == 0){
            return 0;
        }
        updateStats(b);
        return 1;
    }

    public int verifyStats(){
        if(deathChance == 1 || arrestation >= 3 || hydratation <= 0 || satiete <= 0 || moral <= 0 || vie <= 0){
            return 0;
        }
        return 1;
    }

    public void updateStats(Case c){

        int affectVie = 0;
        int affectMoral = 0;
        int affectSatiete = 0;
        int affectHydratation = 0;
        float bonusDiplome = 0;
        int nombreAleatoire = 0;

        if(c instanceof Batiment){
            affectVie = ((Batiment) c).affectVie;
            affectMoral = ((Batiment) c).affectMoral;
            affectSatiete = ((Batiment) c).affectSatiete;
            affectHydratation = ((Batiment) c).affectHydratation;
            bonusDiplome = ((Batiment) c).bonusDiplome;

            if((this.vie += affectVie) > 100){this.vie = 100;}
            else{this.vie += affectVie;}

            if((this.hydratation += affectHydratation) > 100){this.hydratation = 100;}
            else{this.hydratation += affectHydratation;}

            if((this.satiete += affectSatiete) > 100){this.satiete = 100;}
            else{this.satiete += affectSatiete;}

            if((this.moral += affectMoral) > 100){this.moral = 100;}
            else{this.moral += affectMoral;}

            if(bonusDiplome == 0.1){
                nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                if (nombreAleatoire < 10) {
                    this.diplome += 1;
                }
            } else if(bonusDiplome == 0.3){
                nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                if (nombreAleatoire < 30) {
                    this.diplome += 1;
                    this.moral += 5;
                }
            }
            else if(bonusDiplome == 0.05){
                nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                if (nombreAleatoire < 5) {
                    this.diplome += 1;
                }
            }

            // A chaque action, il a 5 % de chance de tomber malade : -10 pts vie.
            // 0 inclus
            // 101 exclus
            nombreAleatoire = 0 + (int)(Math.random() * ((101 - 0) + 1));
            if(nombreAleatoire < 5){ this.vie -= 10;}
        }
        else if(c instanceof Environnement) {
            if (((Environnement) c).typeEnvironnement == Type.Route) {
                if(moyenTransport == 1){
                    // en voiture = 2% de chances de mourir
                    nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                    if (nombreAleatoire < 2) {
                        deathChance = 1;
                    }
                    // en voiture = 5% de chance de se faire arreter par la police
                    nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                    if (nombreAleatoire < 5) {
                        arrestation += 1;
                    }
                    this.moral -= 2;
                }
                else if(moyenTransport == 2){
                    nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
                    if (nombreAleatoire < 1) {
                        deathChance = 1;
                    }
                    this.hydratation -= 5;
                    this.satiete -= 5;
                }
                if(((Environnement) c).malus.typeMalus.equals(TypeM.FeuRouge)){
                    this.vie -= 1;
                }
                else if(((Environnement) c).malus.typeMalus.equals(TypeM.Police)){
                    this.moral -= 1;
                }
                else if(((Environnement) c).malus.typeMalus.equals(TypeM.NidDePoule)){
                    this.satiete -= 2;
                    this.hydratation -= 2;
                }


            } else if (((Environnement) c).typeEnvironnement == Type.Trottoir) {
                moyenTransport();
                if(((Environnement) c).malus.typeMalus.equals(TypeM.PeauDeBanane)){
                    this.vie -= 3;
                }
                else if(((Environnement) c).malus.typeMalus.equals(TypeM.Poussette)){
                    this.moral -= 2;
                }
                else if(((Environnement) c).malus.typeMalus.equals(TypeM.DejectionCanine)){
                    this.satiete -= 1;
                }
            } else if (((Environnement) c).typeEnvironnement == Type.Foret) {
                moyenTransport();
                nombreAleatoire = 0 + (int)(Math.random() * ((101 - 0) + 1));
                if(nombreAleatoire < 10){ this.vie -= 10;}
            }
        }


    }

    public void afficheStats(){
        System.out.println("Vie : "+this.vie+" | Satiété : "+ this.satiete + " | Hydratation : "+this.hydratation);
        System.out.println("Moral : "+this.moral+" | Diplômes : "+ this.diplome + " | Arrestations : "+this.arrestation);
    }



    // calcul des statistiques pour les deplacements à pied et à vélo
    // utilisé pour les forêts et les trottoirs
    private void moyenTransport() {
        int nombreAleatoire;
        if(moyenTransport == 1) {
            this.hydratation -= 10;
            this.satiete -= 10;
        }
        else if(moyenTransport == 2){
            nombreAleatoire = 0 + (int) (Math.random() * ((101 - 0) + 1));
            if (nombreAleatoire < 1) {
                deathChance = 1;
            }
            this.hydratation -= 5;
            this.satiete -= 5;
        }
    }

}
