package metier.admin;

import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.TableauDeBord;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceAdmin {

    public Client          nouveauClient();
    public Client          nouveauCompteClientExistant();

    public Client          chercherClientParId(Long id);
    public List<Client>    chercherClientParNom(String nom);
    public List<Client>    chercherClientParPrénom(String prenom);
    public Client          chercherClientParCin(String cin);
    public Client          chercherClientParEmail(String email);

    public Compte          chercherCompteParId(Long idCompte);
    public List<Compte>    chercherCompteParSolde(double solde);
    public List<Compte>    chercherCompteParDateCreation(LocalDateTime date);
    public List<Compte>    chercherCompteParPropriétaire(Client propriétaire);

    public Client          modifierClient(String filtre);
    public boolean         supprimerClient(Long id);

    public TableauDeBord   calculerEtAfficherStatistiques();

    public List<Client>    trierClientParNom();
    public List<Client>    trierClientParCin();
    public List<Client>    trierClientParEmail();
    public List<Client>    trierClientParAdresse();
    public List<Client>    trierClientParSoldeCompte();
    public List<Compte>    trierComptesParSolde();
    public List<Compte>    trierComptesParDateDeCreation();
    public List<Compte>    trierComptesParNomPropriétaire();

}
