package Veicoli;

import java.util.UUID;

public class Bicicletta extends Veicoli {
    protected Bicicletta(VeicoliBuilder v){
        super(v);
        this.serveCasco = true;
    }

    @Override
    public Patenti getPatente() {
        return null;
    }


}
