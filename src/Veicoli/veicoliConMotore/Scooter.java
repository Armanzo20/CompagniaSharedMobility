package Veicoli.veicoliConMotore;

import Veicoli.Patenti;

import java.util.UUID;

public class Scooter extends ConMotore {
    protected Scooter(ConMotoreBuilder cb){
        super(cb);
        this.patente = Patenti.SCOOTER;
        this.serveCasco = true;
    }
}
