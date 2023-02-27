import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.UUID;

import Veicoli.*;

public class Compagnia {
  private static Compagnia internalInstance;

  private Compagnia(){}

  public static Compagnia getInstance(){
    if (internalInstance != null){
      return internalInstance;
    }
    internalInstance = new Compagnia();
    return internalInstance;
  }

  public void registra(Utente u){
    Database.addUtente(u);
  }

  public HashSet<Veicoli> cercaVeicoli(){
    HashSet<Veicoli> veicoli = new HashSet<>();
    for (UUID veicolo : Database.getDisponibili()) {
      veicoli.add(Database.getVeicoloDaId(veicolo));
    }
    return veicoli;
  }

  public void restituisci(UUID idUtente, UUID idVeicolo){
    Database.addDisponibili(idVeicolo);
    Database.getAffittati().remove(idUtente, idVeicolo);
  }
}
