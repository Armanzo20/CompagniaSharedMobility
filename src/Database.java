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
    private static HashSet<Veicoli> id_veicoli;

    private static HashSet<UUID> disponibili;

    private static HashMap<UUID, UUID> affittati;

    private static HashSet<Utente> utenti;

    private static Path usersCsv ;



    private Database(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.utenti = new HashSet<>();

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

    }

    public static Database getInstance(){
        if (database != null){
            return database;
        }
        database = new Database(usersCsv);
        return database;
    }


    public static void addDisponibili(UUID id){
        disponibili.add(id);
    }


    public static Veicoli getVeicoloDaId(UUID id){
        Veicoli v;
        for(Veicoli i : id_veicoli){
            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

    public HashSet<Veicoli> getId_veicoli() {
        return id_veicoli;
    }

    public HashSet<UUID> getDisponibili() {
        return disponibili;
    }

    public HashMap<UUID, UUID> getAffittati() {
        return affittati;
    }

    public static void add(Veicoli v){
        id_veicoli.add(v);
        disponibili.add(v.getId());
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
        affittati.put(id_utente, id_veicolo);
    }
}
