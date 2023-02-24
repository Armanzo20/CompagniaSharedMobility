package Veicoli;

import java.util.UUID;

public abstract class Veicoli {
    protected UUID id ;
    protected String nome;
    protected String posizione;
    protected boolean serveCasco = false;
    protected double tariffaAlMinuto;
    protected boolean eAffittato = false;
    protected final int tempoMinimoMinuti = 5 ;

    public Veicoli(UUID id, String nome, String posizione,  double tariffaAlMinuto) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.tariffaAlMinuto = tariffaAlMinuto;
    }
}
