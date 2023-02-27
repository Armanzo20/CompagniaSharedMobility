import java.util.HashSet;
import java.util.UUID;
import Veicoli.*;

public class UserBuilder {
  private String nome,cognome,codice_fiscale;
  private String dataDiNascita;
  private boolean haCasco = false;

  public UserBuilder(){}

  public UserBuilder nome(String nome){
    this.nome = nome;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public UserBuilder cognome(String cognome){
    this.cognome = cognome;
    return this;
  }

  public String getCognome() {
    return cognome;
  }

  public UserBuilder codice_fiscale(String codice_fiscale){
    this.codice_fiscale = codice_fiscale;
    return this;
  }

  public String getCodice_fiscale() {
    return codice_fiscale;
  }

  public UserBuilder dataDiNascita(String dataDiNascita){
    this.dataDiNascita = dataDiNascita;
    return this;
  }

  public String getDataDiNascita() {
    return dataDiNascita;
  }
  public UserBuilder haCasco(boolean haCasco){
    this.haCasco = haCasco;
    return this;
  }
  public boolean getHaCasco(){
    return this.haCasco;
  }

  public Utente build(){
    return new Utente(this);
  }
}
