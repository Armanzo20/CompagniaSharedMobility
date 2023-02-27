import Veicoli.Patenti;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Compagnia compagnia = Compagnia.getInstance();
        Utente u1 = new Utente("a", "b", "abc", true, "10/10/2010");
        u1.addPatente(Patenti.AUTOMOBILE);
        compagnia.registra(u1);
    }
}