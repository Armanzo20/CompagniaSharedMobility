package Veicoli.veicoliConMotore;

import Veicoli.Patenti;

import java.util.UUID;

public class Furgoncino extends ConMotore {
    public Furgoncino(UUID id, String nome, String posizione, double tariffaAlMinuto, String targa ) {
        super(id, nome, posizione, tariffaAlMinuto,  targa);
        this.patente = Patenti.FURGONCINO;
    }
}
