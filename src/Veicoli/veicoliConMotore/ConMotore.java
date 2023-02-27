package Veicoli.veicoliConMotore;

import Veicoli.*;

public abstract class ConMotore extends Veicoli {
    protected String targa;
    protected Patenti patente;
    protected Alimentazione alimentazione ;
    protected int consumo;

    protected ConMotore(ConMotoreBuilder cb){
        super(cb);
        this.consumo = cb.getConsumo();
        this.alimentazione = cb.getAlimentazione();
        this.targa = cb.getTarga();
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
