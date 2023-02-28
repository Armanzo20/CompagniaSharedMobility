import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import Veicoli.*;
import Veicoli.veicoliConMotore.ConMotore;

public class Database {

    private static Database database;
    private static HashSet<Veicoli> veicoli;

    private static HashSet<UUID> IDveicoliDisponibili;

    private static HashMap<UUID, UUID> IDUtenteVeicoliAffitatti;

    private static HashSet<Utente> utenti;

    private static HashSet<Noleggio> noleggi;
    private static Path usersCsv ;

    private static Path veicoliCsv;



    private Database(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.utenti = new HashSet<>();
        this.veicoliCsv = veicoliCsv;
        this.veicoli = new HashSet<>();

        try {
            if (!Files.exists(usersCsv))
                Files.createFile(usersCsv);
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedReader br = Files.newBufferedReader(usersCsv)) {
            String line;
            while ((line = br.readLine()) != null) {
                this.utenti.add(Utente.parseCsv(line));
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        try {
            if (!Files.exists(veicoliCsv))
                Files.createFile(veicoliCsv);
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedReader br = Files.newBufferedReader(veicoliCsv)) {
            String line;
            while ((line = br.readLine()) != null) {
                this.veicoli.add(Veicoli.parseCsv(line));
            }
        }
        catch (IOException e) { e.printStackTrace(); }

    }

    public static Database getInstance(){
        if (database != null){
            return database;
        }
        database = new Database(usersCsv);
        return database;
    }


    public static void addIDveicoliDisponibili(UUID id){
        IDveicoliDisponibili.add(id);
    }


    public static Veicoli getVeicoloDaId(UUID id){
        Veicoli v;
        for(Veicoli i : veicoli){
            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

    public HashSet<Veicoli> getVeicoli() {
        return veicoli;
    }

    public HashSet<UUID> getDisponibili() {
        return IDveicoliDisponibili;
    }

    public HashMap<UUID, UUID> getIDUtenteVeicoliAffitatti() {
        return IDUtenteVeicoliAffitatti;
    }

    public static HashSet<Noleggio> getNoleggi() {
        return noleggi;
    }

    public static void add(Veicoli v){
        veicoli.add(v);
        IDveicoliDisponibili.add(v.getId());
    }

    public  void addUtente(Utente u){
        utenti.add(u);
        try(BufferedWriter bw = Files.newBufferedWriter(this.usersCsv)) {
            bw.write(u.getId() + ";" + u.getNome() + ";" + u.getCognome() + ";" + u.getCodice_fiscale() + ";"+ u.getDatadinascita() +";"+ u.isHaCasco() + ";" + u.isHaCasco());
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
    public void addAffittati(UUID id_utente, UUID id_veicolo){
        IDUtenteVeicoliAffitatti.put(id_utente, id_veicolo);
    }

    public void removeAffittati(UUID id_utente){
        IDUtenteVeicoliAffitatti.remove(id_utente);
    }

}
