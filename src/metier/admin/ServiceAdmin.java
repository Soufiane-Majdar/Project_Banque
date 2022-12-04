package metier.admin;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;
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
        System.out.println("nom    : ");
        String nom=clavier.next();
        System.out.println("prenom : ");
        String prenom=clavier.next();
        System.out.println("login  : ");
        String login=clavier.next();
        System.out.println("Password  : ");
        String password=clavier.next();
        System.out.println("CIN    : ");
        String cin=clavier.next();
        System.out.println("Email  : ");
        String email=clavier.next();
        System.out.println("tel  : ");
        String tel=clavier.next();
        System.out.println("Sexe: ");
        System.out.println("0 - : Homme");
        System.out.println("1 - : Femme");
        int choixSexe=clavier.nextInt();
        
        Client client=new Client(login,password,nom,prenom,email,cin,tel,Sexe.values()[choixSexe]);
         

        System.out.println("=============================================");
        maBanque.getClientsDeBanque().add(client);
        return client;
     }


    public Client          nouveauCompteClientExistant(){
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Compte au Client");
        System.out.println("idClient  : ");
        Long idClient=clavier.nextLong();
        Client client=chercherClientParId(idClient);
        if(client!=null){
            System.out.println("Solde  : ");
            double solde=clavier.nextDouble();
            Compte compte=new Compte(solde,client);
            client.getComptesClient().add(compte);
            System.out.println("=============================================");
            return client;
        }
        System.out.println("=============================================");
        return client;
            
     }

    public Client          chercherClientParId(Long id){
        System.out.println("\n=============================================");
        System.out.println("Chercher Client Par Id");
        System.out.println("idClient  : ");
        Long idClient=clavier.nextLong();
        for(Client client:maBanque.getClientsDeBanque()){
            if(client.getId().equals(idClient)){

                return client;
            }
        }
        System.out.println("=============================================");
        return null;
            
     }
    public List<Client>    chercherClientParNom(String nom){ 
        System.out.println("\n=============================================");
        System.out.println("Chercher Client Par Nom");
        System.out.println("nomClient  : ");
        String nomClient=clavier.next();
        List<Client> clients=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            if(client.getNom().equals(nomClient)){
                clients.add(client);
            }
        }
        System.out.println("=============================================");
        return clients;
            
     }
    
    public List<Client>    chercherClientParPrénom(String prenom){ 
        System.out.println("\n=============================================");
        System.out.println("Chercher Client Par Prenom");
        System.out.println("prenomClient  : ");
        String prenomClient=clavier.next();
        List<Client> clients=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            if(client.getPrenom().equals(prenomClient)){
                clients.add(client);
            }
        }
        System.out.println("=============================================");
        return clients;
      
     }
    public Client          chercherClientParCin(String cin){
        System.out.println("\n=============================================");
        System.out.println("Chercher Client Par CIN");
        System.out.println("cinClient  : ");
        String cinClient=clavier.next();
        for(Client client:maBanque.getClientsDeBanque()){
            if(client.getCin().equals(cinClient)){
                return client;
            }
        }
        System.out.println("=============================================");
        return null;
            
            
     }
    public Client          chercherClientParEmail(String email){
        System.out.println("\n=============================================");
        System.out.println("Chercher Client Par Email");
        System.out.println("emailClient  : ");
        String emailClient=clavier.next();
        for(Client client:maBanque.getClientsDeBanque()){
            if(client.getEmail().equals(emailClient)){
                return client;
            }
        }
        System.out.println("=============================================");
        return null;
            
            
     }

    public Compte          chercherCompteParId(Long idCompte){
        System.out.println("\n=============================================");
        System.out.println("Chercher Compte Par Id");
        System.out.println("Numero Compte  : ");
        Long idCompteClient=clavier.nextLong();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                if(compte.getNumeroCompte().equals(idCompteClient)){
                    return compte;
                }
            }
        }
        System.out.println("=============================================");
        return null;
            
            
     }

    public List<Compte>    chercherCompteParSolde(double solde){
        System.out.println("\n=============================================");
        System.out.println("Chercher Compte Par Solde");
        System.out.println("Solde Compte  : ");
        double soldeCompte=clavier.nextDouble();
        List<Compte> comptes=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                if(compte.getSolde().equals(soldeCompte)){
                    comptes.add(compte);
                }
            }
        }
        System.out.println("=============================================");
        return comptes;
            
            
            
     }

    public List<Compte>    chercherCompteParDateCreation(LocalDateTime date){
        System.out.println("\n=============================================");
        System.out.println("Chercher Compte Par Date Creation");
        System.out.println("Date Creation Compte  : ");
        LocalDateTime dateCreationCompte=LocalDateTime.parse(clavier.next());
        List<Compte> comptes=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                if(compte.getDateCreation().equals(dateCreationCompte)){
                    comptes.add(compte);
                }
            }
        }
        System.out.println("=============================================");
        return comptes;
            
            
            
            
     }

    public List<Compte>    chercherCompteParPropriétaire(Client propriétaire){
        System.out.println("\n=============================================");
        System.out.println("Chercher Compte Par Propriétaire");
        System.out.println("idClient  : ");
        Long idClient=clavier.nextLong();
        Client client=chercherClientParId(idClient);
        List<Compte> comptes=new ArrayList<>();
        if(client!=null){
            for(Compte compte:client.getComptesClient()){
                comptes.add(compte);
            }
        }
        System.out.println("=============================================");
        return comptes;
              
     }

    public Client          modifierClient(String filtre){
        System.out.println("\n=============================================");
        System.out.println("Modifier Client");
        System.out.println("idClient  : ");
        Long idClient=clavier.nextLong();
        Client client=chercherClientParId(idClient);
        if(client!=null){
            System.out.println("Nouveau Nom  : ");
            String nom=clavier.next();
            System.out.println("Nouveau Prenom  : ");
            String prenom=clavier.next();
            System.out.println("Nouveau CIN  : ");
            String cin=clavier.next();
            System.out.println("Nouveau Email  : ");
            String email=clavier.next();
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setCin(cin);
            client.setEmail(email);
        }
        System.out.println("=============================================");
        return client;
            
            
     }

    public boolean         supprimerClient(Long id){
        System.out.println("\n=============================================");
        System.out.println("Supprimer Client");
        System.out.println("idClient  : ");
        Long idClient=clavier.nextLong();
        Client client=chercherClientParId(idClient);
        if(client!=null){
            maBanque.getClientsDeBanque().remove(client);
        }
        System.out.println("=============================================");
        return true;
            
            
            
     }

     public boolean         supprimerCompte(Long id){
        System.out.println("\n=============================================");
        System.out.println("Supprimer Compte");
        System.out.println("idCompte  : ");
        Long idCompte=clavier.nextLong();
        Compte compte=chercherCompteParId(idCompte);
        if(compte!=null){
            for(Client client:maBanque.getClientsDeBanque()){
                if(client.getComptesClient().contains(compte)){
                    client.getComptesClient().remove(compte);
                }
            }
        }
        System.out.println("=============================================");
        return true;
            
            
            
     }
        
 
     
    public TableauDeBord   calculerEtAfficherStatistiques(){
        System.out.println("\n=============================================");
        System.out.println("Calculer Et Afficher Statistiques");
        TableauDeBord tableauDeBord=new TableauDeBord();
        tableauDeBord.setNombreTotaleClient((long)maBanque.getClientsDeBanque().size());
        long nombreComptes=0;
        for(Client client:maBanque.getClientsDeBanque()){
            nombreComptes+=client.getComptesClient().size();
        }
        tableauDeBord.setNombreTotaleCompte(nombreComptes);
        double soldeTotal=0;
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                soldeTotal+=compte.getSolde();
            }
        }
        tableauDeBord.setMaxSolde(soldeTotal);
        System.out.println("=============================================");
        return tableauDeBord;
            
            
            
            
     }

    public List<Client>    trierClientParNom(){
        System.out.println("\n=============================================");
        System.out.println("Trier Client Par Nom");
        List<Client> clientsTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            clientsTries.add(client);
        }
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        System.out.println("=============================================");
        return clientsTries;
            
            
            
            
     }

        
            
    

    public List<Client>    trierClientParCin(){
        System.out.println("\n=============================================");
        System.out.println("Trier Client Par CIN");
        List<Client> clientsTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            clientsTries.add(client);
        }
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getCin().compareTo(o2.getCin());
            }
        });
        System.out.println("=============================================");
        return clientsTries;
            
            
            
            
            
     }

    public List<Client>    trierClientParEmail(){
        System.out.println("\n=============================================");
        System.out.println("Trier Client Par Email");
        List<Client> clientsTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            clientsTries.add(client);
        }
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });
        System.out.println("=============================================");
        return clientsTries;
            
            
            
            
            
            
     }

    public List<Client>    trierClientParAdresse(){
        System.out.println("\n=============================================");
        System.out.println("Trier Client Par Adresse");
        List<Client> clientsTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            clientsTries.add(client);
        }
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });
        System.out.println("=============================================");
        return clientsTries;
            
            
            
            
            
            
            
     }

    public List<Client>    trierClientParSoldeCompte(){
        System.out.println("\n=============================================");
        System.out.println("Trier Client Par Solde Compte");
        List<Client> clientsTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            clientsTries.add(client);
        }
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                double solde1=0;
                double solde2=0;
                for(Compte compte:o1.getComptesClient()){
                    solde1+=compte.getSolde();
                }
                for(Compte compte:o2.getComptesClient()){
                    solde2+=compte.getSolde();
                }
                if(solde1>solde2){
                    return 1;
                }else if(solde1<solde2){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println("=============================================");
        return clientsTries;
            
            
            
            
            
            
            
            
            
     }

    public List<Compte>    trierComptesParSolde(){
        System.out.println("\n=============================================");
        System.out.println("Trier Comptes Par Solde");
        List<Compte> comptesTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                comptesTries.add(compte);
            }
        }
        Collections.sort(comptesTries, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                if(o1.getSolde()>o2.getSolde()){
                    return 1;
                }else if(o1.getSolde()<o2.getSolde()){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println("=============================================");
        return comptesTries;
                
            
     }

    public List<Compte>    trierComptesParDateDeCreation(){
        System.out.println("\n=============================================");
        System.out.println("Trier Comptes Par Date De Creation");
        List<Compte> comptesTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                comptesTries.add(compte);
            }
        }
        Collections.sort(comptesTries, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                return o1.getDateCreation().compareTo(o2.getDateCreation());
            }
        });
        System.out.println("=============================================");
        return comptesTries;
            
            
            
            
            
            
            
            
            
     }
    

    public List<Compte>    trierComptesParNomPropriétaire(){
        System.out.println("\n=============================================");
        System.out.println("Trier Comptes Par Nom Propriétaire");
        List<Compte> comptesTries=new ArrayList<>();
        for(Client client:maBanque.getClientsDeBanque()){
            for(Compte compte:client.getComptesClient()){
                comptesTries.add(compte);
            }
        }
        Collections.sort(comptesTries, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                return o1.getPropriétaire().getNom().compareTo(o2.getPropriétaire().getNom());
            }
        });
        System.out.println("=============================================");
        return comptesTries;
            
    
            
     }

            
    

    
}
