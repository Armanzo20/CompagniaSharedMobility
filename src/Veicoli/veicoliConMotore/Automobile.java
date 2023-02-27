package Veicoli.veicoliConMotore;

import Veicoli.*;

public class Automobile extends ConMotore {
    protected Automobile(ConMotoreBuilder vb){
        super(vb);
        this.patente = Patenti.AUTOMOBILE;
    }
}
