package metier.clients;

import metier.authentification.IServiceIHM;

public interface IServiceIHMClient extends IServiceIHM {

    int menuModification();
    int menuRetrait();
    int menuInformations();
    
}
