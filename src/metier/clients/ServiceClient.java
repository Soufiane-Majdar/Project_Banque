package metier.clients;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;
import presentation.modele.TableauDeBord;

import java.time.LocalDateTime;
import java.util.*;
public class ServiceClient implements IServiceClient{

   
    Banque maBanque;
    Scanner clavier;
    Client LogedClient;

    public ServiceClient(Banque maBanque, Scanner clavier, Client logedClient) {
        this.maBanque = maBanque;
        this.clavier = clavier;
        LogedClient = logedClient;
    }

    public boolean versement() {
        Compte compte = choisirCompte();
        System.out.println("Veuillez saisir le montant à verser : ");
        double montant = clavier.nextDouble();
        if (montant> 0) {
            compte.setSolde(compte.getSolde()+montant);
            System.out.println("Versement effectué avec succès");
            return true;
        } else {
            System.out.println("Versement échoué");
            return false;
        }
       
    }

   
    public boolean retrait() {
        Compte compte = choisirCompte();
        System.out.println("Veuillez saisir le montant à retirer : ");
        double montant = clavier.nextDouble();
        if (montant> 0 && montant <= compte.getSolde()) {
            compte.setSolde(compte.getSolde()-montant);
            System.out.println("Retrait effectué avec succès");
            return true;
        } else {
            System.out.println("Retrait échoué");
            return false;
        }
    }

   
    public boolean retrait(int choixRetrait) {
        Compte compte = choisirCompte();
        System.out.println("Veuillez saisir le montant à retirer : ");
        double montant = clavier.nextDouble();
        if (montant> 0 && montant <= compte.getSolde()) {
            compte.setSolde(compte.getSolde()-montant);
            System.out.println("Retrait effectué avec succès");
            return true;
        } else {
            System.out.println("Retrait échoué");
            return false;
        }
    }

   
    public boolean virement() {
        Compte compte = choisirCompte();
        System.out.println("Veuillez saisir le montant à virer : ");
        double montant = clavier.nextDouble();
        if (montant> 0 && montant <= compte.getSolde()) {
            compte.setSolde(compte.getSolde()-montant);
            System.out.println("Virement effectué avec succès");
            return true;
        } else {
            System.out.println("Virement échoué");
            return false;
        }
    }

   
    public boolean modifierProfile(int choixModification) {
        switch (choixModification) {
            case 1:
                System.out.println("Veuillez saisir le nouveau nom : ");
                String nom = clavier.next();
                LogedClient.setNom(nom);
                System.out.println("Modification effectuée avec succès");
                return true;
            case 2:
                System.out.println("Veuillez saisir le nouveau prénom : ");
                String prenom = clavier.next();
                LogedClient.setPrenom(prenom);
                System.out.println("Modification effectuée avec succès");
                return true;
            case 3:
                System.out.println("Veuillez saisir le nouveau numéro de téléphone : ");
                String numTel = clavier.next();
                LogedClient.setTel(numTel);
                System.out.println("Modification effectuée avec succès");
                return true;
            case 4:
                System.out.println("Veuillez saisir le nouveau mot de passe : ");
                String mdp = clavier.next();
                LogedClient.setMotDePasse(mdp);
                System.out.println("Modification effectuée avec succès");
                return true;
            case 5:
                System.out.println("Veuillez saisir le nouveau sexe : ");
                String sexe = clavier.next();
                // if (sexe.equals("M")) {
                //     LogedClient.setSexe(sexe.M);
                // } else {
                //     LogedClient.setSexe(sexe.F);
                // }
                System.out.println("Modification effectuée avec succès");
                return true;
            case 6:
                System.out.println("Veuillez saisir la nouvelle email : ");
                String adresse = clavier.next();
                LogedClient.setEmail(adresse);
                System.out.println("Modification effectuée avec succès");
                return true;
            default:
                System.out.println("Modification échouée");
                return false;
        }
      
    }

   
    public void dernièresOpérations() {
        Compte compte = choisirCompte();
        System.out.println("Les dernières opérations du compte "+compte.getNumeroCompte()+" sont : ");
        for (int i = 0; i < compte.getLogs().size(); i++) {
            System.out.println(compte.getLogs().get(i));
        }
        
    }

   
    public Double afficherSolde() {
        Compte compte = choisirCompte();
        System.out.println("Le solde du compte "+compte.getNumeroCompte()+" est : "+compte.getSolde());
        return compte.getSolde();

    }

   
    public void afficherTicket() {
        Compte compte = choisirCompte();
        System.out.println("Le ticket du compte "+compte.getNumeroCompte()+" est : "+compte.getLogs().get(compte.getLogs().size()-1));
    }

   
    public Compte choisirCompte() {
        System.out.println("Veuillez choisir le compte : ");
        for (int i = 0; i < LogedClient.getComptesClient().size(); i++) {
            System.out.println((i+1)+" - "+LogedClient.getComptesClient().get(i).getNumeroCompte());
        }

        int choixCompte = clavier.nextInt();
        return LogedClient.getComptesClient().get(choixCompte-1);
    }



}
