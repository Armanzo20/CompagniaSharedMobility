package Veicoli;

import java.util.UUID;

public class Monopattino extends Veicoli {
    private Alimentazione alimentazione ;

    public Monopattino(UUID id, String nome, String posizione,double tariffaAlMinuto) {
        super(id, nome, posizione,  tariffaAlMinuto);
        this.alimentazione = Alimentazione.ELETTRICO;
    }
}
