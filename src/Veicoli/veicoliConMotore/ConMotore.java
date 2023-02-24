package Veicoli.veicoliConMotore;

import Veicoli.*;

import java.util.UUID;

public abstract class ConMotore extends Veicoli {
    protected String targa;
    protected Patenti patente;
    protected Alimentazione alimentazione ;

    public ConMotore(UUID id, String nome, String posizione,double tariffaAlMinuto,  String targa) {
        super(id, nome, posizione,  tariffaAlMinuto);
        this.targa = targa;
        this.alimentazione = Alimentazione.CARBURANTE;
    }
}
