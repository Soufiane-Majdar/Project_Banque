package metier.clients;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;
import presentation.modele.TableauDeBord;

import java.time.LocalDateTime;
import java.util.*;

import static presentation.controleur.MaBanque.loginService;

public class ServiceIHMClient implements IServiceIHMClient{
    
    private Banque maBanque;
    private ServiceClient s_client;
    private Scanner clavier;
    private Client LogedClient;

    public ServiceIHMClient(Banque maBanque, Scanner clavier, Client logedClient) {
        this.maBanque = maBanque;
        this.clavier = clavier;
        s_client = new ServiceClient(maBanque, clavier, logedClient);
        LogedClient = logedClient;
    }
        

        public int menuGlobal() {
            // menuGlobal
            System.out.println("\n=============================================");
            System.out.println("Bienvenue dans l'application de gestion de la banque "+maBanque.getNomBanque());
            System.out.println("=============================================");
            System.out.println("0- Quitter");
            System.out.println("1- Gestion des Modification");
            System.out.println("2- Gestion des Retrait");
            System.out.println("3- Gestion des Informations");
            System.out.println("4- Logout");
            System.out.println("=============================================");
            System.out.println("Votre choix : ");
            int choix = clavier.nextInt();  
            
            //cas

            switch (choix) {
                case 0:
                    System.out.println("Merci d'avoir utilisé notre application");
                    System.exit(0);
                    break;
                case 1:
                    menuModification();
                    menuGlobal();
                    break;
                case 2:
                    menuRetrait();
                    menuGlobal();
                    break;
                case 3:
                    menuInformations();
                    menuGlobal();
                    break;
                case 4:
                    loginService.SeDéconnecter();
                    return 0;
                default:
                    System.out.println("Choix invalide");
                    break;
            }







            return 0;
        }
    
        
        public int menuModification() {
            // menuModification
            System.out.println("\n=============================================");
            System.out.println("Gestion des Modification");
            System.out.println("=============================================");
            System.out.println("0- Retour");
            System.out.println("1- Modifier le nom");
            System.out.println("2- Modifier le prénom");
            System.out.println("3- Modifier le  numéro de téléphone");
            System.out.println("4- Modifier le mot de passe");
            System.out.println("5- Modifier le sexe");
            System.out.println("6- Modifier l'adresse email");




            System.out.println("=============================================");

            System.out.println("Votre choix : ");

            int choix = clavier.nextInt();

            //cas

            switch (choix) {
                case 0:
                    menuGlobal();
                    break;
                case 1:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                case 2:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                case 3:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                case 4:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                case 5:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                case 6:
                    s_client.modifierProfile(choix);
                    menuModification();
                    break;
                
                default:
                    System.out.println("Choix invalide");
                    break;
            }


            return 0;
        }
    
        
        public int menuRetrait() {
            // menuRetrait
            System.out.println("\n=============================================");
            System.out.println("Gestion des Retrait");
            System.out.println("=============================================");
            System.out.println("0- Retour");
            System.out.println("4- versement");
            System.out.println("5- retrait");
            System.out.println("6- virement");

            // Chois
            System.out.println("Votre choix : ");
            int choix = clavier.nextInt();

            //cas

            switch (choix) {
                case 0:
                    menuGlobal();
                    break;
                case 4:
                    s_client.versement();
                    menuRetrait();
                    break;
                case 5:
                    s_client.retrait();
                    menuRetrait();
                    break;
                case 6:
                    s_client.virement();
                    menuRetrait();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }

            return 0;
        }
    
        
        public int menuInformations() {
            // menuInformations
            System.out.println("\n=============================================");
            System.out.println("Gestion des Informations");
            System.out.println("=============================================");
            System.out.println("0- Retour");
            System.out.println("1- Afficher le solde");
            System.out.println("2- Afficher les dernières opérations");
            System.out.println("2- Afficher Ticket");


            // Choix
            System.out.println("Votre choix : ");
            int choix = clavier.nextInt();

            //cas

            switch (choix) {
                case 0:
                    menuGlobal();
                    break;
                case 1:
                    s_client.afficherSolde();
                    menuInformations();
                    break;
                case 2:
                    s_client.dernièresOpérations();
                    menuInformations();
                    break;
                case 3:
                    s_client.afficherTicket();
                    menuInformations();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }



            return 0;
        }
    
}
