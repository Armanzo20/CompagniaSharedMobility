package Veicoli.veicoliConMotore;

import Veicoli.*;

import java.util.UUID;

public abstract class ConMotore extends Veicoli {
    protected String targa;
    protected Patenti patente;
    protected Alimentazione alimentazione ;
    protected int consumo;

    public ConMotore(UUID id, String nome, String posizione,double tariffaAlMinuto,  String targa) {
        super(id, nome, posizione,  tariffaAlMinuto);
        this.targa = targa;
        this.alimentazione = Alimentazione.CARBURANTE;
        alimentazione.setConsumo(1);
    }

    @Override
    public Patenti getPatente() {
        return patente;
    }

    @Override
    public boolean isDisponibile(int minuti){
        if(!super.isDisponibile(minuti)){
            return false;
        }
        if(alimentazione.getPercentuale() > alimentazione.consumo * minuti)
            return true;
        return false;
    }
}
