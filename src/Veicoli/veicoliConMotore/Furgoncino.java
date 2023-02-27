package Veicoli.veicoliConMotore;

import Veicoli.Patenti;

import java.util.UUID;

public class Furgoncino extends ConMotore {
    protected Furgoncino(ConMotoreBuilder cb){
        super(cb);
        this.patente = Patenti.FURGONCINO;
    }
}
