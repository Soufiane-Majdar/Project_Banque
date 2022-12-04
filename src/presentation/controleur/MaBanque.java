package presentation.controleur;

import metier.authentification.IAuth;
import presentation.modele.Banque;

import java.util.Scanner;

public class MaBanque {
        public static IAuth loginService;

        public static void main(String[] args) {

                Banque maBanque
                        = new Banque(   "BP",
                                        "Hassan Rabat",
                                        "212535224433",
                                        "bp@banquePop.ma");


                Scanner clavier = new Scanner(System.in);
                //loginService = new ServiceAuth(maBanque, clavier);
                loginService.seConnecter();

                clavier.close();

        }

}
