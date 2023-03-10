package Veicoli;

import java.util.UUID;

public  class Veicoli {
    protected final UUID id ;
    protected final String nome;
    protected final String posizione;
    protected boolean serveCasco = false;
    protected final double tariffaAlMinuto;
    protected boolean eAffittato = false;
    protected final int tempoMinimoMinuti = 5 ;

    protected Veicoli(VeicoliBuilder v){
        this.id = UUID.randomUUID();
        this.nome = v.getNome();
        this.posizione = v.getPosizione();
        this.tariffaAlMinuto = v.getTariffaAlMinuto();
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

    public double getTariffaAlMinuto() {
        return tariffaAlMinuto;
    }

    public UUID getId(){
        return id;
    }

    public  Patenti getPatente(){
        return null;
    };



    public static Veicoli parseCsv(String veioliCsv) {
        String[] values = veioliCsv.split(",");
        Veicoli v = (new VeicoliBuilder().ID().nome(values[0]).posizione(values[1]).tariffaAlMinuto(Double.parseDouble(values[2])).buildVeicolo());
        return v;
    }


    @Override
    public String toString() {
        return "Veicoli{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", posizione='" + posizione + '\'' +
        ", tariffaAlMinuto=" + tariffaAlMinuto +
        '}';
    }
}
