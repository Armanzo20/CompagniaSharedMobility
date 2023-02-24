package Veicoli;

import java.util.UUID;

public class Monopattino extends Veicoli {
    private Alimentazione alimentazione ;

    public Monopattino(UUID id, String nome, String posizione,double tariffaAlMinuto) {
        super(id, nome, posizione,  tariffaAlMinuto);
        this.alimentazione = Alimentazione.ELETTRICO;
        alimentazione.setConsumo(1);
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
}
