package presentation.modele;

public class Admin  extends Utilisateur{

    private static  Admin ADMIN = new Admin();

    private Admin(){

        login       = "admin";
        motDePasse  = "1234";
        role        = "Admin";
        nom         =  "Admin";
        prenom      = "Soufiane";

    }


    public static Admin getInstance(){

        return ADMIN;
    }

}
