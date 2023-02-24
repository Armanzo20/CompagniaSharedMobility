package Veicoli;

import java.util.UUID;

public class Bicicletta extends Veicoli {
    public Bicicletta(UUID id, String nome, String posizione,  double tariffaAlMinuto) {
        super(id, nome, posizione,  tariffaAlMinuto);
        this.serveCasco = true;
    }


}
