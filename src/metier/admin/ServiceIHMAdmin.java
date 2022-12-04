package metier.admin;

import presentation.modele.Banque;

import java.util.Scanner;

public class ServiceIHMAdmin implements IServiceIHMAdmin{


    private Banque maBanque;
    private ServiceAdmin admin;
    private Scanner clavier;

    public ServiceIHMAdmin(Banque maBanque, Scanner clavier) {
        this.maBanque = maBanque;
        this.clavier = clavier;
        this.admin = new ServiceAdmin(maBanque, clavier);
    }
    

    public int menuGlobal() {
        // menu 
        System.out.println("\n=============================================");
        System.out.println("Bienvenue dans l'application de gestion de la banque "+maBanque.getNomBanque());
        System.out.println("=============================================");
        System.out.println("0- Quitter");
        System.out.println("1- Modification");
        System.out.println("2- Recherche");
        System.out.println("3- Informations");
        System.out.println("4- Ajout");
        System.out.println("5- Suppression");
        System.out.println("6- Trie");
        System.out.println("7- Comptabilité");

        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas
        switch (choix) {
            case 0:
                System.out.println("Au revoir");
                break;
            case 1:
                menuModification();
                menuGlobal();
                break;
            case 2:
                menuRecherche();
                menuGlobal();
                break;
            case 3:
                menuInformations();
                menuGlobal();
                break;
            case 4:
                menuAjout();
                menuGlobal();
                break;
            case 5:
                menuSuppression();
                menuGlobal();
                break;
            case 6:
                menuTrie();
                menuGlobal();
                break;
            case 7:
                menuComptabilite();
                menuGlobal();
                break;
            default:
                System.out.println("Choix invalide");
                menuGlobal();
                break;
        }
        



        return 0;
    }


    public int menuModification() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuRecherche() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuInformations() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuAjout() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuSuppression() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int tableauDeBord() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuTrie() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public int menuComptabilite() {
        // TODO Auto-generated method stub
        return 0;
    }

    


    
}
