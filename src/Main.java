import Veicoli.veicoliConMotore.Automobile;
import Veicoli.VeicoliBuilder;
import Veicoli.veicoliConMotore.ConMotoreBuilder;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Compagnia compagnia = Compagnia.getInstance();
        Utente u1 = new UserBuilder().nome("a").cognome("b").dataDiNascita("10/10/2010").haCasco(true).build();
        Automobile a1 = new ConMotoreBuilder().targa("abc").nome("aa").buildAutomobile();
        System.out.println("");

    }
}