import Veicoli.Patenti;
import Veicoli.Veicoli;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Utente {

    private UUID id;
    private String nome,cognome,codice_fiscale;
    private double credito;

    private boolean haCasco;
    private String datadinascita;

    private HashSet<Patenti> patenti;

    public Utente(String nome, String cognome, String codice_fiscale, boolean haCasco, String datadinascita, HashSet<Patenti> patenti) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.credito = 0;
        this.haCasco = haCasco;
        this.datadinascita = datadinascita;
        this.patenti = patenti;
    }

    public void ricarica(double amount){
        credito += amount;
    }

    public HashSet<UUID> cercaVeicolo(){
        return Database.getDisponibili();
    }

    public void affitta(UUID veicolo, int min){
        if(!Database.getDisponibili().contains(veicolo)){
            System.out.println("id non trovato");
            return;
        }
        Veicoli v_ogg = Database.getVeicoloDaId(veicolo);
        if(v_ogg.isDisponibile(min)){
            Database.addAffittati(this.id, veicolo);
            Database.getDisponibili().remove(veicolo);
        } else {
            System.out.println("non trovato");
        }

    }

    public void restituisci(UUID veicolo){
        Veicoli v_ogg = Database.getVeicoloDaId(veicolo);
        Database.addDisponibili(veicolo);
        Database.getAffittati().remove(this.id, veicolo);

    }

    public void registrati(){//fai questo};
}
