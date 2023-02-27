package Veicoli;

import Veicoli.veicoliConMotore.Automobile;

public class VeicoliBuilder {
  private String nome;
  private String posizione;
  private double tariffaAlMinuto;

  public VeicoliBuilder(){}

  public VeicoliBuilder nome(String nome) {
    this.nome = nome;
    return this;
  }

  public VeicoliBuilder posizione(String posizione) {
    this.posizione = posizione;
    return this;
  }


  public VeicoliBuilder tariffaAlMinuto(double tariffaAlMinuto) {
    this.tariffaAlMinuto = tariffaAlMinuto;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public String getPosizione() {
    return posizione;
  }

  public double getTariffaAlMinuto() {
    return tariffaAlMinuto;
  }

  public Bicicletta buildBicicletta(){
    return new Bicicletta(this);
  }
  public Monopattino buildMonopattino(){
    return new Monopattino(this);
  }


}
