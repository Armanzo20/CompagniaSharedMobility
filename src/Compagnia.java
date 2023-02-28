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
    Database.getInstance().addUtente(u);
  }

  public HashSet<Veicoli> cercaVeicoli(){
    HashSet<Veicoli> veicoli = new HashSet<>();
    for (UUID veicolo : Database.getInstance().getDisponibili()) {
      veicoli.add(Database.getVeicoloDaId(veicolo));
    }
    return veicoli;
  }

  public void restituisci(UUID idUtente, UUID idVeicolo){
    Database.addIDveicoliDisponibili(idVeicolo);
    Database.getInstance().getIDUtenteVeicoliAffitatti().remove(idUtente, idVeicolo);
  }


  public void aggiungiNoleggio(Noleggio n){
    Database.getInstance().getDisponibili().remove(n.getVeicolo().getId());
    Database.getInstance().addAffittati(n.getUtente().getId(), n.getVeicolo().getId());
    Database.getInstance().getNoleggi().add(n);
  }

  public void fineNoleggio(Noleggio n){
    Database.getInstance().getDisponibili().add(n.getVeicolo().getId());
    Database.getInstance().removeAffittati(n.getUtente().getId());

  }

}
