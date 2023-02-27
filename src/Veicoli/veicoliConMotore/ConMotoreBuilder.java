package Veicoli.veicoliConMotore;

import Veicoli.Alimentazione;
import Veicoli.VeicoliBuilder;

/**
 * Ne serve un altro perché costruttori protected
 */
public class ConMotoreBuilder extends VeicoliBuilder {
  private String targa;
  private Alimentazione alimentazione;
  private int consumo;

  public ConMotoreBuilder(){}
  public ConMotoreBuilder nome(String nome) {
    super.nome(nome);
    return this;
  }

  public VeicoliBuilder posizione(String posizione) {
    super.posizione(posizione);
    return this;
  }


  public VeicoliBuilder tariffaAlMinuto(double tariffaAlMinuto) {
    super.tariffaAlMinuto(tariffaAlMinuto);
    return this;
  }
  public ConMotoreBuilder targa(String targa){
    this.targa = targa;
    return this;
  }

  public ConMotoreBuilder consumo(int consumo) {
    this.consumo = consumo;
    return this;
  }
  public ConMotoreBuilder alimentazione(Alimentazione alimentazione) {
    this.alimentazione = alimentazione;
    return this;
  }

  public String getTarga() {
    return targa;
  }


  public Alimentazione getAlimentazione() {
    return alimentazione;
  }

  public int getConsumo() {
    return consumo;
  }

  public Automobile buildAutomobile(){
    return new Automobile(this);
  }
  public Furgoncino buildFurgoncino(){
    return new Furgoncino(this);
  }
  public Scooter buildScooter(){
    return new Scooter(this);
  }
}
