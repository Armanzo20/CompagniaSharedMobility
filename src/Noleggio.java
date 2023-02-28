import Veicoli.Veicoli;
import Veicoli.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

public class Noleggio {
    protected UUID id;
    protected int durataInMin ;
    protected Utente utente;
    protected Veicoli veicolo ;
    protected Posizione posizioneIniziale;
    protected Posizione posizioneFinale;

    protected int minuti ;
    protected double pagato;



    public Noleggio() {
        this.id = UUID.randomUUID();
    }

    public void iniziaNoleggio(Utente utente, Veicoli veicolo, Posizione posizione){
        this.utente = utente ;
        this.veicolo = veicolo ;
        this.posizioneIniziale = posizione;
    }

    public double fineNoleggio(Posizione posizioneFinale, int durataInMin){
        this.posizioneFinale = posizioneFinale;
        this.durataInMin = durataInMin;
        return calcolaPrezzo();
    }

    public double calcolaPrezzo(){
        return durataInMin * veicolo.getTariffaAlMinuto();
    }

    public UUID getId() {
        return id;
    }


    public Utente getUtente() {
        return utente;
    }

    public Veicoli getVeicolo() {
        return veicolo;
    }

    public Posizione getPosizione() {
        return posizioneIniziale;
    }
}
