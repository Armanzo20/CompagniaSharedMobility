import Veicoli.Patenti;
import Veicoli.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

public class Utente {

    private final UUID id;
    private final String nome,cognome,codice_fiscale;
    private double credito;

    private final boolean haCasco;
    private final String datadinascita;

    private HashSet<Patenti> patenti = new HashSet<Patenti>();


    protected Utente(UserBuilder u){
        this.id = UUID.randomUUID();
        this.nome = u.getNome();
        this.cognome = u.getCognome();
        this.codice_fiscale = u.getCodice_fiscale();
        this.credito = 0;
        this.datadinascita = u.getDataDiNascita();
        this.haCasco = u.getHaCasco();
    }


    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public double getCredito() {
        return credito;
    }

    public boolean isHaCasco() {
        return haCasco;
    }

    public String getDatadinascita() {
        return datadinascita;
    }

    public HashSet<Veicoli.Patenti> getPatenti() {
        return patenti;
    }

    public void addPatente(Patenti patente){
        this.patenti.add(patente);
    }

    public void ricarica(double amount){
        credito += amount;
    }

    public HashSet<Veicoli> cercaVeicoli(){
        HashSet<Veicoli> veicoli = Compagnia.getInstance().cercaVeicoli();
        HashSet<Veicoli> veicoliBuoni = new HashSet<Veicoli>();
        // check
        for (Veicoli veicolo : veicoli) {
            if (this.patenti.contains(veicolo.getPatente())){
                veicoliBuoni.add(veicolo);
            }
        }
        return veicoliBuoni;
    }

    public void affitta(UUID veicolo, int min){
        /*if(!Database.getDisponibili().contains(veicolo)){
            System.out.println("id non trovato");
            return;
        }*/
        Veicoli v_ogg = Database.getVeicoloDaId(veicolo);
        if(this.credito > (v_ogg.getTariffaAlMinuto() * min)) {
            /*if (v_ogg.isDisponibile(min)) {
                Database.addAffittati(this.id, veicolo);
                Database.getDisponibili().remove(veicolo);
            } else {
                System.out.println("non trovato");
            }*/
        }
        else System.out.println("Ti mancano " + ((v_ogg.getTariffaAlMinuto() * min) - this.credito));

    }

    public void restituisci(UUID veicolo){
        Compagnia.getInstance().restituisci(this.id, veicolo);
    }


    public static Utente parseCsv(String userCsv) {
        String[] values = userCsv.split(",");
        Utente u = (new UserBuilder().ID().nome(values[0]).cognome(values[1]).codice_fiscale(values[2]).dataDiNascita(values[3]).haCasco(Boolean.parseBoolean(values[4])).build());
        return u;
    }

}
