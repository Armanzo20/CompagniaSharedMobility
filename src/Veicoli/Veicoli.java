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
    public  boolean isDisponibile(int minuti){
        if(minuti < tempoMinimoMinuti){
            System.out.println("Almeno 5 minuti di corsa");
            return false;
        }
        if(!eAffittato)
            return true;
        else
            System.out.println("Il veicolo è già stato affittato");

        return true;
    }

    public UUID getId(){
        return id;
    }
}
