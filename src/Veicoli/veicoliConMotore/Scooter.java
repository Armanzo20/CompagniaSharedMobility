package Veicoli.veicoliConMotore;

import Veicoli.Patenti;

import java.util.UUID;

public class Scooter extends ConMotore {
    public Scooter(UUID id, String nome, String posizione, double tariffaAlMinuto,  String targa, Patenti patente) {
        super(id, nome, posizione,  tariffaAlMinuto,  targa);
        this.serveCasco = true;
        this.patente = Patenti.SCOOTER;

    }
}
