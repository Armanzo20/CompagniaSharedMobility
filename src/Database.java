import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import Veicoli.*;

public class Database {
    private static HashSet<Veicoli> id_veicoli;

    private static HashSet<UUID> disponibili;

    private static HashMap<UUID, UUID> affittati;

    private static HashSet<Utente> utenti;


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

    public static HashSet<Veicoli> getId_veicoli() {
        return id_veicoli;
    }

    public static HashSet<UUID> getDisponibili() {
        return disponibili;
    }

    public static HashMap<UUID, UUID> getAffittati() {
        return affittati;
    }

    public static void add(Veicoli v){
        id_veicoli.add(v);
        disponibili.add(v.getId());
    }

    public static void addAffittati(UUID id_utente, UUID id_veicolo){
        affittati.put(id_utente, id_veicolo);
    }
}
