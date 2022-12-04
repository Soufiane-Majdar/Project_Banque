package metier.admin;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.TableauDeBord;

import java.time.LocalDateTime;
import java.util.*;

public class ServiceAdmin implements IServiceAdmin{
    
    Banque maBanque;
    Scanner clavier;

    public ServiceAdmin(Banque maBanque, Scanner clavier) {
        this.maBanque = maBanque;
        this.clavier = clavier;
    }

 
    public Client  nouveauClient(){
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Client au Banque");
        System.out.println("ID     : ");
        int id =clavier.nextInt();
        System.out.println("nom    : ");
        String nom=clavier.next();
        System.out.println("prenom : ");
        String prenom=clavier.next();
        System.out.println("login  : ");
        String login=clavier.next();
        System.out.println("Password  : ");
        String password=clavier.next();
        Client c=new Client(login,password,nom,prenom);
        return c;
     }
    public Client          nouveauCompteClientExistant(){
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Compte au Client");
        System.out.println("ID     : ");
        Scanner clavier = new Scanner(System.in);
        int id =clavier.nextInt();
        System.out.println("nom    : ");
        String nom=clavier.next();
        System.out.println("prenom : ");
        String prenom=clavier.next();
        System.out.println("login  : ");
        String login=clavier.next();
        System.out.println("Password  : ");
        String password=clavier.next();
        Client c=new Client(login,password,nom,prenom);
        return c;
            
     }

    public Client          chercherClientParId(Long id){
            Client foo = new Client();
            return foo;
            
     }
    public List<Client>    chercherClientParNom(String nom){ 
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }
    
    public List<Client>    chercherClientParPrénom(String prenom){ 
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }
    public Client          chercherClientParCin(String cin){
            Client foo = new Client();
            return foo;
            
     }
    public Client          chercherClientParEmail(String email){
            Client foo = new Client();
            return foo;
            
     }

    public Compte          chercherCompteParId(Long idCompte){
            Compte foo = new Compte();
            return foo;
            
     }

    public List<Compte>    chercherCompteParSolde(double solde){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Compte>    chercherCompteParDateCreation(LocalDateTime date){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Compte>    chercherCompteParPropriétaire(Client propriétaire){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
     }

    public Client          modifierClient(String filtre){
            Client foo = new Client();
            return foo;
            
     }

    public boolean         supprimerClient(Long id){
            return true;
            
     }

     public boolean         supprimerCompte(Long id){
        return true;
        
 }
     
    public TableauDeBord   calculerEtAfficherStatistiques(){
            TableauDeBord foo = new TableauDeBord();
            return foo;
            
     }

    public List<Client>    trierClientParNom(){
            List<Client> foo = new ArrayList<>();
            return foo;
            
    }

    public List<Client>    trierClientParCin(){
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Client>    trierClientParEmail(){
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Client>    trierClientParAdresse(){
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Client>    trierClientParSoldeCompte(){
            List<Client> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Compte>    trierComptesParSolde(){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
     }

    public List<Compte>    trierComptesParDateDeCreation(){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
    }

    public List<Compte>    trierComptesParNomPropriétaire(){
            List<Compte> foo = new ArrayList<>();
            return foo;
            
    }

    
    
    
    
}
