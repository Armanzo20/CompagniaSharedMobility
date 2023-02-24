package Veicoli.veicoliConMotore;

import Veicoli.*;
import java.util.UUID;

public class Automobile extends ConMotore {
    public Automobile(UUID id, String nome, String posizione, double tariffaAlMinuto, String targa) {
        super(id, nome, posizione,  tariffaAlMinuto,  targa);
        this.patente = Patenti.AUTOMOBILE;
    }
}
