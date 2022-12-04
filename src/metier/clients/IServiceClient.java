package metier.clients;

import presentation.modele.Compte;

public interface IServiceClient {

        boolean versement();
        boolean retrait  ();

        boolean retrait  (int choixRetrait);
        boolean virement ();
        boolean modifierProfile(int choixModification);
        void dernièresOpérations();
        Double afficherSolde();
        Compte choisirCompte();

        void afficherTicket();

}
