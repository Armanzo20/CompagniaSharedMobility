import Veicoli.Patenti;

import java.time.LocalDateTime;
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



}
