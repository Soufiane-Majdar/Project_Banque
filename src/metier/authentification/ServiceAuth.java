package metier.authentification;

import metier.admin.ServiceIHMAdmin;
import metier.clients.ServiceIHMClient;
import presentation.modele.Admin;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Utilisateur;

import java.util.Scanner;

public class ServiceAuth implements IAuth{

    private Banque maBanque;
    private Scanner clavier;
    Client LogedClient;

    public ServiceAuth(Banque maBanque, Scanner clavier) {
        this.maBanque = maBanque;
        this.clavier = clavier;
    }



    public void seConnecter() {
        System.out.println("Bienvenue dans la banque " + maBanque.getNomBanque());
        System.out.println("Veuillez saisir votre login : ");
        String login = clavier.next();
        System.out.println("Veuillez saisir votre mot de passe : ");
        String password = clavier.next();

        Utilisateur admin = Admin.getInstance();
        if(admin.getLogin().equals(login) && admin.getMotDePasse().equals(password)){
            System.out.println("Bienvenue " + admin.getNom() + " " + admin.getPrenom());
            // got to menu admin
            ServiceIHMAdmin IHMAdmin=new ServiceIHMAdmin(maBanque, clavier);
            IHMAdmin.menuGlobal();
        }

        // for client
        for (Utilisateur client : maBanque.getClientsDeBanque()) {
            if(client.getLogin().equals(login) && client.getMotDePasse().equals(password)){
                System.out.println("Bienvenue " + client.getNom() + " " + client.getPrenom());
                // got to menu client
                LogedClient=(presentation.modele.Client) client;
                ServiceIHMClient IHMClient=new ServiceIHMClient(maBanque, clavier,LogedClient);
                IHMClient.menuGlobal();

            }
        }

    }


    public void SeDéconnecter() {
		System.out.println("##############################  DÉCONNEXION AVCE SUCCES  ###############################");
		seConnecter();
	}
    

    
}
