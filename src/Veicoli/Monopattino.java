package Veicoli;

import java.util.UUID;

public class Monopattino extends Veicoli {
    private Alimentazione alimentazione ;

    protected Monopattino(VeicoliBuilder vb){
        super(vb);
    }

    @Override
    public boolean isDisponibile(int min){
        if(!super.isDisponibile(min)){
            return false;
        }
        if(alimentazione.getPercentuale() > alimentazione.consumo * min)
            return true;
        return false;
    }

    @Override
    public Patenti getPatente() {
        return null;
    }
}
