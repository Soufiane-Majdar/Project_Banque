package metier.authentification;

import presentation.modele.Banque;

import java.util.Scanner;

public class ServiceAuth implements IAuth{

    private Banque maBanque;
    private Scanner clavier;

    public ServiceAuth(Banque maBanque, Scanner clavier) {
        this.maBanque = maBanque;
        this.clavier = clavier;
    }



    public void seConnecter() {
        // TODO Auto-generated method stub
    }


    public void SeDéconnecter() {
        // TODO Auto-generated method stub
    }

    
}
