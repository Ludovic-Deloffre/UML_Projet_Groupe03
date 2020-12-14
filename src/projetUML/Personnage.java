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
    //String deplacement;
    boolean maillot;

    public Personnage(String pseudo, boolean maillot){
        this.pseudo = pseudo;
        this.maillot = maillot;
        this.diplome = 0;
        this.bonusDiplome = 0;
        this.deathChance = 0;
    }

    public void updateStats(Case c){
        if(c instanceof Batiment){

        }
        if(deathChance != 0 || hydratation != 0 || satiete != 0 || moral != 0 || vie != 0){

            if((this.vie += affectVie) > 100){this.vie = 100;}
            else{this.vie += affectVie;}

            if((this.hydratation += affectHydratation) > 100){this.hydratation = 100;}
            else{this.hydratation += affectHydratation;}

            if((this.satiete += affectSatiete) > 100){this.satiete = 100;}
            else{this.satiete += affectSatiete;}

            if((this.moral += affectMoral) > 100){this.moral = 100;}
            else{this.moral += affectMoral;}

            this.bonusDiplome += bonusDiplome;
            this.diplome += diplome;
            this.deathChance = deathChance;

            // A chaque action, il a 5 % de chance de tomber malade : -10 pts vie.
            // 0 inclus
            // 101 exclus
            int nombreAleatoire = 0 + (int)(Math.random() * ((101 - 0) + 1));
            if(nombreAleatoire < 5){ this.vie -= 10;}
        }

    }

}
